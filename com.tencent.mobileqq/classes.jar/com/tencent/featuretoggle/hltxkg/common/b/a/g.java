package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
  extends a
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private e jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAE;
  private f jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF;
  private g.a jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a;
  private DataInputStream jdField_a_of_type_JavaIoDataInputStream;
  private DataOutputStream jdField_a_of_type_JavaIoDataOutputStream;
  private HttpURLConnection jdField_a_of_type_JavaNetHttpURLConnection;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  boolean jdField_b_of_type_Boolean;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public g(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a = new g.a((byte)0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_JavaUtilMap = paramMap;
    this.jdField_e_of_type_ArrayOfByte = paramArrayOfByte;
    int i;
    if (com.tencent.featuretoggle.hltxkg.common.a.e.e() == 2) {
      i = i.a("direct_access_time_out", 1000, 60000, 15000);
    } else {
      i = i.a("direct_access_time_out", 1000, 60000, 10000);
    }
    int j = i;
    if (paramInt < i) {
      j = paramInt;
    }
    this.jdField_f_of_type_Int = c.a(j, 200, 60000, 10000);
    paramBoolean = bool;
    if (this.jdField_b_of_type_JavaLangString.length() > 8) {
      if (this.jdField_b_of_type_JavaLangString.charAt(7) != '[')
      {
        paramBoolean = bool;
        if (this.jdField_b_of_type_JavaLangString.charAt(8) != '[') {}
      }
      else
      {
        paramBoolean = true;
      }
    }
    this.g = a(paramInt, paramBoolean);
    this.h = paramString3;
  }
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((com.tencent.featuretoggle.hltxkg.common.a.e.f() == 2) && (paramBoolean)) {
      i = i.a("direct_access_conn_time_out", 1000, 60000, 2000);
    } else {
      i = i.a("direct_access_conn_time_out", 1000, 60000, 10000);
    }
    if (paramInt >= i) {
      paramInt = i;
    }
    return c.a(paramInt, 200, 60000, 10000);
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_d_of_type_JavaUtilMap;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject1 != null)
    {
      j = k;
      if (this.jdField_d_of_type_JavaUtilMap.size() > 0)
      {
        localObject1 = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          String str = (String)this.jdField_d_of_type_JavaUtilMap.get(localObject2);
          this.jdField_a_of_type_JavaNetHttpURLConnection.addRequestProperty((String)localObject2, str);
          if (((String)localObject2).toLowerCase().contains("host")) {
            i = 1;
          }
        }
      }
    }
    if (j == 0) {
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Host", this.jdField_c_of_type_JavaLangString);
    }
    localObject1 = this.jdField_a_of_type_JavaNetHttpURLConnection;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((HttpURLConnection)localObject1).setRequestProperty("Halley", ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("X-Online-Host", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("x-tx-host", this.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        localObject1 = new BufferedInputStream(this.jdField_a_of_type_JavaNetHttpURLConnection.getInputStream());
        localObject2 = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = 0;
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        Object localObject1;
        Object localObject2;
        byte[] arrayOfByte;
        int i;
        int j;
        int k;
        continue;
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        k = ((BufferedInputStream)localObject1).read(arrayOfByte);
        if (k == -1) {
          break label238;
        }
        j = i;
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k <= paramInt) {
          continue;
        }
        j = k;
        this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_a_of_type_Int = -303;
        j = k;
        this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_b_of_type_JavaLangString = "no-content-length";
        paramInt = m;
        i = k;
        if (paramInt != 0)
        {
          j = i;
          this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.d = ((ByteArrayOutputStream)localObject2).toByteArray();
          j = i;
          this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.f = SystemClock.elapsedRealtime();
        }
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
      }
      try
      {
        ((ByteArrayOutputStream)localObject2).close();
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF;
      ((f)localObject1).jdField_a_of_type_Int = -287;
      ((f)localObject1).jdField_b_of_type_JavaLangString = "read without content-length error";
      return;
      j = 0;
      localObject1 = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF;
      ((f)localObject1).jdField_a_of_type_Int = -306;
      localObject2 = new StringBuilder("no-content-length:");
      ((StringBuilder)localObject2).append(j);
      ((f)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      return;
      label238:
      paramInt = 1;
    }
  }
  
  private boolean a()
  {
    if (this.m)
    {
      this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_a_of_type_Int = -20;
      this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.a();
      return true;
    }
    return false;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
        this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      }
      if (this.jdField_a_of_type_JavaIoDataOutputStream != null) {
        this.jdField_a_of_type_JavaIoDataOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoDataInputStream != null) {
        this.jdField_a_of_type_JavaIoDataInputStream.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public final f a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   4: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   7: aload_0
    //   8: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   11: aload_0
    //   12: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   15: putfield 264	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:jdField_a_of_type_Long	J
    //   18: iconst_0
    //   19: istore 6
    //   21: iconst_0
    //   22: istore_1
    //   23: iconst_0
    //   24: istore_2
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_0
    //   29: istore_3
    //   30: iconst_0
    //   31: istore 5
    //   33: aload_0
    //   34: new 211	com/tencent/featuretoggle/hltxkg/common/b/a/f
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 266
    //   42: iconst_0
    //   43: invokespecial 269	com/tencent/featuretoggle/hltxkg/common/b/a/f:<init>	(ILjava/lang/String;I)V
    //   46: putfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   49: aload_0
    //   50: invokespecial 271	com/tencent/featuretoggle/hltxkg/common/b/a/g:a	()Z
    //   53: ifeq +96 -> 149
    //   56: aload_0
    //   57: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   60: astore 7
    //   62: aload_0
    //   63: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   66: aload_0
    //   67: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   70: aload_0
    //   71: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   74: lsub
    //   75: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   78: aload_0
    //   79: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   82: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   85: aload_0
    //   86: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   89: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   92: ifeq +54 -> 146
    //   95: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   98: ifeq +48 -> 146
    //   101: aload_0
    //   102: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   105: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   108: bipush 236
    //   110: if_icmpeq +36 -> 146
    //   113: iload 5
    //   115: istore_1
    //   116: ldc_w 277
    //   119: iconst_0
    //   120: iconst_1
    //   121: iconst_0
    //   122: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   125: iconst_1
    //   126: if_icmpne +5 -> 131
    //   129: iconst_1
    //   130: istore_1
    //   131: iload_1
    //   132: ifeq +14 -> 146
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokestatic 280	com/tencent/featuretoggle/hltxkg/common/e/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 282	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   146: aload 7
    //   148: areturn
    //   149: new 284	java/net/URL
    //   152: dup
    //   153: aload_0
    //   154: getfield 46	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   157: invokespecial 285	java/net/URL:<init>	(Ljava/lang/String;)V
    //   160: astore 7
    //   162: aload_0
    //   163: aload 7
    //   165: invokevirtual 288	java/net/URL:getProtocol	()Ljava/lang/String;
    //   168: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   171: ldc_w 290
    //   174: invokevirtual 294	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   177: putfield 296	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_Boolean	Z
    //   180: aload_0
    //   181: aload 7
    //   183: invokevirtual 299	java/net/URL:getHost	()Ljava/lang/String;
    //   186: invokestatic 301	com/tencent/featuretoggle/hltxkg/common/e/c:d	(Ljava/lang/String;)Z
    //   189: putfield 303	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_Boolean	Z
    //   192: aload_0
    //   193: getfield 296	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_Boolean	Z
    //   196: ifeq +104 -> 300
    //   199: aload_0
    //   200: getfield 36	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Boolean	Z
    //   203: ifeq +29 -> 232
    //   206: invokestatic 307	com/tencent/featuretoggle/hltxkg/common/a/e:j	()Ljava/net/Proxy;
    //   209: ifnull +23 -> 232
    //   212: aload 7
    //   214: invokestatic 307	com/tencent/featuretoggle/hltxkg/common/a/e:j	()Ljava/net/Proxy;
    //   217: invokevirtual 311	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   220: astore 7
    //   222: aload 7
    //   224: checkcast 313	javax/net/ssl/HttpsURLConnection
    //   227: astore 8
    //   229: goto +13 -> 242
    //   232: aload 7
    //   234: invokevirtual 316	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   237: astore 7
    //   239: goto -17 -> 222
    //   242: aload 8
    //   244: astore 7
    //   246: aload_0
    //   247: getfield 303	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_Boolean	Z
    //   250: ifeq +93 -> 343
    //   253: aload_0
    //   254: new 318	com/tencent/featuretoggle/hltxkg/common/b/a/e
    //   257: dup
    //   258: aload_0
    //   259: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   262: invokespecial 319	com/tencent/featuretoggle/hltxkg/common/b/a/e:<init>	(Ljava/lang/String;)V
    //   265: putfield 321	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAE	Lcom/tencent/featuretoggle/hltxkg/common/b/a/e;
    //   268: aload 8
    //   270: aload_0
    //   271: getfield 321	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAE	Lcom/tencent/featuretoggle/hltxkg/common/b/a/e;
    //   274: invokevirtual 325	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   277: aload 8
    //   279: new 327	com/tencent/featuretoggle/hltxkg/common/b/a/d
    //   282: dup
    //   283: aload_0
    //   284: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   287: invokespecial 328	com/tencent/featuretoggle/hltxkg/common/b/a/d:<init>	(Ljava/lang/String;)V
    //   290: invokevirtual 332	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   293: aload 8
    //   295: astore 7
    //   297: goto +46 -> 343
    //   300: aload_0
    //   301: getfield 36	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Boolean	Z
    //   304: ifeq +29 -> 333
    //   307: invokestatic 307	com/tencent/featuretoggle/hltxkg/common/a/e:j	()Ljava/net/Proxy;
    //   310: ifnull +23 -> 333
    //   313: aload 7
    //   315: invokestatic 307	com/tencent/featuretoggle/hltxkg/common/a/e:j	()Ljava/net/Proxy;
    //   318: invokevirtual 311	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   321: astore 7
    //   323: aload 7
    //   325: checkcast 133	java/net/HttpURLConnection
    //   328: astore 7
    //   330: goto +13 -> 343
    //   333: aload 7
    //   335: invokevirtual 316	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   338: astore 7
    //   340: goto -17 -> 323
    //   343: aload_0
    //   344: aload 7
    //   346: putfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   349: aload_0
    //   350: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   353: astore 8
    //   355: aload_0
    //   356: getfield 48	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_Boolean	Z
    //   359: ifeq +1690 -> 2049
    //   362: ldc_w 334
    //   365: astore 7
    //   367: goto +3 -> 370
    //   370: aload 8
    //   372: aload 7
    //   374: invokevirtual 337	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   381: aload_0
    //   382: getfield 89	com/tencent/featuretoggle/hltxkg/common/b/a/g:g	I
    //   385: invokevirtual 340	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   388: aload_0
    //   389: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   392: aload_0
    //   393: getfield 74	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_f_of_type_Int	I
    //   396: invokevirtual 343	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   399: aload_0
    //   400: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   403: iconst_0
    //   404: invokevirtual 347	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   407: aload_0
    //   408: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   411: iconst_1
    //   412: invokevirtual 350	java/net/HttpURLConnection:setDoInput	(Z)V
    //   415: aload_0
    //   416: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   419: iconst_0
    //   420: invokevirtual 353	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   423: aload_0
    //   424: invokespecial 354	com/tencent/featuretoggle/hltxkg/common/b/a/g:a	()V
    //   427: aload_0
    //   428: getfield 48	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_Boolean	Z
    //   431: ifne +31 -> 462
    //   434: aload_0
    //   435: getfield 54	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_ArrayOfByte	[B
    //   438: invokestatic 357	com/tencent/featuretoggle/hltxkg/common/e/c:a	([B)Z
    //   441: ifne +21 -> 462
    //   444: aload_0
    //   445: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   448: iconst_1
    //   449: invokevirtual 360	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 54	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_ArrayOfByte	[B
    //   457: arraylength
    //   458: i2l
    //   459: putfield 27	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Long	J
    //   462: aload_0
    //   463: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   466: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   469: putfield 361	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:jdField_b_of_type_Long	J
    //   472: aload_0
    //   473: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   476: invokevirtual 364	java/net/HttpURLConnection:connect	()V
    //   479: aload_0
    //   480: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   483: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   486: putfield 366	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:c	J
    //   489: aload_0
    //   490: invokespecial 271	com/tencent/featuretoggle/hltxkg/common/b/a/g:a	()Z
    //   493: ifeq +96 -> 589
    //   496: aload_0
    //   497: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   500: astore 7
    //   502: aload_0
    //   503: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   506: aload_0
    //   507: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   510: aload_0
    //   511: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   514: lsub
    //   515: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   518: aload_0
    //   519: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   522: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   525: aload_0
    //   526: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   529: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   532: ifeq +54 -> 586
    //   535: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   538: ifeq +48 -> 586
    //   541: aload_0
    //   542: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   545: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   548: bipush 236
    //   550: if_icmpeq +36 -> 586
    //   553: iload 6
    //   555: istore_1
    //   556: ldc_w 277
    //   559: iconst_0
    //   560: iconst_1
    //   561: iconst_0
    //   562: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   565: iconst_1
    //   566: if_icmpne +5 -> 571
    //   569: iconst_1
    //   570: istore_1
    //   571: iload_1
    //   572: ifeq +14 -> 586
    //   575: aload_0
    //   576: aload_0
    //   577: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   580: invokestatic 280	com/tencent/featuretoggle/hltxkg/common/e/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   583: putfield 282	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   586: aload 7
    //   588: areturn
    //   589: aload_0
    //   590: getfield 48	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_Boolean	Z
    //   593: ifne +49 -> 642
    //   596: aload_0
    //   597: getfield 54	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_ArrayOfByte	[B
    //   600: invokestatic 357	com/tencent/featuretoggle/hltxkg/common/e/c:a	([B)Z
    //   603: ifne +39 -> 642
    //   606: aload_0
    //   607: new 254	java/io/DataOutputStream
    //   610: dup
    //   611: aload_0
    //   612: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   615: invokevirtual 370	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   618: invokespecial 373	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   621: putfield 252	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   624: aload_0
    //   625: getfield 252	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   628: aload_0
    //   629: getfield 54	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_e_of_type_ArrayOfByte	[B
    //   632: invokevirtual 376	java/io/DataOutputStream:write	([B)V
    //   635: aload_0
    //   636: getfield 252	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   639: invokevirtual 379	java/io/DataOutputStream:flush	()V
    //   642: aload_0
    //   643: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   646: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   649: putfield 381	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:d	J
    //   652: aload_0
    //   653: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   656: invokevirtual 384	java/net/HttpURLConnection:getResponseCode	()I
    //   659: istore 5
    //   661: aload_0
    //   662: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   665: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   668: putfield 386	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:e	J
    //   671: aload_0
    //   672: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   675: iload 5
    //   677: putfield 388	com/tencent/featuretoggle/hltxkg/common/b/a/f:c	I
    //   680: aload_0
    //   681: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   684: invokevirtual 391	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   687: pop
    //   688: new 393	java/util/HashMap
    //   691: dup
    //   692: invokespecial 394	java/util/HashMap:<init>	()V
    //   695: astore 7
    //   697: aload_0
    //   698: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   701: invokevirtual 398	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   704: invokeinterface 401 1 0
    //   709: invokeinterface 115 1 0
    //   714: astore 8
    //   716: aload 8
    //   718: invokeinterface 121 1 0
    //   723: ifeq +59 -> 782
    //   726: aload 8
    //   728: invokeinterface 125 1 0
    //   733: checkcast 403	java/util/Map$Entry
    //   736: astore 9
    //   738: aload 9
    //   740: invokeinterface 406 1 0
    //   745: ifnull -29 -> 716
    //   748: aload 7
    //   750: aload 9
    //   752: invokeinterface 406 1 0
    //   757: aload 9
    //   759: invokeinterface 409 1 0
    //   764: checkcast 411	java/util/List
    //   767: iconst_0
    //   768: invokeinterface 414 2 0
    //   773: invokeinterface 418 3 0
    //   778: pop
    //   779: goto -63 -> 716
    //   782: aload_0
    //   783: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   786: aload 7
    //   788: invokevirtual 421	com/tencent/featuretoggle/hltxkg/common/b/a/f:a	(Ljava/util/Map;)V
    //   791: aload_0
    //   792: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   795: getfield 388	com/tencent/featuretoggle/hltxkg/common/b/a/f:c	I
    //   798: sipush 200
    //   801: if_icmplt +253 -> 1054
    //   804: aload_0
    //   805: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   808: getfield 388	com/tencent/featuretoggle/hltxkg/common/b/a/f:c	I
    //   811: sipush 300
    //   814: if_icmpge +240 -> 1054
    //   817: aload_0
    //   818: aload_0
    //   819: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   822: invokevirtual 424	java/net/HttpURLConnection:getContentLength	()I
    //   825: putfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   828: ldc_w 428
    //   831: ldc_w 429
    //   834: ldc_w 430
    //   837: ldc_w 431
    //   840: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   843: istore 5
    //   845: aload_0
    //   846: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   849: ifge +12 -> 861
    //   852: aload_0
    //   853: iload 5
    //   855: invokespecial 433	com/tencent/featuretoggle/hltxkg/common/b/a/g:a	(I)V
    //   858: goto +236 -> 1094
    //   861: aload_0
    //   862: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   865: ifne +26 -> 891
    //   868: aload_0
    //   869: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   872: iconst_0
    //   873: newarray byte
    //   875: putfield 221	com/tencent/featuretoggle/hltxkg/common/b/a/f:d	[B
    //   878: aload_0
    //   879: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   882: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   885: putfield 228	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:f	J
    //   888: goto +206 -> 1094
    //   891: aload_0
    //   892: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   895: iload 5
    //   897: if_icmple +55 -> 952
    //   900: aload_0
    //   901: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   904: sipush -303
    //   907: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   910: aload_0
    //   911: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   914: astore 7
    //   916: new 154	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   923: astore 8
    //   925: aload 8
    //   927: aload_0
    //   928: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   931: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 8
    //   937: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: astore 8
    //   942: aload 7
    //   944: aload 8
    //   946: putfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   949: goto +145 -> 1094
    //   952: aload_0
    //   953: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   956: newarray byte
    //   958: astore 7
    //   960: aload_0
    //   961: new 259	java/io/DataInputStream
    //   964: dup
    //   965: aload_0
    //   966: getfield 131	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   969: invokevirtual 193	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   972: invokespecial 434	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   975: putfield 257	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaIoDataInputStream	Ljava/io/DataInputStream;
    //   978: aload_0
    //   979: getfield 257	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_JavaIoDataInputStream	Ljava/io/DataInputStream;
    //   982: aload 7
    //   984: invokevirtual 437	java/io/DataInputStream:readFully	([B)V
    //   987: aload_0
    //   988: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   991: aload 7
    //   993: putfield 221	com/tencent/featuretoggle/hltxkg/common/b/a/f:d	[B
    //   996: aload_0
    //   997: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   1000: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   1003: putfield 228	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:f	J
    //   1006: goto +88 -> 1094
    //   1009: aload_0
    //   1010: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1013: sipush -306
    //   1016: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1019: aload_0
    //   1020: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1023: astore 7
    //   1025: new 154	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1032: astore 8
    //   1034: aload 8
    //   1036: aload_0
    //   1037: getfield 426	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_b_of_type_Int	I
    //   1040: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: aload 8
    //   1046: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: astore 8
    //   1051: goto -109 -> 942
    //   1054: aload_0
    //   1055: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1058: getfield 388	com/tencent/featuretoggle/hltxkg/common/b/a/f:c	I
    //   1061: sipush 300
    //   1064: if_icmplt +30 -> 1094
    //   1067: aload_0
    //   1068: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1071: getfield 388	com/tencent/featuretoggle/hltxkg/common/b/a/f:c	I
    //   1074: sipush 400
    //   1077: if_icmpge +17 -> 1094
    //   1080: aload_0
    //   1081: aload_0
    //   1082: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1085: ldc_w 439
    //   1088: invokevirtual 441	com/tencent/featuretoggle/hltxkg/common/b/a/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1091: putfield 444	com/tencent/featuretoggle/hltxkg/common/b/a/g:i	Ljava/lang/String;
    //   1094: aload_0
    //   1095: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   1098: aload_0
    //   1099: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   1102: aload_0
    //   1103: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1106: lsub
    //   1107: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1110: aload_0
    //   1111: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   1114: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   1117: aload_0
    //   1118: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1121: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1124: ifeq +818 -> 1942
    //   1127: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   1130: ifeq +812 -> 1942
    //   1133: aload_0
    //   1134: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1137: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1140: bipush 236
    //   1142: if_icmpeq +800 -> 1942
    //   1145: ldc_w 277
    //   1148: iconst_0
    //   1149: iconst_1
    //   1150: iconst_0
    //   1151: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   1154: iconst_1
    //   1155: if_icmpne +5 -> 1160
    //   1158: iconst_1
    //   1159: istore_1
    //   1160: iload_1
    //   1161: ifeq +781 -> 1942
    //   1164: aload_0
    //   1165: aload_0
    //   1166: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1169: invokestatic 280	com/tencent/featuretoggle/hltxkg/common/e/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1172: putfield 282	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1175: goto +767 -> 1942
    //   1178: astore 7
    //   1180: goto +767 -> 1947
    //   1183: astore 7
    //   1185: aload 7
    //   1187: invokevirtual 447	java/lang/Throwable:printStackTrace	()V
    //   1190: aload_0
    //   1191: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1194: sipush -287
    //   1197: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1200: aload_0
    //   1201: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1204: astore 8
    //   1206: new 154	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1213: astore 9
    //   1215: aload 9
    //   1217: aload 7
    //   1219: invokevirtual 453	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1222: invokevirtual 458	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   1225: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: pop
    //   1229: aload 9
    //   1231: ldc_w 460
    //   1234: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload 9
    //   1240: aload 7
    //   1242: invokevirtual 463	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1245: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload 9
    //   1251: ldc_w 465
    //   1254: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload 8
    //   1260: aload 9
    //   1262: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: putfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1268: aload_0
    //   1269: getfield 296	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_Boolean	Z
    //   1272: ifeq +22 -> 1294
    //   1275: aload_0
    //   1276: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1279: getfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1282: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1285: ldc_w 467
    //   1288: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1291: ifne +766 -> 2057
    //   1294: aload_0
    //   1295: getfield 296	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_Boolean	Z
    //   1298: ifeq +764 -> 2062
    //   1301: aload_0
    //   1302: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1305: getfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1308: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1311: ldc_w 469
    //   1314: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1317: ifeq +745 -> 2062
    //   1320: goto +737 -> 2057
    //   1323: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   1326: ifne +15 -> 1341
    //   1329: aload_0
    //   1330: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1333: bipush 252
    //   1335: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1338: goto +443 -> 1781
    //   1341: aload_0
    //   1342: getfield 241	com/tencent/featuretoggle/hltxkg/common/b/a/g:m	Z
    //   1345: ifeq +15 -> 1360
    //   1348: aload_0
    //   1349: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1352: bipush 236
    //   1354: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1357: goto +424 -> 1781
    //   1360: iload_1
    //   1361: ifeq +16 -> 1377
    //   1364: aload_0
    //   1365: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1368: sipush -289
    //   1371: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1374: goto +407 -> 1781
    //   1377: aload 7
    //   1379: instanceof 471
    //   1382: ifeq +20 -> 1402
    //   1385: aload_0
    //   1386: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1389: astore 7
    //   1391: aload 7
    //   1393: sipush -290
    //   1396: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1399: goto +382 -> 1781
    //   1402: aload 7
    //   1404: instanceof 473
    //   1407: ifne +364 -> 1771
    //   1410: aload 7
    //   1412: instanceof 475
    //   1415: ifne +356 -> 1771
    //   1418: aload 7
    //   1420: instanceof 477
    //   1423: ifeq +6 -> 1429
    //   1426: goto +345 -> 1771
    //   1429: aload_0
    //   1430: iconst_1
    //   1431: putfield 479	com/tencent/featuretoggle/hltxkg/common/b/a/g:j	Z
    //   1434: aload 7
    //   1436: invokevirtual 482	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1439: ifnull +43 -> 1482
    //   1442: aload 7
    //   1444: invokevirtual 482	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1447: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1450: ldc_w 484
    //   1453: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1456: ifeq +26 -> 1482
    //   1459: aload_0
    //   1460: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1463: sipush -281
    //   1466: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1469: aload_0
    //   1470: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1473: ldc_w 486
    //   1476: putfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1479: goto +302 -> 1781
    //   1482: aload 7
    //   1484: instanceof 488
    //   1487: ifeq +16 -> 1503
    //   1490: aload_0
    //   1491: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1494: sipush -284
    //   1497: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1500: goto +281 -> 1781
    //   1503: aload 7
    //   1505: instanceof 490
    //   1508: ifeq +15 -> 1523
    //   1511: aload_0
    //   1512: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1515: bipush 214
    //   1517: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1520: goto +261 -> 1781
    //   1523: aload 7
    //   1525: instanceof 492
    //   1528: ifeq +71 -> 1599
    //   1531: aload 7
    //   1533: invokevirtual 463	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1536: astore 7
    //   1538: aload 7
    //   1540: ifnull +47 -> 1587
    //   1543: aload 7
    //   1545: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1548: ldc_w 493
    //   1551: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1554: ifne +17 -> 1571
    //   1557: aload 7
    //   1559: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1562: ldc_w 495
    //   1565: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1568: ifeq +19 -> 1587
    //   1571: aload_0
    //   1572: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1575: astore 7
    //   1577: aload 7
    //   1579: bipush 246
    //   1581: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1584: goto +197 -> 1781
    //   1587: aload_0
    //   1588: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1591: bipush 243
    //   1593: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1596: goto +185 -> 1781
    //   1599: aload 7
    //   1601: instanceof 497
    //   1604: ifeq +15 -> 1619
    //   1607: aload_0
    //   1608: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1611: bipush 215
    //   1613: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1616: goto +165 -> 1781
    //   1619: aload 7
    //   1621: instanceof 499
    //   1624: ifeq +157 -> 1781
    //   1627: aload_0
    //   1628: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1631: sipush -286
    //   1634: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1637: aload_0
    //   1638: getfield 296	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_Boolean	Z
    //   1641: ifeq +109 -> 1750
    //   1644: aload_0
    //   1645: getfield 321	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAE	Lcom/tencent/featuretoggle/hltxkg/common/b/a/e;
    //   1648: ifnull +102 -> 1750
    //   1651: aload_0
    //   1652: getfield 321	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAE	Lcom/tencent/featuretoggle/hltxkg/common/b/a/e;
    //   1655: getfield 500	com/tencent/featuretoggle/hltxkg/common/b/a/e:jdField_a_of_type_Boolean	Z
    //   1658: ifeq +92 -> 1750
    //   1661: aload_0
    //   1662: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1665: getfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1668: ldc_w 502
    //   1671: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1674: ifeq +12 -> 1686
    //   1677: aload_0
    //   1678: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1681: astore 7
    //   1683: goto -292 -> 1391
    //   1686: aload_0
    //   1687: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1690: getfield 215	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1693: ldc_w 504
    //   1696: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1699: ifeq +12 -> 1711
    //   1702: aload_0
    //   1703: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1706: astore 7
    //   1708: goto -131 -> 1577
    //   1711: aload 7
    //   1713: instanceof 506
    //   1716: ifeq +21 -> 1737
    //   1719: aload_0
    //   1720: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1723: sipush -292
    //   1726: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1729: aload_0
    //   1730: iconst_0
    //   1731: putfield 479	com/tencent/featuretoggle/hltxkg/common/b/a/g:j	Z
    //   1734: goto +47 -> 1781
    //   1737: aload_0
    //   1738: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1741: sipush -293
    //   1744: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1747: goto +34 -> 1781
    //   1750: aload 7
    //   1752: instanceof 506
    //   1755: ifeq +26 -> 1781
    //   1758: aload_0
    //   1759: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1762: sipush -292
    //   1765: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1768: goto -39 -> 1729
    //   1771: aload_0
    //   1772: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1775: sipush -291
    //   1778: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1781: aload_0
    //   1782: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   1785: aload_0
    //   1786: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   1789: aload_0
    //   1790: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1793: lsub
    //   1794: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1797: aload_0
    //   1798: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   1801: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   1804: aload_0
    //   1805: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1808: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1811: ifeq +131 -> 1942
    //   1814: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   1817: ifeq +125 -> 1942
    //   1820: aload_0
    //   1821: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1824: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1827: bipush 236
    //   1829: if_icmpeq +113 -> 1942
    //   1832: iload_2
    //   1833: istore_1
    //   1834: ldc_w 277
    //   1837: iconst_0
    //   1838: iconst_1
    //   1839: iconst_0
    //   1840: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   1843: iconst_1
    //   1844: if_icmpne +5 -> 1849
    //   1847: iconst_1
    //   1848: istore_1
    //   1849: iload_1
    //   1850: ifeq +92 -> 1942
    //   1853: goto -689 -> 1164
    //   1856: aload_0
    //   1857: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1860: sipush -300
    //   1863: putfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1866: aload_0
    //   1867: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   1870: aload_0
    //   1871: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   1874: aload_0
    //   1875: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1878: lsub
    //   1879: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1882: aload_0
    //   1883: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   1886: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   1889: aload_0
    //   1890: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1893: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1896: ifeq +46 -> 1942
    //   1899: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   1902: ifeq +40 -> 1942
    //   1905: aload_0
    //   1906: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1909: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1912: bipush 236
    //   1914: if_icmpeq +28 -> 1942
    //   1917: iload 4
    //   1919: istore_1
    //   1920: ldc_w 277
    //   1923: iconst_0
    //   1924: iconst_1
    //   1925: iconst_0
    //   1926: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   1929: iconst_1
    //   1930: if_icmpne +5 -> 1935
    //   1933: iconst_1
    //   1934: istore_1
    //   1935: iload_1
    //   1936: ifeq +6 -> 1942
    //   1939: goto -775 -> 1164
    //   1942: aload_0
    //   1943: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1946: areturn
    //   1947: aload_0
    //   1948: invokespecial 273	com/tencent/featuretoggle/hltxkg/common/b/a/g:b	()V
    //   1951: aload_0
    //   1952: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   1955: aload_0
    //   1956: getfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1959: lsub
    //   1960: putfield 243	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_Long	J
    //   1963: aload_0
    //   1964: getfield 34	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a	Lcom/tencent/featuretoggle/hltxkg/common/b/a/g$a;
    //   1967: invokevirtual 245	com/tencent/featuretoggle/hltxkg/common/b/a/g$a:a	()V
    //   1970: aload_0
    //   1971: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1974: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1977: ifeq +53 -> 2030
    //   1980: invokestatic 275	com/tencent/featuretoggle/hltxkg/common/a/e:g	()Z
    //   1983: ifeq +47 -> 2030
    //   1986: aload_0
    //   1987: getfield 209	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF	Lcom/tencent/featuretoggle/hltxkg/common/b/a/f;
    //   1990: getfield 212	com/tencent/featuretoggle/hltxkg/common/b/a/f:jdField_a_of_type_Int	I
    //   1993: bipush 236
    //   1995: if_icmpeq +35 -> 2030
    //   1998: iload_3
    //   1999: istore_1
    //   2000: ldc_w 277
    //   2003: iconst_0
    //   2004: iconst_1
    //   2005: iconst_0
    //   2006: invokestatic 67	com/tencent/featuretoggle/hltxkg/common/a/i:a	(Ljava/lang/String;III)I
    //   2009: iconst_1
    //   2010: if_icmpne +5 -> 2015
    //   2013: iconst_1
    //   2014: istore_1
    //   2015: iload_1
    //   2016: ifeq +14 -> 2030
    //   2019: aload_0
    //   2020: aload_0
    //   2021: getfield 44	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2024: invokestatic 280	com/tencent/featuretoggle/hltxkg/common/e/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2027: putfield 282	com/tencent/featuretoggle/hltxkg/common/b/a/g:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2030: goto +6 -> 2036
    //   2033: aload 7
    //   2035: athrow
    //   2036: goto -3 -> 2033
    //   2039: astore 7
    //   2041: goto -185 -> 1856
    //   2044: astore 7
    //   2046: goto -1037 -> 1009
    //   2049: ldc_w 508
    //   2052: astore 7
    //   2054: goto -1684 -> 370
    //   2057: iconst_1
    //   2058: istore_1
    //   2059: goto -736 -> 1323
    //   2062: iconst_0
    //   2063: istore_1
    //   2064: goto -741 -> 1323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2067	0	this	g
    //   22	2042	1	i	int
    //   24	1809	2	j	int
    //   29	1970	3	k	int
    //   26	1892	4	m	int
    //   31	867	5	n	int
    //   19	535	6	i1	int
    //   60	964	7	localObject1	Object
    //   1178	1	7	localObject2	Object
    //   1183	195	7	localThrowable	Throwable
    //   1389	645	7	localObject3	Object
    //   2039	1	7	localMalformedURLException	java.net.MalformedURLException
    //   2044	1	7	localOutOfMemoryError	OutOfMemoryError
    //   2052	1	7	str	String
    //   227	1032	8	localObject4	Object
    //   736	525	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   49	62	1178	finally
    //   149	222	1178	finally
    //   222	229	1178	finally
    //   232	239	1178	finally
    //   246	293	1178	finally
    //   300	323	1178	finally
    //   323	330	1178	finally
    //   333	340	1178	finally
    //   343	362	1178	finally
    //   370	462	1178	finally
    //   462	502	1178	finally
    //   589	642	1178	finally
    //   642	716	1178	finally
    //   716	779	1178	finally
    //   782	858	1178	finally
    //   861	888	1178	finally
    //   891	942	1178	finally
    //   942	949	1178	finally
    //   952	1006	1178	finally
    //   1009	1051	1178	finally
    //   1054	1094	1178	finally
    //   1185	1294	1178	finally
    //   1294	1320	1178	finally
    //   1323	1338	1178	finally
    //   1341	1357	1178	finally
    //   1364	1374	1178	finally
    //   1377	1391	1178	finally
    //   1391	1399	1178	finally
    //   1402	1426	1178	finally
    //   1429	1479	1178	finally
    //   1482	1500	1178	finally
    //   1503	1520	1178	finally
    //   1523	1538	1178	finally
    //   1543	1571	1178	finally
    //   1571	1577	1178	finally
    //   1577	1584	1178	finally
    //   1587	1596	1178	finally
    //   1599	1616	1178	finally
    //   1619	1683	1178	finally
    //   1686	1708	1178	finally
    //   1711	1729	1178	finally
    //   1729	1734	1178	finally
    //   1737	1747	1178	finally
    //   1750	1768	1178	finally
    //   1771	1781	1178	finally
    //   1856	1866	1178	finally
    //   49	62	1183	java/lang/Throwable
    //   149	222	1183	java/lang/Throwable
    //   222	229	1183	java/lang/Throwable
    //   232	239	1183	java/lang/Throwable
    //   246	293	1183	java/lang/Throwable
    //   300	323	1183	java/lang/Throwable
    //   323	330	1183	java/lang/Throwable
    //   333	340	1183	java/lang/Throwable
    //   343	362	1183	java/lang/Throwable
    //   370	462	1183	java/lang/Throwable
    //   462	502	1183	java/lang/Throwable
    //   589	642	1183	java/lang/Throwable
    //   642	716	1183	java/lang/Throwable
    //   716	779	1183	java/lang/Throwable
    //   782	858	1183	java/lang/Throwable
    //   861	888	1183	java/lang/Throwable
    //   891	942	1183	java/lang/Throwable
    //   942	949	1183	java/lang/Throwable
    //   952	1006	1183	java/lang/Throwable
    //   1009	1051	1183	java/lang/Throwable
    //   1054	1094	1183	java/lang/Throwable
    //   49	62	2039	java/net/MalformedURLException
    //   149	222	2039	java/net/MalformedURLException
    //   222	229	2039	java/net/MalformedURLException
    //   232	239	2039	java/net/MalformedURLException
    //   246	293	2039	java/net/MalformedURLException
    //   300	323	2039	java/net/MalformedURLException
    //   323	330	2039	java/net/MalformedURLException
    //   333	340	2039	java/net/MalformedURLException
    //   343	362	2039	java/net/MalformedURLException
    //   370	462	2039	java/net/MalformedURLException
    //   462	502	2039	java/net/MalformedURLException
    //   589	642	2039	java/net/MalformedURLException
    //   642	716	2039	java/net/MalformedURLException
    //   716	779	2039	java/net/MalformedURLException
    //   782	858	2039	java/net/MalformedURLException
    //   861	888	2039	java/net/MalformedURLException
    //   891	942	2039	java/net/MalformedURLException
    //   942	949	2039	java/net/MalformedURLException
    //   952	1006	2039	java/net/MalformedURLException
    //   1009	1051	2039	java/net/MalformedURLException
    //   1054	1094	2039	java/net/MalformedURLException
    //   952	1006	2044	java/lang/OutOfMemoryError
  }
  
  public final void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap1 != null) {
      localHashMap.putAll(paramMap1);
    }
    paramMap1 = new StringBuilder();
    paramMap1.append(this.jdField_a_of_type_Long);
    localHashMap.put("B59", paramMap1.toString());
    if (this.jdField_d_of_type_Boolean) {
      localHashMap.put("B85", "1");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localHashMap.put("B95", "1");
    }
    else
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(this.jdField_b_of_type_Long);
      localHashMap.put("B96", paramMap1.toString());
    }
    if (!this.jdField_e_of_type_Boolean) {
      localHashMap.put("B23", "1");
    }
    paramMap1 = new StringBuilder();
    paramMap1.append(com.tencent.featuretoggle.hltxkg.common.a.e.f());
    localHashMap.put("B220", paramMap1.toString());
    paramMap1 = new HashMap();
    if (paramMap2 != null) {
      paramMap1.putAll(paramMap2);
    }
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_b_of_type_Int);
    paramMap1.put("B88", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.g);
    paramMap1.put("B90", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.h);
    paramMap1.put("B91", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.i);
    paramMap1.put("B92", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.j);
    paramMap1.put("B93", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAG$a.k);
    paramMap1.put("B94", paramMap2.toString());
    if (!TextUtils.isEmpty(this.i)) {
      paramMap1.put("B47", this.i);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramMap1.put("B41", this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_a_of_type_Int != 0) {}
    for (int i = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_a_of_type_Int;; i = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.c)
    {
      break;
      if (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.c == 200)
      {
        i = 0;
        break;
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (i != -4))
    {
      com.tencent.featuretoggle.hltxkg.common.d.a.a("HLHttpDirect", com.tencent.featuretoggle.hltxkg.common.a.c(), i, this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_b_of_type_JavaLangString, localHashMap, paramMap1, this.j);
      return;
    }
    com.tencent.featuretoggle.hltxkg.common.d.a.b("HLHttpDirect", com.tencent.featuretoggle.hltxkg.common.a.c(), i, this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF.jdField_b_of_type_JavaLangString, localHashMap, paramMap1, this.j);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean b()
  {
    this.m = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.g
 * JD-Core Version:    0.7.0.1
 */