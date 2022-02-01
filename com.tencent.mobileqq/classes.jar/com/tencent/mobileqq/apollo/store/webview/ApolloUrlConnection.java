package com.tencent.mobileqq.apollo.store.webview;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

public class ApolloUrlConnection
{
  private ApolloSSOConfig.CGIConfig jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig;
  private BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private String jdField_a_of_type_JavaLangString;
  private HttpURLConnection jdField_a_of_type_JavaNetHttpURLConnection;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public ApolloUrlConnection(String paramString1, boolean paramBoolean, ApolloSSOConfig.CGIConfig paramCGIConfig, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig = paramCGIConfig;
    this.b = paramString2;
  }
  
  private BufferedInputStream a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedInputStream == null)
      {
        Object localObject1 = this.jdField_a_of_type_JavaNetHttpURLConnection;
        if (localObject1 != null) {
          try
          {
            localObject1 = this.jdField_a_of_type_JavaNetHttpURLConnection.getInputStream();
            if ("gzip".equalsIgnoreCase(this.jdField_a_of_type_JavaNetHttpURLConnection.getContentEncoding())) {
              this.jdField_a_of_type_JavaIoBufferedInputStream = new BufferedInputStream(new GZIPInputStream((InputStream)localObject1));
            } else {
              this.jdField_a_of_type_JavaIoBufferedInputStream = new BufferedInputStream((InputStream)localObject1);
            }
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getResponseStream error:");
            localStringBuilder.append(localThrowable.getMessage());
            localStringBuilder.append(".");
            QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 2, localStringBuilder.toString());
          }
        }
      }
      BufferedInputStream localBufferedInputStream = this.jdField_a_of_type_JavaIoBufferedInputStream;
      return localBufferedInputStream;
    }
    finally {}
  }
  
  /* Error */
  int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   6: ifnonnull +972 -> 978
    //   9: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   12: lstore 5
    //   14: ldc 95
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 20	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_Boolean	Z
    //   22: ifeq +92 -> 114
    //   25: aload_0
    //   26: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: invokestatic 101	com/tencent/mobileqq/apollo/store/webview/ApolloClientUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +43 -> 80
    //   40: new 60	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc 107
    //   53: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   62: lload 5
    //   64: lsub
    //   65: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 74
    //   71: iconst_2
    //   72: aload 7
    //   74: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload 8
    //   82: astore 7
    //   84: aload 8
    //   86: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +25 -> 114
    //   92: aload 8
    //   94: astore 7
    //   96: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +15 -> 114
    //   102: ldc 74
    //   104: iconst_2
    //   105: ldc 121
    //   107: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload 8
    //   112: astore 7
    //   114: aload_0
    //   115: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   118: astore 10
    //   120: aconst_null
    //   121: astore 9
    //   123: iconst_1
    //   124: istore_2
    //   125: aload 9
    //   127: astore 8
    //   129: aload 10
    //   131: ifnull +301 -> 432
    //   134: aload 9
    //   136: astore 8
    //   138: aload_0
    //   139: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   142: invokevirtual 128	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:a	()Z
    //   145: ifeq +287 -> 432
    //   148: aload 9
    //   150: astore 8
    //   152: aload_0
    //   153: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +273 -> 432
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   167: getfield 129	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: putfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   173: aload_0
    //   174: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   177: iconst_1
    //   178: invokevirtual 132	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:a	(Z)Ljava/lang/String;
    //   181: astore 10
    //   183: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +39 -> 225
    //   189: new 60	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   196: astore 8
    //   198: aload 8
    //   200: ldc 134
    //   202: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 8
    //   208: aload 10
    //   210: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 74
    //   216: iconst_2
    //   217: aload 8
    //   219: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload 10
    //   227: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +769 -> 999
    //   233: ldc 136
    //   235: aload_0
    //   236: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   239: getfield 137	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:b	Ljava/lang/String;
    //   242: invokevirtual 140	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   245: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +751 -> 999
    //   251: aload_0
    //   252: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: astore 8
    //   257: bipush 63
    //   259: istore_1
    //   260: aload 8
    //   262: bipush 63
    //   264: invokevirtual 148	java/lang/String:indexOf	(I)I
    //   267: istore_3
    //   268: aload_0
    //   269: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: bipush 35
    //   274: invokevirtual 148	java/lang/String:indexOf	(I)I
    //   277: istore 4
    //   279: iload_3
    //   280: iconst_m1
    //   281: if_icmpne +712 -> 993
    //   284: goto +3 -> 287
    //   287: iload 4
    //   289: iconst_m1
    //   290: if_icmpne +39 -> 329
    //   293: new 60	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   300: astore 8
    //   302: aload 8
    //   304: aload_0
    //   305: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 8
    //   314: iload_1
    //   315: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 8
    //   321: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore 8
    //   326: goto +57 -> 383
    //   329: new 60	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   336: astore 8
    //   338: aload 8
    //   340: aload_0
    //   341: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: iconst_0
    //   345: iload 4
    //   347: invokevirtual 155	java/lang/String:substring	(II)Ljava/lang/String;
    //   350: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 8
    //   356: iload_1
    //   357: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 8
    //   363: aload_0
    //   364: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   367: iload 4
    //   369: invokevirtual 158	java/lang/String:substring	(I)Ljava/lang/String;
    //   372: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 8
    //   378: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: astore 8
    //   383: aload_0
    //   384: aload 8
    //   386: putfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: new 60	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   396: astore 8
    //   398: aload 8
    //   400: aload_0
    //   401: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   404: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 8
    //   410: aload 10
    //   412: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_0
    //   417: aload 8
    //   419: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: putfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   425: aload 9
    //   427: astore 8
    //   429: goto +3 -> 432
    //   432: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +41 -> 476
    //   438: new 60	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   445: astore 9
    //   447: aload 9
    //   449: ldc 160
    //   451: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 9
    //   457: aload_0
    //   458: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 74
    //   467: iconst_2
    //   468: aload 9
    //   470: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_0
    //   477: new 162	java/net/URL
    //   480: dup
    //   481: aload_0
    //   482: getfield 18	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   485: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   488: invokevirtual 169	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   491: checkcast 34	java/net/HttpURLConnection
    //   494: putfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   497: aload_0
    //   498: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   501: ifnonnull +15 -> 516
    //   504: ldc 74
    //   506: iconst_1
    //   507: ldc 171
    //   509: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: monitorexit
    //   514: iconst_m1
    //   515: ireturn
    //   516: aload_0
    //   517: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   520: sipush 5000
    //   523: invokevirtual 175	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   526: aload_0
    //   527: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   530: sipush 15000
    //   533: invokevirtual 178	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   536: aload_0
    //   537: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   540: iconst_0
    //   541: invokevirtual 182	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   544: aload_0
    //   545: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   548: ldc 184
    //   550: aload 7
    //   552: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload_0
    //   556: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   559: ldc 190
    //   561: ldc 40
    //   563: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: ldc 192
    //   568: invokestatic 195	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   571: ldc 95
    //   573: iconst_0
    //   574: invokestatic 198	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   577: astore 7
    //   579: aload_0
    //   580: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   583: ldc 200
    //   585: aload 7
    //   587: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   594: ifnull +69 -> 663
    //   597: aload_0
    //   598: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   601: getfield 203	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   604: invokevirtual 209	java/util/HashMap:keySet	()Ljava/util/Set;
    //   607: invokeinterface 215 1 0
    //   612: astore 7
    //   614: aload 7
    //   616: invokeinterface 220 1 0
    //   621: ifeq +42 -> 663
    //   624: aload 7
    //   626: invokeinterface 224 1 0
    //   631: checkcast 46	java/lang/String
    //   634: astore 9
    //   636: aload_0
    //   637: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   640: aload 9
    //   642: aload_0
    //   643: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   646: getfield 203	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   649: aload 9
    //   651: invokevirtual 227	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   654: checkcast 46	java/lang/String
    //   657: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: goto -46 -> 614
    //   663: aload_0
    //   664: getfield 24	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:b	Ljava/lang/String;
    //   667: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +29 -> 699
    //   673: aload_0
    //   674: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   677: ldc 229
    //   679: aload_0
    //   680: getfield 24	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:b	Ljava/lang/String;
    //   683: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   690: ldc 231
    //   692: aload_0
    //   693: getfield 24	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:b	Ljava/lang/String;
    //   696: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload_0
    //   700: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   703: ifnull +303 -> 1006
    //   706: aload_0
    //   707: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   710: invokevirtual 128	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:a	()Z
    //   713: ifeq +293 -> 1006
    //   716: ldc 136
    //   718: aload_0
    //   719: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   722: getfield 137	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:b	Ljava/lang/String;
    //   725: invokevirtual 140	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   728: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   731: ifeq +31 -> 762
    //   734: aload_0
    //   735: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   738: iconst_0
    //   739: invokevirtual 234	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   742: aload_0
    //   743: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   746: iconst_1
    //   747: invokevirtual 237	java/net/HttpURLConnection:setDoInput	(Z)V
    //   750: aload_0
    //   751: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   754: ldc 239
    //   756: invokevirtual 242	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   759: goto +247 -> 1006
    //   762: ldc 244
    //   764: aload_0
    //   765: getfield 22	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig	Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   768: getfield 137	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:b	Ljava/lang/String;
    //   771: invokevirtual 140	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   774: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   777: ifeq +229 -> 1006
    //   780: aload_0
    //   781: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   784: iconst_1
    //   785: invokevirtual 234	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   788: aload_0
    //   789: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   792: iconst_1
    //   793: invokevirtual 237	java/net/HttpURLConnection:setDoInput	(Z)V
    //   796: aload_0
    //   797: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   800: ldc 246
    //   802: invokevirtual 242	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   805: aload 8
    //   807: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   810: ifne +196 -> 1006
    //   813: new 248	java/io/OutputStreamWriter
    //   816: dup
    //   817: aload_0
    //   818: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   821: invokevirtual 252	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   824: invokespecial 255	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   827: astore 7
    //   829: aload 7
    //   831: aload 8
    //   833: invokevirtual 258	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   836: aload 7
    //   838: invokevirtual 261	java/io/OutputStreamWriter:flush	()V
    //   841: aload 7
    //   843: invokevirtual 264	java/io/OutputStreamWriter:close	()V
    //   846: goto +3 -> 849
    //   849: iload_2
    //   850: ifne +10 -> 860
    //   853: aload_0
    //   854: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   857: invokevirtual 267	java/net/HttpURLConnection:connect	()V
    //   860: aload_0
    //   861: monitorexit
    //   862: iconst_0
    //   863: ireturn
    //   864: astore 7
    //   866: goto +116 -> 982
    //   869: astore 7
    //   871: new 60	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   878: astore 8
    //   880: aload 8
    //   882: ldc_w 269
    //   885: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 8
    //   891: aload 7
    //   893: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: ldc 74
    //   899: iconst_2
    //   900: aload 8
    //   902: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload_0
    //   909: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   912: ifnull +66 -> 978
    //   915: aload_0
    //   916: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   919: invokevirtual 275	java/net/HttpURLConnection:disconnect	()V
    //   922: goto +56 -> 978
    //   925: astore 7
    //   927: new 60	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   934: astore 8
    //   936: aload 8
    //   938: ldc_w 269
    //   941: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: aload 8
    //   947: aload 7
    //   949: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: ldc 74
    //   955: iconst_2
    //   956: aload 8
    //   958: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   964: aload_0
    //   965: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   968: ifnull +10 -> 978
    //   971: aload_0
    //   972: getfield 32	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   975: invokevirtual 275	java/net/HttpURLConnection:disconnect	()V
    //   978: aload_0
    //   979: monitorexit
    //   980: iconst_m1
    //   981: ireturn
    //   982: aload_0
    //   983: monitorexit
    //   984: goto +6 -> 990
    //   987: aload 7
    //   989: athrow
    //   990: goto -3 -> 987
    //   993: bipush 38
    //   995: istore_1
    //   996: goto -709 -> 287
    //   999: aload 10
    //   1001: astore 8
    //   1003: goto -571 -> 432
    //   1006: iconst_0
    //   1007: istore_2
    //   1008: goto -159 -> 849
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1011	0	this	ApolloUrlConnection
    //   259	737	1	c	char
    //   124	884	2	i	int
    //   267	15	3	j	int
    //   277	91	4	k	int
    //   12	51	5	l	long
    //   16	826	7	localObject1	Object
    //   864	1	7	localObject2	Object
    //   869	23	7	localThrowable	Throwable
    //   925	63	7	localIOException	java.io.IOException
    //   32	970	8	localObject3	Object
    //   121	529	9	localObject4	Object
    //   118	882	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	864	finally
    //   18	80	864	finally
    //   84	92	864	finally
    //   96	110	864	finally
    //   114	120	864	finally
    //   138	148	864	finally
    //   152	225	864	finally
    //   225	257	864	finally
    //   260	279	864	finally
    //   293	326	864	finally
    //   329	383	864	finally
    //   383	425	864	finally
    //   432	476	864	finally
    //   476	512	864	finally
    //   516	614	864	finally
    //   614	660	864	finally
    //   663	699	864	finally
    //   699	759	864	finally
    //   762	846	864	finally
    //   853	860	864	finally
    //   871	922	864	finally
    //   927	978	864	finally
    //   2	14	869	java/lang/Throwable
    //   18	80	869	java/lang/Throwable
    //   84	92	869	java/lang/Throwable
    //   96	110	869	java/lang/Throwable
    //   114	120	869	java/lang/Throwable
    //   138	148	869	java/lang/Throwable
    //   152	225	869	java/lang/Throwable
    //   225	257	869	java/lang/Throwable
    //   260	279	869	java/lang/Throwable
    //   293	326	869	java/lang/Throwable
    //   329	383	869	java/lang/Throwable
    //   383	425	869	java/lang/Throwable
    //   432	476	869	java/lang/Throwable
    //   476	512	869	java/lang/Throwable
    //   516	614	869	java/lang/Throwable
    //   614	660	869	java/lang/Throwable
    //   663	699	869	java/lang/Throwable
    //   699	759	869	java/lang/Throwable
    //   762	846	869	java/lang/Throwable
    //   853	860	869	java/lang/Throwable
    //   2	14	925	java/io/IOException
    //   18	80	925	java/io/IOException
    //   84	92	925	java/io/IOException
    //   96	110	925	java/io/IOException
    //   114	120	925	java/io/IOException
    //   138	148	925	java/io/IOException
    //   152	225	925	java/io/IOException
    //   225	257	925	java/io/IOException
    //   260	279	925	java/io/IOException
    //   293	326	925	java/io/IOException
    //   329	383	925	java/io/IOException
    //   383	425	925	java/io/IOException
    //   432	476	925	java/io/IOException
    //   476	512	925	java/io/IOException
    //   516	614	925	java/io/IOException
    //   614	660	925	java/io/IOException
    //   663	699	925	java/io/IOException
    //   699	759	925	java/io/IOException
    //   762	846	925	java/io/IOException
    //   853	860	925	java/io/IOException
  }
  
  ApolloUrlConnection.ResponseDataTuple a(AtomicBoolean paramAtomicBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      BufferedInputStream localBufferedInputStream = a();
      if (localBufferedInputStream != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = paramByteArrayOutputStream;
        if (paramByteArrayOutputStream == null) {
          localByteArrayOutputStream = new ByteArrayOutputStream();
        }
        paramByteArrayOutputStream = new byte[10240];
        boolean bool = false;
        int i = 0;
        for (;;)
        {
          int j = i;
          try
          {
            if (!paramAtomicBoolean.get())
            {
              i = localBufferedInputStream.read(paramByteArrayOutputStream);
              j = i;
              if (-1 != i)
              {
                localByteArrayOutputStream.write(paramByteArrayOutputStream, 0, i);
                continue;
              }
            }
            paramAtomicBoolean = new ApolloUrlConnection.ResponseDataTuple();
            paramAtomicBoolean.jdField_a_of_type_JavaIoBufferedInputStream = localBufferedInputStream;
            paramAtomicBoolean.jdField_a_of_type_JavaIoByteArrayOutputStream = localByteArrayOutputStream;
            if (-1 == j) {
              bool = true;
            }
            paramAtomicBoolean.jdField_a_of_type_Boolean = bool;
            return paramAtomicBoolean;
          }
          catch (Throwable paramAtomicBoolean)
          {
            paramByteArrayOutputStream = new StringBuilder();
            paramByteArrayOutputStream.append(" getResponseData error:");
            paramByteArrayOutputStream.append(paramAtomicBoolean.getMessage());
            QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 2, paramByteArrayOutputStream.toString());
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramAtomicBoolean;
    }
  }
  
  Map<String, List<String>> a()
  {
    Map localMap = null;
    try
    {
      if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
        localMap = this.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderFields();
      }
      return localMap;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaNetHttpURLConnection == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ApolloUrlConnection.1(this));
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disconnect error:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 2, localStringBuilder.toString());
    }
  }
  
  public int b()
  {
    HttpURLConnection localHttpURLConnection = this.jdField_a_of_type_JavaNetHttpURLConnection;
    if (localHttpURLConnection != null) {
      try
      {
        int i = localHttpURLConnection.getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getResponseCode error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 2, localStringBuilder.toString());
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlConnection
 * JD-Core Version:    0.7.0.1
 */