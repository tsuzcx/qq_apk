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
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class bera
  extends beqz
{
  public static int a;
  public static int b;
  private static int c = 1048576;
  private static int d = c * 2;
  protected BaseApplicationImpl a;
  protected String b;
  
  public bera(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
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
      bdmc.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
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
        bdmc.a(BaseApplication.getContext()).a(paramApplication.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
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
  
  public static void a(berb paramberb, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, betf parambetf1, betf parambetf2, betg parambetg)
  {
    System.currentTimeMillis();
    long l1;
    if (parambetg != null)
    {
      l1 = parambetg.e;
      if (parambetg == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = parambetg.f;; l2 = 0L)
    {
      if (!bewk.a(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramInt2, paramString, parambetf2, parambetg, paramBoolean, parambetf1);
    localHashMap.put("param_uuid", paramberb.f);
    localHashMap.put("flow", String.valueOf(l1));
    localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramberb.jdField_a_of_type_Long * 1000L)));
    localHashMap.put("client_exist", String.valueOf(paramberb.jdField_a_of_type_Boolean));
    if (parambetf2 != null) {
      localHashMap.put("param_RequestUrl", parambetf2.a());
    }
    if (parambetg != null) {
      localHashMap.put("param_HttpTran", parambetg.a());
    }
    if (parambetg != null)
    {
      localHashMap.put("param_retry", String.valueOf(parambetg.jdField_b_of_type_Int));
      if (parambetg.jdField_a_of_type_Boolean)
      {
        localHashMap.put("serverip", parambetg.jdField_b_of_type_JavaLangString);
        localHashMap.put("param_Server", parambetg.jdField_b_of_type_JavaLangString);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label366;
      }
      if ((!paramberb.c.equals("actC2CPicDownloadV1")) && (!paramberb.c.equals("actC2CPicSmallDownV1"))) {
        break label351;
      }
      localHashMap.put("param_toUin", paramberb.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).a(null, paramberb.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("serverip", parambetg.c);
      localHashMap.put("param_Server", parambetg.c);
      if (paramInt2 != -9527) {
        break;
      }
      localHashMap.put("param_rspHeader", parambetg.d);
      break;
      label351:
      localHashMap.put("param_grpUin", paramberb.jdField_a_of_type_JavaLangString);
    }
    label366:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramberb.g != null) && (!paramberb.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramberb.g);
    }
    long l3 = paramInt1;
    if ((paramberb.c.equals("actC2CPicDownloadV1")) || (paramberb.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramberb.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramberb.e);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).a(null, paramberb.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramberb.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramberb.e);
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
      ((QQAppInterface)localObject).a().d();
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
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 320	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 322	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 329	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +94 -> 128
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 335	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 338	java/io/OutputStream:flush	()V
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
    //   64: ldc_w 339
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 345 2 0
    //   74: goto -49 -> 25
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 346	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: ldc_w 348
    //   87: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +47 -> 137
    //   93: new 354	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   96: dup
    //   97: sipush 9040
    //   100: ldc2_w 355
    //   103: aload_2
    //   104: invokevirtual 346	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokespecial 359	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   112: athrow
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 362	java/io/FileInputStream:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 362	java/io/FileInputStream:close	()V
    //   136: return
    //   137: new 354	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   140: dup
    //   141: sipush 9301
    //   144: ldc2_w 363
    //   147: aload_2
    //   148: invokevirtual 346	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: iconst_0
    //   152: iconst_0
    //   153: invokespecial 359	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
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
    //   0	173	2	paramURLDrawableHandler	URLDrawableHandler
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
      if ((((DownloadParams)localObject).tag instanceof azqr))
      {
        paramObject = (azqr)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i = bews.a(beyq.a((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          bews.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
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
        i = bews.a(beyq.a((String)localObject, bool));
        bews.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  public static void a(HashMap<String, String> paramHashMap, int paramInt, String paramString, betf parambetf1, betg parambetg, boolean paramBoolean, betf parambetf2)
  {
    String str;
    if (!berp.a(paramInt, paramHashMap))
    {
      paramHashMap.put("param_FailCode", Integer.toString(paramInt));
      if ((paramInt == -9527) || (paramInt == 9311) || (paramInt == 9044) || (paramInt == 9350) || (paramInt == 9351))
      {
        paramHashMap.put(berp.k, paramString);
        str = "";
        if ((!paramBoolean) || (parambetf2 != null) || (parambetf1 != null) || (parambetg != null)) {
          break label157;
        }
        paramString = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reportResult", 2, "parmStep: " + paramString);
      }
      paramHashMap.put("param_step", paramString);
      return;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      label157:
      paramString = str;
      if (parambetf2 != null)
      {
        paramString = str;
        if (parambetf1 != null)
        {
          paramString = str;
          if (parambetg != null) {
            paramString = parambetf2.a(1) + ";" + parambetf1.a(2) + ";" + parambetg.a(3);
          }
        }
      }
    }
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
        boolean bool = bmgb.a(paramDownloadParams.mImgType);
        j = besm.b(bool);
        i = besm.a(bool);
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i1 = besm.c(bool);
        int i2 = besm.d(bool);
        if ((n >= i2) && (k >= i2)) {
          break label362;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label333;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, beyq.b);
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
  
  public Object a(File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    String str1 = paramDownloadParams.urlStr;
    for (;;)
    {
      try
      {
        localObject1 = paramFile.getAbsolutePath();
        paramOptions.inPreferredConfig = beyq.b;
        paramOptions.inJustDecodeBounds = false;
        localObject2 = paramFile.getName();
        if (!((String)localObject2).endsWith("_hd"))
        {
          localObject2 = new File((String)localObject1 + "_hd");
          bool = ((File)localObject2).exists();
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        Object localObject3;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          a(paramDownloadParams, "DecodeFile", "DecodeFile hd thumb instead,cacheFile=" + ((File)localObject2).getAbsolutePath() + ", url=" + str1);
        }
        paramFile = (File)localObject2;
        i = 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        paramFile = (File)localObject2;
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject2 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = localObject2;
          if (i != 0)
          {
            bool = bhmi.a((String)localObject1);
            if (bool)
            {
              localObject3 = SafeBitmapFactory.decodeFile((String)localObject1, paramOptions);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                String str2 = bjtz.a((String)localObject1);
                bhmi.d((String)localObject1);
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  a(paramDownloadParams, "DecodeFile", "delete err thumb md5=" + str2);
                  localObject2 = localObject3;
                }
              }
            }
            localObject3 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder().append("decode hd failed, try decode thumb ").append((String)localObject1).append(" exist=").append(bool).append(" result=");
              if (localObject2 == null) {
                continue;
              }
              bool = true;
              a(paramDownloadParams, "DecodeFile", bool);
              localObject3 = localObject2;
            }
          }
        }
        if (localObject3 != null)
        {
          if (i != 0) {
            bhmi.d((String)localObject1);
          }
          localObject1 = localObject3;
          if (paramDownloadParams.mDecodeHandler != null) {
            localObject1 = paramDownloadParams.mDecodeHandler.run(paramDownloadParams, (Bitmap)localObject3);
          }
          if (paramDownloadParams.tag != null)
          {
            if ((paramDownloadParams.tag instanceof MessageForPic)) {
              if (((MessageForPic)paramDownloadParams.tag).subMsgType != 2)
              {
                bool = str1.endsWith("?noRound");
                if (!bool) {}
              }
              else
              {
                return localObject1;
                if (((String)localObject2).length() <= 3) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  a(paramDownloadParams, "DecodeFile", "DecodeFile hd ,hdPath=" + (String)localObject1);
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 3);
                i = 1;
                continue;
                bool = false;
                continue;
              }
            }
            if ((paramDownloadParams.tag instanceof bezc)) {
              return ((bezc)paramDownloadParams.tag).a((Bitmap)localObject1);
            }
          }
          localObject2 = a((Bitmap)localObject1, paramDownloadParams);
          if (!localObject1.equals(((RoundRectBitmap)localObject2).mBitmap)) {
            ((Bitmap)localObject1).recycle();
          }
          localObject1 = new RoundRectBitmap(new bezd(paramFile.getAbsolutePath()).a(((RoundRectBitmap)localObject2).mBitmap), ((RoundRectBitmap)localObject2).mCornerRadius, ((RoundRectBitmap)localObject2).mBoardColor, ((RoundRectBitmap)localObject2).mBorderWidth);
          if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null)
          {
            ((RoundRectBitmap)localObject1).mDisplayWidth = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels;
            ((RoundRectBitmap)localObject1).mDisplayHeight = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels;
          }
          a(paramDownloadParams, paramFile, str1, paramOptions, 1, true, "step:create roundBitmap");
          return localObject1;
        }
        if (!((azqr)paramDownloadParams.tag).isSendFromLocal())
        {
          localObject1 = bjtz.a(paramFile.getAbsolutePath());
          localObject2 = ((azqr)paramDownloadParams.tag).getPicDownloadInfo();
          QLog.i("Q.richmedia." + bews.b(((azqd)localObject2).jdField_b_of_type_Int) + ".dw", 1, "id:" + String.valueOf(((azqd)localObject2).jdField_a_of_type_Long) + "step: UIDecoder FAIL srcPicMD5:" + (String)localObject1);
        }
        paramFile.delete();
        a(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:decode error, not valid pic");
        throw new IOException("step:decode error, not valid pic");
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        a(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:create roundBitmap, " + localOutOfMemoryError1.getMessage());
        throw localOutOfMemoryError1;
      }
    }
  }
  
  /* Error */
  public Object a(URL paramURL, File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 557	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: astore 17
    //   6: aload 4
    //   8: aload 4
    //   10: aload_3
    //   11: getfield 704	com/tencent/image/DownloadParams:reqWidth	I
    //   14: aload_3
    //   15: getfield 707	com/tencent/image/DownloadParams:reqHeight	I
    //   18: invokestatic 709	bera:b	(Landroid/graphics/BitmapFactory$Options;II)I
    //   21: putfield 301	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   24: aload 4
    //   26: getfield 712	android/graphics/BitmapFactory$Options:outWidth	I
    //   29: istore 7
    //   31: aload 4
    //   33: getfield 715	android/graphics/BitmapFactory$Options:outHeight	I
    //   36: istore 8
    //   38: aload 4
    //   40: iconst_0
    //   41: putfield 563	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: iconst_0
    //   45: istore 10
    //   47: aconst_null
    //   48: astore 16
    //   50: iconst_1
    //   51: istore 6
    //   53: aload_1
    //   54: invokevirtual 375	java/net/URL:getProtocol	()Ljava/lang/String;
    //   57: ldc_w 717
    //   60: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +42 -> 105
    //   66: aload_1
    //   67: invokevirtual 375	java/net/URL:getProtocol	()Ljava/lang/String;
    //   70: ldc_w 719
    //   73: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne +29 -> 105
    //   79: aload_1
    //   80: invokevirtual 375	java/net/URL:getProtocol	()Ljava/lang/String;
    //   83: ldc_w 721
    //   86: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +16 -> 105
    //   92: aload_1
    //   93: invokevirtual 375	java/net/URL:getProtocol	()Ljava/lang/String;
    //   96: ldc_w 723
    //   99: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +754 -> 856
    //   105: iconst_3
    //   106: istore 5
    //   108: aload 16
    //   110: astore_1
    //   111: iload 6
    //   113: iload 5
    //   115: if_icmpgt +730 -> 845
    //   118: aload_2
    //   119: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   122: aload 4
    //   124: invokestatic 586	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore 16
    //   129: aload 16
    //   131: astore_1
    //   132: ldc_w 725
    //   135: aload_3
    //   136: getfield 728	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   139: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +708 -> 850
    //   145: aload 16
    //   147: astore_1
    //   148: new 650	bezd
    //   151: dup
    //   152: aload_2
    //   153: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokespecial 651	bezd:<init>	(Ljava/lang/String;)V
    //   159: aload 16
    //   161: invokevirtual 652	bezd:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   164: astore 16
    //   166: aload 16
    //   168: astore_1
    //   169: aload_1
    //   170: ifnonnull +258 -> 428
    //   173: iload 10
    //   175: istore 11
    //   177: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +60 -> 240
    //   183: iload 10
    //   185: istore 11
    //   187: aload_0
    //   188: aload_3
    //   189: ldc_w 289
    //   192: new 42	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 730
    //   202: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 17
    //   207: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 732
    //   213: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 6
    //   218: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 734
    //   224: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   231: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokespecial 280	bera:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   240: iload 10
    //   242: istore 11
    //   244: new 463	java/lang/OutOfMemoryError
    //   247: dup
    //   248: new 42	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 730
    //   258: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 17
    //   263: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 732
    //   269: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload 6
    //   274: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 734
    //   280: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_2
    //   284: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 735	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   296: athrow
    //   297: astore 16
    //   299: iload 11
    //   301: istore 10
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 648	android/graphics/Bitmap:recycle	()V
    //   311: aload 16
    //   313: ifnull +468 -> 781
    //   316: aload 16
    //   318: invokevirtual 700	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   321: astore 16
    //   323: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +81 -> 407
    //   329: aload_0
    //   330: aload_3
    //   331: ldc_w 289
    //   334: new 42	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 737
    //   344: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 6
    //   349: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc_w 296
    //   355: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 4
    //   360: getfield 301	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   363: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc_w 303
    //   369: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_2
    //   373: invokevirtual 308	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   376: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 310
    //   382: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 17
    //   387: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 739
    //   393: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 16
    //   398: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokespecial 280	bera:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   407: iload 6
    //   409: iconst_1
    //   410: iadd
    //   411: istore 6
    //   413: aload 4
    //   415: aload 4
    //   417: getfield 301	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   420: iconst_2
    //   421: imul
    //   422: putfield 301	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   425: goto -314 -> 111
    //   428: iload 10
    //   430: istore 11
    //   432: getstatic 744	android/os/Build$VERSION:SDK_INT	I
    //   435: bipush 11
    //   437: if_icmplt +341 -> 778
    //   440: iload 10
    //   442: istore 11
    //   444: aload_1
    //   445: invokestatic 750	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   448: istore 12
    //   450: iload 12
    //   452: ifeq +326 -> 778
    //   455: iload 10
    //   457: istore 11
    //   459: new 746	com/tencent/image/SliceBitmap
    //   462: dup
    //   463: aload_1
    //   464: invokespecial 751	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   467: astore 16
    //   469: iconst_1
    //   470: istore 10
    //   472: aload_1
    //   473: invokevirtual 648	android/graphics/Bitmap:recycle	()V
    //   476: aload_0
    //   477: aload_3
    //   478: aload_2
    //   479: aload 17
    //   481: aload 4
    //   483: iload 6
    //   485: iconst_1
    //   486: ldc_w 753
    //   489: invokespecial 680	bera:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   492: aload 16
    //   494: astore_1
    //   495: iconst_1
    //   496: istore 10
    //   498: aload_1
    //   499: ifnull +288 -> 787
    //   502: iconst_1
    //   503: istore 11
    //   505: aload_0
    //   506: aload_3
    //   507: aload_2
    //   508: aload 17
    //   510: aload 4
    //   512: iload 6
    //   514: iload 11
    //   516: ldc 107
    //   518: invokespecial 680	bera:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   521: aload_3
    //   522: getfield 247	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   525: ifnull +185 -> 710
    //   528: aload_3
    //   529: getfield 247	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   532: instanceof 249
    //   535: ifeq +175 -> 710
    //   538: aload_3
    //   539: getfield 247	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   542: checkcast 249	com/tencent/mobileqq/data/MessageForPic
    //   545: astore_2
    //   546: aload_2
    //   547: getfield 252	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   550: astore_3
    //   551: aload_2
    //   552: invokevirtual 754	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   555: istore 15
    //   557: aload_1
    //   558: ifnull +235 -> 793
    //   561: iconst_1
    //   562: istore 11
    //   564: iload 7
    //   566: iload 8
    //   568: imul
    //   569: istore 9
    //   571: iload 9
    //   573: getstatic 757	com/tencent/common/app/BaseApplicationImpl:sImageCacheSize	I
    //   576: if_icmple +223 -> 799
    //   579: iconst_1
    //   580: istore 12
    //   582: iload 7
    //   584: sipush 2048
    //   587: if_icmpgt +11 -> 598
    //   590: iload 8
    //   592: sipush 2048
    //   595: if_icmple +210 -> 805
    //   598: iconst_1
    //   599: istore 13
    //   601: getstatic 759	bera:jdField_a_of_type_Int	I
    //   604: ifeq +9 -> 613
    //   607: getstatic 760	bera:jdField_b_of_type_Int	I
    //   610: ifne +35 -> 645
    //   613: aload_0
    //   614: getfield 27	bera:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   617: invokevirtual 467	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   620: invokevirtual 473	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   623: getfield 667	android/util/DisplayMetrics:widthPixels	I
    //   626: putstatic 759	bera:jdField_a_of_type_Int	I
    //   629: aload_0
    //   630: getfield 27	bera:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   633: invokevirtual 467	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   636: invokevirtual 473	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   639: getfield 673	android/util/DisplayMetrics:heightPixels	I
    //   642: putstatic 760	bera:jdField_b_of_type_Int	I
    //   645: getstatic 759	bera:jdField_a_of_type_Int	I
    //   648: getstatic 760	bera:jdField_b_of_type_Int	I
    //   651: if_icmple +160 -> 811
    //   654: getstatic 759	bera:jdField_a_of_type_Int	I
    //   657: istore 7
    //   659: iload 9
    //   661: getstatic 761	beyq:jdField_a_of_type_Int	I
    //   664: if_icmpgt +155 -> 819
    //   667: iload 7
    //   669: sipush 1000
    //   672: if_icmple +147 -> 819
    //   675: iconst_1
    //   676: istore 14
    //   678: aload_0
    //   679: iload 12
    //   681: iload 13
    //   683: iload 14
    //   685: iload 10
    //   687: iload 6
    //   689: iload 5
    //   691: aload_3
    //   692: iload 11
    //   694: invokespecial 763	bera:a	(ZZZZIILjava/lang/String;Z)V
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 27	bera:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   702: aload_3
    //   703: iload 9
    //   705: iload 15
    //   707: invokespecial 765	bera:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   710: aload_1
    //   711: ifnonnull +114 -> 825
    //   714: new 317	java/io/IOException
    //   717: dup
    //   718: ldc_w 767
    //   721: invokespecial 697	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   724: athrow
    //   725: astore 16
    //   727: iload 10
    //   729: istore 11
    //   731: aload_0
    //   732: aload_3
    //   733: ldc_w 289
    //   736: new 42	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 769
    //   746: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 16
    //   751: invokevirtual 36	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   754: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokespecial 280	bera:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   763: iload 10
    //   765: istore 11
    //   767: new 463	java/lang/OutOfMemoryError
    //   770: dup
    //   771: ldc_w 771
    //   774: invokespecial 735	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   777: athrow
    //   778: goto -280 -> 498
    //   781: aconst_null
    //   782: astore 16
    //   784: goto -461 -> 323
    //   787: iconst_0
    //   788: istore 11
    //   790: goto -285 -> 505
    //   793: iconst_0
    //   794: istore 11
    //   796: goto -232 -> 564
    //   799: iconst_0
    //   800: istore 12
    //   802: goto -220 -> 582
    //   805: iconst_0
    //   806: istore 13
    //   808: goto -207 -> 601
    //   811: getstatic 760	bera:jdField_b_of_type_Int	I
    //   814: istore 7
    //   816: goto -157 -> 659
    //   819: iconst_0
    //   820: istore 14
    //   822: goto -144 -> 678
    //   825: aload_1
    //   826: areturn
    //   827: astore 16
    //   829: goto -526 -> 303
    //   832: astore 16
    //   834: goto -531 -> 303
    //   837: astore 16
    //   839: iconst_1
    //   840: istore 10
    //   842: goto -115 -> 727
    //   845: aconst_null
    //   846: astore_1
    //   847: goto -349 -> 498
    //   850: aload 16
    //   852: astore_1
    //   853: goto -684 -> 169
    //   856: iconst_1
    //   857: istore 5
    //   859: aload 16
    //   861: astore_1
    //   862: goto -751 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	bera
    //   0	865	1	paramURL	URL
    //   0	865	2	paramFile	File
    //   0	865	3	paramDownloadParams	DownloadParams
    //   0	865	4	paramOptions	BitmapFactory.Options
    //   106	752	5	i	int
    //   51	637	6	j	int
    //   29	786	7	k	int
    //   36	560	8	m	int
    //   569	135	9	n	int
    //   45	796	10	bool1	boolean
    //   175	620	11	bool2	boolean
    //   448	353	12	bool3	boolean
    //   599	208	13	bool4	boolean
    //   676	145	14	bool5	boolean
    //   555	151	15	bool6	boolean
    //   48	119	16	localBitmap	Bitmap
    //   297	20	16	localOutOfMemoryError1	OutOfMemoryError
    //   321	172	16	localObject1	Object
    //   725	25	16	localException1	Exception
    //   782	1	16	localObject2	Object
    //   827	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   832	1	16	localOutOfMemoryError3	OutOfMemoryError
    //   837	23	16	localException2	Exception
    //   4	505	17	str	String
    // Exception table:
    //   from	to	target	type
    //   177	183	297	java/lang/OutOfMemoryError
    //   187	240	297	java/lang/OutOfMemoryError
    //   244	297	297	java/lang/OutOfMemoryError
    //   432	440	297	java/lang/OutOfMemoryError
    //   444	450	297	java/lang/OutOfMemoryError
    //   459	469	297	java/lang/OutOfMemoryError
    //   731	763	297	java/lang/OutOfMemoryError
    //   767	778	297	java/lang/OutOfMemoryError
    //   459	469	725	java/lang/Exception
    //   118	129	827	java/lang/OutOfMemoryError
    //   132	145	827	java/lang/OutOfMemoryError
    //   148	166	827	java/lang/OutOfMemoryError
    //   472	492	832	java/lang/OutOfMemoryError
    //   472	492	837	java/lang/Exception
  }
  
  protected boolean a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return GifDrawable.isGifFile(paramFile);
  }
  
  protected boolean b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "lbsthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      a(paramDownloadParams, "DecodeFile", "decodeFile config.tag " + paramDownloadParams.tag);
    }
    URL localURL;
    BitmapFactory.Options localOptions;
    try
    {
      String str = paramDownloadParams.urlStr;
      localURL = paramDownloadParams.url;
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile START,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = beyq.jdField_a_of_type_AndroidGraphicsBitmap$Config;
      localOptions.inDensity = 160;
      localOptions.inTargetDensity = 160;
      localOptions.inScreenDensity = 160;
      localOptions.inJustDecodeBounds = true;
      if (a(paramFile, paramDownloadParams, paramURLDrawableHandler))
      {
        a(paramDownloadParams);
        if (!QLog.isColorLevel()) {
          break label422;
        }
        a(paramDownloadParams, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
        break label422;
      }
      if (b(paramFile, paramDownloadParams, paramURLDrawableHandler)) {
        return a(paramFile, paramDownloadParams, localOptions);
      }
      a(paramDownloadParams);
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0))
      {
        paramFile.delete();
        a(paramDownloadParams, paramFile, str, localOptions, 1, false, "step:decode bounds error, not valid pic");
        throw new IOException("step:decode bounds error, not valid pic");
      }
    }
    catch (Exception localException)
    {
      paramURLDrawableHandler = a(localException);
      if (paramURLDrawableHandler != null)
      {
        paramFile = paramURLDrawableHandler;
        if (paramURLDrawableHandler.length() != 0) {}
      }
      else
      {
        paramFile = localException.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, paramFile);
        a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + paramFile);
      }
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("params_failDesc", paramFile);
      bdmc.a(BaseApplication.getContext()).a(null, "actPicUIDecoder", false, -1L, 0L, paramDownloadParams, "", true);
      throw localException;
    }
    paramFile = a(localURL, paramFile, paramDownloadParams, localOptions);
    return paramFile;
    label422:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bera
 * JD-Core Version:    0.7.0.1
 */