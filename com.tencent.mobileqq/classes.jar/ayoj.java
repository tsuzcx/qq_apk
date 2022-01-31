import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class ayoj
  extends ayoi
{
  public static int a;
  public static int b;
  private static int c = 1048576;
  private static int d = c * 2;
  protected BaseApplicationImpl a;
  protected String b;
  
  public ayoj(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static String a(Exception paramException)
  {
    int i = 8;
    if (paramException == null) {
      return "Exception e is null";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int j = arrayOfStackTraceElement.length;
      if (j > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        j = 0;
        while (j < i)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[j].toString()).append("\n");
          j += 1;
        }
        i = j;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString2)).getCurrentAccountUin();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      axrn.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < c)
      {
        paramInt = i;
        if (!paramBoolean) {
          break label182;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        axrn.a(BaseApplication.getContext()).a(paramApplication.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= d;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  public static void a(ayon paramayon, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, ayqp paramayqp1, ayqp paramayqp2, ayqq paramayqq)
  {
    System.currentTimeMillis();
    long l1;
    if (paramayqq != null)
    {
      l1 = paramayqq.e;
      if (paramayqq == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramayqq.f;; l2 = 0L)
    {
      if (!ayuc.b(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    String str2;
    String str1;
    if (!aypb.a(paramInt2, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt2));
      if ((paramInt2 == -9527) || (paramInt2 == 9311) || (paramInt2 == 9044) || (paramInt2 == 9350) || (paramInt2 == 9351))
      {
        localHashMap.put(aypb.k, paramString);
        str2 = "";
        if ((!paramBoolean) || (paramayqp1 != null) || (paramayqp2 != null) || (paramayqq != null)) {
          break label453;
        }
        str1 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        label151:
        if (QLog.isColorLevel()) {
          QLog.d("reportResult", 2, "parmStep: " + str1);
        }
        localHashMap.put("param_step", str1);
        localHashMap.put("param_uuid", paramayon.f);
        localHashMap.put("flow", String.valueOf(l1));
        localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramayon.jdField_a_of_type_Long * 1000L)));
        localHashMap.put("client_exist", String.valueOf(paramayon.jdField_a_of_type_Boolean));
        if (paramayqp2 != null) {
          localHashMap.put("param_RequestUrl", paramayqp2.a());
        }
        if (paramayqq != null) {
          localHashMap.put("param_HttpTran", paramayqq.a());
        }
        if (paramayqq != null)
        {
          localHashMap.put("param_retry", String.valueOf(paramayqq.jdField_b_of_type_Int));
          if (!paramayqq.jdField_a_of_type_Boolean) {
            break label532;
          }
          localHashMap.put("serverip", paramayqq.jdField_b_of_type_JavaLangString);
          localHashMap.put("param_Server", paramayqq.jdField_b_of_type_JavaLangString);
        }
        label359:
        if (!paramBoolean) {
          break label596;
        }
        if ((!paramayon.c.equals("actC2CPicDownloadV1")) && (!paramayon.c.equals("actC2CPicSmallDownV1"))) {
          break label581;
        }
        localHashMap.put("param_toUin", paramayon.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      axrn.a(BaseApplication.getContext()).a(null, paramayon.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("param_errorDesc", paramString);
      break;
      paramInt2 = -9527;
      localHashMap.put("param_errorDesc", paramString);
      break;
      label453:
      str1 = str2;
      if (paramayqp1 == null) {
        break label151;
      }
      str1 = str2;
      if (paramayqp2 == null) {
        break label151;
      }
      str1 = str2;
      if (paramayqq == null) {
        break label151;
      }
      str1 = paramayqp1.a(1) + ";" + paramayqp2.a(2) + ";" + paramayqq.a(3);
      break label151;
      label532:
      localHashMap.put("serverip", paramayqq.c);
      localHashMap.put("param_Server", paramayqq.c);
      if (paramInt2 != -9527) {
        break label359;
      }
      localHashMap.put("param_rspHeader", paramayqq.d);
      break label359;
      label581:
      localHashMap.put("param_grpUin", paramayon.jdField_a_of_type_JavaLangString);
    }
    label596:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramayon.g != null) && (!paramayon.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramayon.g);
    }
    long l3 = paramInt1;
    if ((paramayon.c.equals("actC2CPicDownloadV1")) || (paramayon.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramayon.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramayon.e);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      axrn.a(BaseApplication.getContext()).a(null, paramayon.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramayon.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramayon.e);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  private void a(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).a().a.b(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().f();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      a(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  /* Error */
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 343	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 345	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 348	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 352	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +94 -> 128
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 358	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 361	java/io/OutputStream:flush	()V
    //   49: lload 4
    //   51: iload_3
    //   52: i2l
    //   53: ladd
    //   54: lstore 4
    //   56: aload_2
    //   57: lload 4
    //   59: l2f
    //   60: lload 6
    //   62: l2f
    //   63: fdiv
    //   64: ldc_w 362
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 368 2 0
    //   74: goto -49 -> 25
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 369	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: ldc_w 371
    //   87: invokevirtual 375	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +47 -> 137
    //   93: new 377	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   96: dup
    //   97: sipush 9040
    //   100: ldc2_w 378
    //   103: aload_2
    //   104: invokevirtual 369	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokespecial 382	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   112: athrow
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 385	java/io/FileInputStream:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 385	java/io/FileInputStream:close	()V
    //   136: return
    //   137: new 377	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   140: dup
    //   141: sipush 9301
    //   144: ldc2_w 386
    //   147: aload_2
    //   148: invokevirtual 369	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: iconst_0
    //   152: iconst_0
    //   153: invokespecial 382	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   156: athrow
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -42 -> 118
    //   163: astore_0
    //   164: goto -46 -> 118
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_0
    //   170: goto -90 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramOutputStream	java.io.OutputStream
    //   0	173	1	paramFile	File
    //   0	173	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   31	21	3	i	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	77	java/io/IOException
    //   25	32	77	java/io/IOException
    //   37	49	77	java/io/IOException
    //   56	74	77	java/io/IOException
    //   80	113	113	finally
    //   137	157	113	finally
    //   6	15	157	finally
    //   18	25	163	finally
    //   25	32	163	finally
    //   37	49	163	finally
    //   56	74	163	finally
    //   6	15	167	java/io/IOException
  }
  
  private void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof auoc))
      {
        paramObject = (auoc)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i = ayuk.a(aywm.a((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          ayuk.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
      paramObject = paramObject.getPicDownloadInfo();
      if (paramObject.e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i = ayuk.a(aywm.a((String)localObject, bool));
        ayuk.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label51;
      }
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 0, paramString, paramInt2);
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label51:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label159;
            }
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label176;
          }
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label159:
    label176:
    a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  public static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
        int m = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
        boolean bool = bgky.a(paramDownloadParams.mImgType);
        j = aywm.b(bool);
        i = aywm.a(bool);
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i1 = aywm.c(bool);
        int i2 = aywm.d(bool);
        if ((n >= i2) && (k >= i2)) {
          break label362;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label333;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, aywm.b);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), paramDownloadParams);
          return new RoundRectBitmap(localBitmap, 12.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label355;
        }
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 12.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label333:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label355:
        i = k;
      }
      label362:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: aload_0
    //   7: aload_2
    //   8: ldc_w 312
    //   11: new 42	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 551
    //   21: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   28: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 554	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   41: astore 17
    //   43: aload_2
    //   44: getfield 393	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   47: astore 15
    //   49: aload 15
    //   51: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: astore_3
    //   55: ldc_w 556
    //   58: aload_3
    //   59: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +2045 -> 2107
    //   65: ldc_w 558
    //   68: aload_3
    //   69: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +163 -> 235
    //   75: goto +2032 -> 2107
    //   78: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +45 -> 126
    //   84: aload_0
    //   85: aload_2
    //   86: ldc_w 312
    //   89: new 42	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 560
    //   99: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 333
    //   112: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 17
    //   117: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   126: new 321	android/graphics/BitmapFactory$Options
    //   129: dup
    //   130: invokespecial 561	android/graphics/BitmapFactory$Options:<init>	()V
    //   133: astore 18
    //   135: aload 18
    //   137: getstatic 563	aywm:jdField_a_of_type_AndroidGraphicsBitmap$Config	Landroid/graphics/Bitmap$Config;
    //   140: putfield 566	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   143: aload 18
    //   145: sipush 160
    //   148: putfield 569	android/graphics/BitmapFactory$Options:inDensity	I
    //   151: aload 18
    //   153: sipush 160
    //   156: putfield 572	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   159: aload 18
    //   161: sipush 160
    //   164: putfield 575	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   167: aload 18
    //   169: iconst_1
    //   170: putfield 578	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   173: aload_1
    //   174: invokestatic 584	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   177: ifeq +64 -> 241
    //   180: aload_0
    //   181: aload_2
    //   182: invokespecial 586	ayoj:a	(Lcom/tencent/image/DownloadParams;)V
    //   185: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +45 -> 233
    //   191: aload_0
    //   192: aload_2
    //   193: ldc_w 312
    //   196: new 42	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 588
    //   206: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   213: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 333
    //   219: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 17
    //   224: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   233: aconst_null
    //   234: areturn
    //   235: iconst_0
    //   236: istore 4
    //   238: goto -160 -> 78
    //   241: iload 4
    //   243: ifeq +918 -> 1161
    //   246: iconst_0
    //   247: istore 4
    //   249: aload_1
    //   250: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   253: astore_3
    //   254: aload 18
    //   256: getstatic 514	aywm:b	Landroid/graphics/Bitmap$Config;
    //   259: putfield 566	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   262: aload 18
    //   264: iconst_0
    //   265: putfield 578	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   268: aload_1
    //   269: invokevirtual 591	java/io/File:getName	()Ljava/lang/String;
    //   272: astore 15
    //   274: aload 15
    //   276: ldc_w 593
    //   279: invokevirtual 597	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   282: ifne +372 -> 654
    //   285: new 328	java/io/File
    //   288: dup
    //   289: new 42	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   296: aload_3
    //   297: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 593
    //   303: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokespecial 598	java/io/File:<init>	(Ljava/lang/String;)V
    //   312: astore 15
    //   314: aload 15
    //   316: invokevirtual 601	java/io/File:exists	()Z
    //   319: istore 9
    //   321: iload 9
    //   323: ifeq +58 -> 381
    //   326: iconst_1
    //   327: istore 4
    //   329: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +46 -> 378
    //   335: aload_0
    //   336: aload_2
    //   337: ldc_w 312
    //   340: new 42	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 603
    //   350: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 15
    //   355: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   358: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 605
    //   364: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 17
    //   369: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   378: aload 15
    //   380: astore_1
    //   381: aload_1
    //   382: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   385: aload 18
    //   387: invokestatic 610	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   390: astore 15
    //   392: aload 15
    //   394: astore 16
    //   396: aload 15
    //   398: ifnonnull +170 -> 568
    //   401: aload 15
    //   403: astore 16
    //   405: iload 4
    //   407: ifeq +161 -> 568
    //   410: aload_3
    //   411: invokestatic 614	bbdx:a	(Ljava/lang/String;)Z
    //   414: istore 9
    //   416: iload 9
    //   418: ifeq +74 -> 492
    //   421: aload_3
    //   422: aload 18
    //   424: invokestatic 610	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   427: astore 16
    //   429: aload 16
    //   431: astore 15
    //   433: aload 16
    //   435: ifnonnull +57 -> 492
    //   438: aload_3
    //   439: invokestatic 619	bdik:a	(Ljava/lang/String;)Ljava/lang/String;
    //   442: astore 19
    //   444: aload_3
    //   445: invokestatic 621	bbdx:d	(Ljava/lang/String;)Z
    //   448: pop
    //   449: aload 16
    //   451: astore 15
    //   453: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +36 -> 492
    //   459: aload_0
    //   460: aload_2
    //   461: ldc_w 312
    //   464: new 42	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 623
    //   474: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 19
    //   479: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload 16
    //   490: astore 15
    //   492: aload 15
    //   494: astore 16
    //   496: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +69 -> 568
    //   502: new 42	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 625
    //   512: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_3
    //   516: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: ldc_w 627
    //   522: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: iload 9
    //   527: invokevirtual 630	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: ldc_w 632
    //   533: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: astore 16
    //   538: aload 15
    //   540: ifnull +175 -> 715
    //   543: iconst_1
    //   544: istore 9
    //   546: aload_0
    //   547: aload_2
    //   548: ldc_w 312
    //   551: aload 16
    //   553: iload 9
    //   555: invokevirtual 630	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 15
    //   566: astore 16
    //   568: aload 16
    //   570: ifnull +299 -> 869
    //   573: iload 4
    //   575: ifeq +8 -> 583
    //   578: aload_3
    //   579: invokestatic 621	bbdx:d	(Ljava/lang/String;)Z
    //   582: pop
    //   583: aload 16
    //   585: astore_3
    //   586: aload_2
    //   587: getfield 636	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   590: ifnull +16 -> 606
    //   593: aload_2
    //   594: getfield 636	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   597: aload_2
    //   598: aload 16
    //   600: invokeinterface 642 3 0
    //   605: astore_3
    //   606: aload_2
    //   607: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   610: ifnull +135 -> 745
    //   613: aload_2
    //   614: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   617: instanceof 278
    //   620: ifeq +101 -> 721
    //   623: aload_2
    //   624: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   627: checkcast 278	com/tencent/mobileqq/data/MessageForPic
    //   630: getfield 645	com/tencent/mobileqq/data/MessageForPic:subMsgType	I
    //   633: iconst_2
    //   634: if_icmpeq +18 -> 652
    //   637: aload 17
    //   639: ldc_w 647
    //   642: invokevirtual 597	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   645: istore 9
    //   647: iload 9
    //   649: ifeq +72 -> 721
    //   652: aload_3
    //   653: areturn
    //   654: aload 15
    //   656: invokevirtual 649	java/lang/String:length	()I
    //   659: iconst_3
    //   660: if_icmple +1441 -> 2101
    //   663: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +31 -> 697
    //   669: aload_0
    //   670: aload_2
    //   671: ldc_w 312
    //   674: new 42	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 651
    //   684: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_3
    //   688: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload_3
    //   698: iconst_0
    //   699: aload_3
    //   700: invokevirtual 649	java/lang/String:length	()I
    //   703: iconst_3
    //   704: isub
    //   705: invokevirtual 655	java/lang/String:substring	(II)Ljava/lang/String;
    //   708: astore_3
    //   709: iconst_1
    //   710: istore 4
    //   712: goto -331 -> 381
    //   715: iconst_0
    //   716: istore 9
    //   718: goto -172 -> 546
    //   721: aload_2
    //   722: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   725: instanceof 657
    //   728: ifeq +17 -> 745
    //   731: aload_2
    //   732: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   735: checkcast 657	aywz
    //   738: aload_3
    //   739: invokeinterface 660 2 0
    //   744: areturn
    //   745: aload_0
    //   746: aload_3
    //   747: aload_2
    //   748: invokevirtual 662	ayoj:a	(Landroid/graphics/Bitmap;Lcom/tencent/image/DownloadParams;)Lcom/tencent/image/RoundRectBitmap;
    //   751: astore 15
    //   753: aload_3
    //   754: aload 15
    //   756: getfield 666	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   759: invokevirtual 669	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   762: ifne +7 -> 769
    //   765: aload_3
    //   766: invokevirtual 672	android/graphics/Bitmap:recycle	()V
    //   769: new 537	com/tencent/image/RoundRectBitmap
    //   772: dup
    //   773: new 674	ayxa
    //   776: dup
    //   777: aload_1
    //   778: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   781: invokespecial 675	ayxa:<init>	(Ljava/lang/String;)V
    //   784: aload 15
    //   786: getfield 666	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   789: invokevirtual 676	ayxa:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   792: aload 15
    //   794: getfield 679	com/tencent/image/RoundRectBitmap:mCornerRadius	F
    //   797: aload 15
    //   799: getfield 682	com/tencent/image/RoundRectBitmap:mBoardColor	I
    //   802: aload 15
    //   804: getfield 685	com/tencent/image/RoundRectBitmap:mBorderWidth	F
    //   807: invokespecial 688	com/tencent/image/RoundRectBitmap:<init>	(Landroid/graphics/Bitmap;FIF)V
    //   810: astore_3
    //   811: aload_0
    //   812: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   815: ifnull +37 -> 852
    //   818: aload_3
    //   819: aload_0
    //   820: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   823: invokevirtual 462	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   826: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   829: getfield 691	android/util/DisplayMetrics:widthPixels	I
    //   832: putfield 694	com/tencent/image/RoundRectBitmap:mDisplayWidth	I
    //   835: aload_3
    //   836: aload_0
    //   837: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   840: invokevirtual 462	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   843: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   846: getfield 697	android/util/DisplayMetrics:heightPixels	I
    //   849: putfield 700	com/tencent/image/RoundRectBitmap:mDisplayHeight	I
    //   852: aload_0
    //   853: aload_2
    //   854: aload_1
    //   855: aload 17
    //   857: aload 18
    //   859: iconst_1
    //   860: iconst_1
    //   861: ldc_w 702
    //   864: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   867: aload_3
    //   868: areturn
    //   869: aload_2
    //   870: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   873: checkcast 389	auoc
    //   876: invokeinterface 401 1 0
    //   881: ifne +99 -> 980
    //   884: aload_1
    //   885: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   888: invokestatic 619	bdik:a	(Ljava/lang/String;)Ljava/lang/String;
    //   891: astore_3
    //   892: aload_2
    //   893: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   896: checkcast 389	auoc
    //   899: invokeinterface 426 1 0
    //   904: astore 15
    //   906: new 42	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   913: ldc_w 440
    //   916: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: aload 15
    //   921: getfield 431	aunn:jdField_b_of_type_Int	I
    //   924: invokestatic 706	ayuk:b	(I)Ljava/lang/String;
    //   927: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: ldc_w 708
    //   933: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: iconst_1
    //   940: new 42	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   947: ldc_w 710
    //   950: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload 15
    //   955: getfield 432	aunn:jdField_a_of_type_Long	J
    //   958: invokestatic 174	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   961: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc_w 712
    //   967: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_3
    //   971: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 715	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: aload_1
    //   981: invokevirtual 718	java/io/File:delete	()Z
    //   984: pop
    //   985: aload_0
    //   986: aload_2
    //   987: aload_1
    //   988: aload 17
    //   990: aload 18
    //   992: iconst_1
    //   993: iconst_0
    //   994: ldc_w 720
    //   997: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1000: new 340	java/io/IOException
    //   1003: dup
    //   1004: ldc_w 720
    //   1007: invokespecial 721	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1010: athrow
    //   1011: astore_3
    //   1012: aload_0
    //   1013: aload_2
    //   1014: aload_1
    //   1015: aload 17
    //   1017: aload 18
    //   1019: iconst_1
    //   1020: iconst_0
    //   1021: new 42	java/lang/StringBuilder
    //   1024: dup
    //   1025: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1028: ldc_w 723
    //   1031: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_3
    //   1035: invokevirtual 724	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1038: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1047: aload_3
    //   1048: athrow
    //   1049: astore 15
    //   1051: aload 15
    //   1053: invokestatic 726	ayoj:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   1056: astore_3
    //   1057: aload_3
    //   1058: ifnull +12 -> 1070
    //   1061: aload_3
    //   1062: astore_1
    //   1063: aload_3
    //   1064: invokevirtual 649	java/lang/String:length	()I
    //   1067: ifne +9 -> 1076
    //   1070: aload 15
    //   1072: invokevirtual 60	java/lang/Exception:toString	()Ljava/lang/String;
    //   1075: astore_1
    //   1076: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq +40 -> 1119
    //   1082: aload_0
    //   1083: getfield 25	ayoj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1086: iconst_2
    //   1087: aload_1
    //   1088: invokestatic 728	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1091: aload_0
    //   1092: aload_2
    //   1093: ldc_w 312
    //   1096: new 42	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1103: ldc_w 730
    //   1106: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload_1
    //   1110: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1119: new 81	java/util/HashMap
    //   1122: dup
    //   1123: invokespecial 82	java/util/HashMap:<init>	()V
    //   1126: astore_2
    //   1127: aload_2
    //   1128: ldc_w 732
    //   1131: aload_1
    //   1132: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1135: pop
    //   1136: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1139: invokestatic 105	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1142: aconst_null
    //   1143: ldc_w 734
    //   1146: iconst_0
    //   1147: ldc2_w 735
    //   1150: lconst_0
    //   1151: aload_2
    //   1152: ldc 107
    //   1154: iconst_1
    //   1155: invokevirtual 739	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1158: aload 15
    //   1160: athrow
    //   1161: aload_0
    //   1162: aload_2
    //   1163: invokespecial 586	ayoj:a	(Lcom/tencent/image/DownloadParams;)V
    //   1166: aload 18
    //   1168: iconst_1
    //   1169: putfield 578	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1172: aload_1
    //   1173: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1176: aload 18
    //   1178: invokestatic 610	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1181: pop
    //   1182: aload 18
    //   1184: getfield 742	android/graphics/BitmapFactory$Options:outHeight	I
    //   1187: ifeq +11 -> 1198
    //   1190: aload 18
    //   1192: getfield 745	android/graphics/BitmapFactory$Options:outWidth	I
    //   1195: ifne +34 -> 1229
    //   1198: aload_1
    //   1199: invokevirtual 718	java/io/File:delete	()Z
    //   1202: pop
    //   1203: aload_0
    //   1204: aload_2
    //   1205: aload_1
    //   1206: aload 17
    //   1208: aload 18
    //   1210: iconst_1
    //   1211: iconst_0
    //   1212: ldc_w 747
    //   1215: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1218: new 340	java/io/IOException
    //   1221: dup
    //   1222: ldc_w 747
    //   1225: invokespecial 721	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1228: athrow
    //   1229: aload 18
    //   1231: aload 18
    //   1233: aload_2
    //   1234: getfield 750	com/tencent/image/DownloadParams:reqWidth	I
    //   1237: aload_2
    //   1238: getfield 753	com/tencent/image/DownloadParams:reqHeight	I
    //   1241: invokestatic 755	ayoj:b	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1244: putfield 324	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1247: aload 18
    //   1249: getfield 745	android/graphics/BitmapFactory$Options:outWidth	I
    //   1252: istore 6
    //   1254: aload 18
    //   1256: getfield 742	android/graphics/BitmapFactory$Options:outHeight	I
    //   1259: istore 7
    //   1261: aload 18
    //   1263: iconst_0
    //   1264: putfield 578	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1267: iconst_0
    //   1268: istore 9
    //   1270: aconst_null
    //   1271: astore_3
    //   1272: iconst_1
    //   1273: istore 5
    //   1275: aload 15
    //   1277: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1280: ldc_w 757
    //   1283: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1286: ifne +63 -> 1349
    //   1289: aload 15
    //   1291: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1294: ldc_w 759
    //   1297: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1300: ifne +49 -> 1349
    //   1303: aload 15
    //   1305: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1308: ldc_w 761
    //   1311: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1314: ifne +35 -> 1349
    //   1317: aload 15
    //   1319: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1322: ldc_w 763
    //   1325: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1328: ifne +21 -> 1349
    //   1331: aload 15
    //   1333: invokevirtual 398	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1336: ldc_w 765
    //   1339: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1342: istore 10
    //   1344: iload 10
    //   1346: ifeq +749 -> 2095
    //   1349: iconst_3
    //   1350: istore 4
    //   1352: iload 5
    //   1354: iload 4
    //   1356: if_icmpgt +728 -> 2084
    //   1359: aload_1
    //   1360: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1363: aload 18
    //   1365: invokestatic 610	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1368: astore 15
    //   1370: aload 15
    //   1372: astore_3
    //   1373: ldc_w 767
    //   1376: aload_2
    //   1377: getfield 770	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   1380: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1383: ifeq +706 -> 2089
    //   1386: aload 15
    //   1388: astore_3
    //   1389: new 674	ayxa
    //   1392: dup
    //   1393: aload_1
    //   1394: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1397: invokespecial 675	ayxa:<init>	(Ljava/lang/String;)V
    //   1400: aload 15
    //   1402: invokevirtual 676	ayxa:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1405: astore 15
    //   1407: aload 15
    //   1409: astore_3
    //   1410: aload_3
    //   1411: ifnonnull +258 -> 1669
    //   1414: iload 9
    //   1416: istore 10
    //   1418: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1421: ifeq +60 -> 1481
    //   1424: iload 9
    //   1426: istore 10
    //   1428: aload_0
    //   1429: aload_2
    //   1430: ldc_w 312
    //   1433: new 42	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 772
    //   1443: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload 17
    //   1448: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: ldc_w 774
    //   1454: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: iload 5
    //   1459: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1462: ldc_w 776
    //   1465: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: aload_1
    //   1469: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1472: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1481: iload 9
    //   1483: istore 10
    //   1485: new 458	java/lang/OutOfMemoryError
    //   1488: dup
    //   1489: new 42	java/lang/StringBuilder
    //   1492: dup
    //   1493: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1496: ldc_w 772
    //   1499: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: aload 17
    //   1504: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: ldc_w 774
    //   1510: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: iload 5
    //   1515: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1518: ldc_w 776
    //   1521: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload_1
    //   1525: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1528: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokespecial 777	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1537: athrow
    //   1538: astore 15
    //   1540: iload 10
    //   1542: istore 9
    //   1544: aload_3
    //   1545: ifnull +7 -> 1552
    //   1548: aload_3
    //   1549: invokevirtual 672	android/graphics/Bitmap:recycle	()V
    //   1552: aload 15
    //   1554: ifnull +455 -> 2009
    //   1557: aload 15
    //   1559: invokevirtual 724	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1562: astore 15
    //   1564: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1567: ifeq +81 -> 1648
    //   1570: aload_0
    //   1571: aload_2
    //   1572: ldc_w 312
    //   1575: new 42	java/lang/StringBuilder
    //   1578: dup
    //   1579: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1582: ldc_w 779
    //   1585: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: iload 5
    //   1590: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1593: ldc_w 319
    //   1596: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload 18
    //   1601: getfield 324	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1604: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1607: ldc_w 326
    //   1610: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: aload_1
    //   1614: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1617: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: ldc_w 333
    //   1623: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: aload 17
    //   1628: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: ldc_w 781
    //   1634: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload 15
    //   1639: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1648: iload 5
    //   1650: iconst_1
    //   1651: iadd
    //   1652: istore 5
    //   1654: aload 18
    //   1656: aload 18
    //   1658: getfield 324	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1661: iconst_2
    //   1662: imul
    //   1663: putfield 324	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1666: goto -314 -> 1352
    //   1669: iload 9
    //   1671: istore 10
    //   1673: getstatic 786	android/os/Build$VERSION:SDK_INT	I
    //   1676: bipush 11
    //   1678: if_icmplt +328 -> 2006
    //   1681: iload 9
    //   1683: istore 10
    //   1685: aload_3
    //   1686: invokestatic 792	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   1689: istore 11
    //   1691: iload 11
    //   1693: ifeq +313 -> 2006
    //   1696: iload 9
    //   1698: istore 10
    //   1700: new 788	com/tencent/image/SliceBitmap
    //   1703: dup
    //   1704: aload_3
    //   1705: invokespecial 793	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   1708: astore 15
    //   1710: iconst_1
    //   1711: istore 9
    //   1713: aload_3
    //   1714: invokevirtual 672	android/graphics/Bitmap:recycle	()V
    //   1717: aload_0
    //   1718: aload_2
    //   1719: aload_1
    //   1720: aload 17
    //   1722: aload 18
    //   1724: iload 5
    //   1726: iconst_1
    //   1727: ldc_w 795
    //   1730: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1733: aload 15
    //   1735: astore_3
    //   1736: iconst_1
    //   1737: istore 9
    //   1739: aload_3
    //   1740: ifnull +275 -> 2015
    //   1743: iconst_1
    //   1744: istore 10
    //   1746: aload_0
    //   1747: aload_2
    //   1748: aload_1
    //   1749: aload 17
    //   1751: aload 18
    //   1753: iload 5
    //   1755: iload 10
    //   1757: ldc 107
    //   1759: invokespecial 704	ayoj:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1762: aload_2
    //   1763: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1766: ifnull +172 -> 1938
    //   1769: aload_2
    //   1770: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1773: instanceof 278
    //   1776: ifeq +162 -> 1938
    //   1779: aload_2
    //   1780: getfield 276	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1783: checkcast 278	com/tencent/mobileqq/data/MessageForPic
    //   1786: astore_1
    //   1787: aload_1
    //   1788: getfield 281	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   1791: astore 15
    //   1793: aload_1
    //   1794: invokevirtual 796	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   1797: istore 14
    //   1799: aload_3
    //   1800: ifnull +221 -> 2021
    //   1803: iconst_1
    //   1804: istore 10
    //   1806: iload 6
    //   1808: iload 7
    //   1810: imul
    //   1811: istore 8
    //   1813: iload 8
    //   1815: getstatic 799	com/tencent/common/app/BaseApplicationImpl:sImageCacheSize	I
    //   1818: if_icmple +209 -> 2027
    //   1821: iconst_1
    //   1822: istore 11
    //   1824: goto +289 -> 2113
    //   1827: getstatic 801	ayoj:jdField_a_of_type_Int	I
    //   1830: ifeq +9 -> 1839
    //   1833: getstatic 802	ayoj:jdField_b_of_type_Int	I
    //   1836: ifne +35 -> 1871
    //   1839: aload_0
    //   1840: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1843: invokevirtual 462	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1846: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1849: getfield 691	android/util/DisplayMetrics:widthPixels	I
    //   1852: putstatic 801	ayoj:jdField_a_of_type_Int	I
    //   1855: aload_0
    //   1856: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1859: invokevirtual 462	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1862: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1865: getfield 697	android/util/DisplayMetrics:heightPixels	I
    //   1868: putstatic 802	ayoj:jdField_b_of_type_Int	I
    //   1871: getstatic 801	ayoj:jdField_a_of_type_Int	I
    //   1874: getstatic 802	ayoj:jdField_b_of_type_Int	I
    //   1877: if_icmple +162 -> 2039
    //   1880: getstatic 801	ayoj:jdField_a_of_type_Int	I
    //   1883: istore 6
    //   1885: iload 8
    //   1887: getstatic 803	aywm:jdField_a_of_type_Int	I
    //   1890: if_icmpgt +157 -> 2047
    //   1893: iload 6
    //   1895: sipush 1000
    //   1898: if_icmple +149 -> 2047
    //   1901: iconst_1
    //   1902: istore 13
    //   1904: aload_0
    //   1905: iload 11
    //   1907: iload 12
    //   1909: iload 13
    //   1911: iload 9
    //   1913: iload 5
    //   1915: iload 4
    //   1917: aload 15
    //   1919: iload 10
    //   1921: invokespecial 805	ayoj:a	(ZZZZIILjava/lang/String;Z)V
    //   1924: aload_0
    //   1925: aload_0
    //   1926: getfield 27	ayoj:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1929: aload 15
    //   1931: iload 8
    //   1933: iload 14
    //   1935: invokespecial 807	ayoj:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   1938: aload_3
    //   1939: ifnonnull +114 -> 2053
    //   1942: new 340	java/io/IOException
    //   1945: dup
    //   1946: ldc_w 809
    //   1949: invokespecial 721	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1952: athrow
    //   1953: astore 15
    //   1955: iload 9
    //   1957: istore 10
    //   1959: aload_0
    //   1960: aload_2
    //   1961: ldc_w 312
    //   1964: new 42	java/lang/StringBuilder
    //   1967: dup
    //   1968: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1971: ldc_w 811
    //   1974: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: aload 15
    //   1979: invokevirtual 36	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1982: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1988: invokespecial 309	ayoj:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1991: iload 9
    //   1993: istore 10
    //   1995: new 458	java/lang/OutOfMemoryError
    //   1998: dup
    //   1999: ldc_w 813
    //   2002: invokespecial 777	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   2005: athrow
    //   2006: goto -267 -> 1739
    //   2009: aconst_null
    //   2010: astore 15
    //   2012: goto -448 -> 1564
    //   2015: iconst_0
    //   2016: istore 10
    //   2018: goto -272 -> 1746
    //   2021: iconst_0
    //   2022: istore 10
    //   2024: goto -218 -> 1806
    //   2027: iconst_0
    //   2028: istore 11
    //   2030: goto +83 -> 2113
    //   2033: iconst_0
    //   2034: istore 12
    //   2036: goto -209 -> 1827
    //   2039: getstatic 802	ayoj:jdField_b_of_type_Int	I
    //   2042: istore 6
    //   2044: goto -159 -> 1885
    //   2047: iconst_0
    //   2048: istore 13
    //   2050: goto -146 -> 1904
    //   2053: aload_3
    //   2054: areturn
    //   2055: astore 15
    //   2057: goto -513 -> 1544
    //   2060: astore 15
    //   2062: goto -518 -> 1544
    //   2065: astore 15
    //   2067: iconst_1
    //   2068: istore 9
    //   2070: goto -115 -> 1955
    //   2073: astore_3
    //   2074: goto -1062 -> 1012
    //   2077: astore_3
    //   2078: aload 15
    //   2080: astore_1
    //   2081: goto -1069 -> 1012
    //   2084: aconst_null
    //   2085: astore_3
    //   2086: goto -347 -> 1739
    //   2089: aload 15
    //   2091: astore_3
    //   2092: goto -682 -> 1410
    //   2095: iconst_1
    //   2096: istore 4
    //   2098: goto -746 -> 1352
    //   2101: iconst_0
    //   2102: istore 4
    //   2104: goto -1723 -> 381
    //   2107: iconst_1
    //   2108: istore 4
    //   2110: goto -2032 -> 78
    //   2113: iload 6
    //   2115: sipush 2048
    //   2118: if_icmpgt +11 -> 2129
    //   2121: iload 7
    //   2123: sipush 2048
    //   2126: if_icmple -93 -> 2033
    //   2129: iconst_1
    //   2130: istore 12
    //   2132: goto -305 -> 1827
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2135	0	this	ayoj
    //   0	2135	1	paramFile	File
    //   0	2135	2	paramDownloadParams	DownloadParams
    //   0	2135	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   236	1873	4	i	int
    //   1273	641	5	j	int
    //   1252	867	6	k	int
    //   1259	868	7	m	int
    //   1811	121	8	n	int
    //   319	1750	9	bool1	boolean
    //   1342	681	10	bool2	boolean
    //   1689	340	11	bool3	boolean
    //   1907	224	12	bool4	boolean
    //   1902	147	13	bool5	boolean
    //   1797	137	14	bool6	boolean
    //   47	907	15	localObject1	Object
    //   1049	283	15	localException1	Exception
    //   1368	40	15	localBitmap	Bitmap
    //   1538	20	15	localOutOfMemoryError1	OutOfMemoryError
    //   1562	368	15	localObject2	Object
    //   1953	25	15	localException2	Exception
    //   2010	1	15	localObject3	Object
    //   2055	1	15	localOutOfMemoryError2	OutOfMemoryError
    //   2060	1	15	localOutOfMemoryError3	OutOfMemoryError
    //   2065	25	15	localException3	Exception
    //   394	205	16	localObject4	Object
    //   41	1709	17	str1	String
    //   133	1619	18	localOptions	BitmapFactory.Options
    //   442	36	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   381	392	1011	java/lang/OutOfMemoryError
    //   410	416	1011	java/lang/OutOfMemoryError
    //   421	429	1011	java/lang/OutOfMemoryError
    //   438	449	1011	java/lang/OutOfMemoryError
    //   453	488	1011	java/lang/OutOfMemoryError
    //   496	538	1011	java/lang/OutOfMemoryError
    //   546	564	1011	java/lang/OutOfMemoryError
    //   578	583	1011	java/lang/OutOfMemoryError
    //   586	606	1011	java/lang/OutOfMemoryError
    //   606	647	1011	java/lang/OutOfMemoryError
    //   721	745	1011	java/lang/OutOfMemoryError
    //   745	769	1011	java/lang/OutOfMemoryError
    //   769	852	1011	java/lang/OutOfMemoryError
    //   852	867	1011	java/lang/OutOfMemoryError
    //   869	980	1011	java/lang/OutOfMemoryError
    //   980	1011	1011	java/lang/OutOfMemoryError
    //   37	75	1049	java/lang/Exception
    //   78	126	1049	java/lang/Exception
    //   126	233	1049	java/lang/Exception
    //   249	321	1049	java/lang/Exception
    //   329	378	1049	java/lang/Exception
    //   381	392	1049	java/lang/Exception
    //   410	416	1049	java/lang/Exception
    //   421	429	1049	java/lang/Exception
    //   438	449	1049	java/lang/Exception
    //   453	488	1049	java/lang/Exception
    //   496	538	1049	java/lang/Exception
    //   546	564	1049	java/lang/Exception
    //   578	583	1049	java/lang/Exception
    //   586	606	1049	java/lang/Exception
    //   606	647	1049	java/lang/Exception
    //   654	697	1049	java/lang/Exception
    //   697	709	1049	java/lang/Exception
    //   721	745	1049	java/lang/Exception
    //   745	769	1049	java/lang/Exception
    //   769	852	1049	java/lang/Exception
    //   852	867	1049	java/lang/Exception
    //   869	980	1049	java/lang/Exception
    //   980	1011	1049	java/lang/Exception
    //   1012	1049	1049	java/lang/Exception
    //   1161	1198	1049	java/lang/Exception
    //   1198	1229	1049	java/lang/Exception
    //   1229	1267	1049	java/lang/Exception
    //   1275	1344	1049	java/lang/Exception
    //   1359	1370	1049	java/lang/Exception
    //   1373	1386	1049	java/lang/Exception
    //   1389	1407	1049	java/lang/Exception
    //   1418	1424	1049	java/lang/Exception
    //   1428	1481	1049	java/lang/Exception
    //   1485	1538	1049	java/lang/Exception
    //   1548	1552	1049	java/lang/Exception
    //   1557	1564	1049	java/lang/Exception
    //   1564	1648	1049	java/lang/Exception
    //   1654	1666	1049	java/lang/Exception
    //   1673	1681	1049	java/lang/Exception
    //   1685	1691	1049	java/lang/Exception
    //   1746	1799	1049	java/lang/Exception
    //   1813	1821	1049	java/lang/Exception
    //   1827	1839	1049	java/lang/Exception
    //   1839	1871	1049	java/lang/Exception
    //   1871	1885	1049	java/lang/Exception
    //   1885	1893	1049	java/lang/Exception
    //   1904	1938	1049	java/lang/Exception
    //   1942	1953	1049	java/lang/Exception
    //   1959	1991	1049	java/lang/Exception
    //   1995	2006	1049	java/lang/Exception
    //   2039	2044	1049	java/lang/Exception
    //   1418	1424	1538	java/lang/OutOfMemoryError
    //   1428	1481	1538	java/lang/OutOfMemoryError
    //   1485	1538	1538	java/lang/OutOfMemoryError
    //   1673	1681	1538	java/lang/OutOfMemoryError
    //   1685	1691	1538	java/lang/OutOfMemoryError
    //   1700	1710	1538	java/lang/OutOfMemoryError
    //   1959	1991	1538	java/lang/OutOfMemoryError
    //   1995	2006	1538	java/lang/OutOfMemoryError
    //   1700	1710	1953	java/lang/Exception
    //   1359	1370	2055	java/lang/OutOfMemoryError
    //   1373	1386	2055	java/lang/OutOfMemoryError
    //   1389	1407	2055	java/lang/OutOfMemoryError
    //   1713	1733	2060	java/lang/OutOfMemoryError
    //   1713	1733	2065	java/lang/Exception
    //   249	321	2073	java/lang/OutOfMemoryError
    //   654	697	2073	java/lang/OutOfMemoryError
    //   697	709	2073	java/lang/OutOfMemoryError
    //   329	378	2077	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayoj
 * JD-Core Version:    0.7.0.1
 */