import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.transfile.VasExtensionDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;

public class axwg
  extends axoa
{
  protected BaseApplicationImpl a;
  
  public axwg(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    return a(paramBitmap, false);
  }
  
  private Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap == null) || (this.a == null)) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f1;
    float f5;
    float f6;
    float f4;
    float f3;
    float f2;
    if (j <= i)
    {
      f1 = j / 2;
      f5 = j;
      f6 = j;
      f4 = j;
      f3 = j;
      i = j;
      f2 = 0.0F;
    }
    for (;;)
    {
      if (paramBoolean) {
        f1 = 5.0F * this.a.getResources().getDisplayMetrics().density + 0.5F;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect((int)f2, (int)0.0F, (int)f6, (int)f5);
      Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f4, (int)f3);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      f1 = i / 2;
      f6 = (j - i) / 2;
      float f7 = j;
      f5 = i;
      f4 = i;
      f3 = i;
      f2 = f6;
      f6 = f7 - f6;
      j = i;
    }
  }
  
  private File a(String paramString, DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams.url != null) && (!TextUtils.isEmpty(paramDownloadParams.url.getFile())))
    {
      String str1 = paramDownloadParams.url.getFile();
      paramDownloadParams = str1;
      if (str1.startsWith("/")) {
        paramDownloadParams = str1.substring(1, str1.length());
      }
      String str2 = MD5.toMD5(paramDownloadParams);
      StringBuilder localStringBuilder = new StringBuilder().append(File.separator);
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = "null";; str1 = str2.substring(0, 2))
      {
        str1 = str1;
        str1 = ajed.aU + paramString + str1 + File.separator + str2;
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, paramString + " save local filePath: " + str1);
        }
        paramString = new File(str1);
        if (!paramString.exists()) {
          break;
        }
        return paramString;
      }
      paramDownloadParams = new batm(paramDownloadParams, paramString);
      paramDownloadParams.e = anfj.b;
      if (bato.a(paramDownloadParams, null) == 0) {
        return paramString;
      }
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i > j) {}
    for (float f = paramInt1 / i;; f = paramInt2 / j)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {}
    String str;
    do
    {
      return null;
      str = paramDownloadParams.url.getHost();
      paramOutputStream = paramDownloadParams.url.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "downloadImage, host = " + str + ", epId = " + paramOutputStream);
      }
      if (!"EMOTICON_TAB".equals(str)) {
        break;
      }
    } while ((paramDownloadParams.mExtraInfo == null) || (paramOutputStream == null));
    if (paramOutputStream.startsWith("/")) {
      paramOutputStream = paramOutputStream.substring(1, paramOutputStream.length());
    }
    for (;;)
    {
      paramURLDrawableHandler = paramOutputStream.split("_");
      paramOutputStream = paramURLDrawableHandler[0];
      Object localObject1 = (Boolean)paramDownloadParams.mExtraInfo;
      boolean bool1 = Boolean.valueOf(paramURLDrawableHandler[1]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "downloadImage, completed = " + bool1 + ", epId = " + paramOutputStream);
      }
      label195:
      Object localObject2;
      if (bool1)
      {
        paramURLDrawableHandler = anam.a(3, paramOutputStream);
        localObject2 = new File(paramURLDrawableHandler);
      }
      for (;;)
      {
        try
        {
          boolean bool2 = ((File)localObject2).exists();
          if (bool2)
          {
            return localObject2;
            paramURLDrawableHandler = anam.a(4, paramOutputStream);
            break label195;
          }
          if (!bool1) {
            continue;
          }
          if (((Boolean)localObject1).booleanValue()) {
            continue;
          }
          paramOutputStream = anam.b(3, paramOutputStream);
        }
        catch (OutOfMemoryError paramOutputStream)
        {
          label256:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
          paramOutputStream = null;
          continue;
        }
        localObject1 = paramURLDrawableHandler;
        paramURLDrawableHandler = paramOutputStream;
        paramOutputStream = (OutputStream)localObject1;
        if (paramURLDrawableHandler == null) {
          break label1412;
        }
        if ((!"FAVORITE_PANEL_THUMB".equals(str)) && (!"BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(str)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(str))) {
          paramDownloadParams.url = new URL(paramURLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "downloadImage : " + paramURLDrawableHandler + " -> " + paramOutputStream);
        }
        localObject1 = new File(paramOutputStream);
        localObject2 = new batm(paramURLDrawableHandler, (File)localObject1);
        ((batm)localObject2).e = anfj.b;
        if (bato.a((batm)localObject2, null) != 0) {
          break;
        }
        if (((paramDownloadParams.mExtraInfo instanceof ankl)) && (("FAVORITE_PANEL_THUMB".equals(str)) || ("FAVORITE_PANEL_THUMB_NEW".equals(str)))) {
          a((ankl)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "download sucessful " + paramURLDrawableHandler + " to path " + paramOutputStream);
        }
        return localObject1;
        paramOutputStream = anam.b(17, paramOutputStream);
        continue;
        if (!((Boolean)localObject1).booleanValue()) {
          paramOutputStream = anam.b(4, paramOutputStream);
        } else {
          paramOutputStream = anam.b(18, paramOutputStream);
        }
      }
      if (("FAVOROTE_PANEL_DYNAMIC".equals(str)) || ("BUSINESS_CAMERA_EMO_PANEL_DYNAMIC".equals(str)))
      {
        if (!TextUtils.isEmpty(paramOutputStream))
        {
          paramURLDrawableHandler = new File(paramOutputStream);
          if (paramURLDrawableHandler.exists()) {
            return paramURLDrawableHandler;
          }
        }
        if ((paramDownloadParams.mExtraInfo instanceof ankl))
        {
          localObject1 = ((ankl)paramDownloadParams.mExtraInfo).e;
          paramURLDrawableHandler = (URLDrawableHandler)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject1 }));
            paramURLDrawableHandler = (URLDrawableHandler)localObject1;
          }
        }
        for (;;)
        {
          break label256;
          if ((paramDownloadParams.mExtraInfo instanceof anhh))
          {
            localObject1 = ((anhh)paramDownloadParams.mExtraInfo).e;
            paramURLDrawableHandler = (URLDrawableHandler)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject1 }));
              paramURLDrawableHandler = (URLDrawableHandler)localObject1;
            }
          }
          else
          {
            if (!(paramDownloadParams.mExtraInfo instanceof String)) {
              break;
            }
            localObject1 = (String)paramDownloadParams.mExtraInfo;
            paramURLDrawableHandler = (URLDrawableHandler)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject1 }));
              paramURLDrawableHandler = (URLDrawableHandler)localObject1;
            }
          }
        }
      }
      if (("FAVORITE_PANEL_THUMB".equals(str)) || ("FAVORITE_PANEL_THUMB_NEW".equals(str)))
      {
        if (!TextUtils.isEmpty(paramOutputStream))
        {
          paramURLDrawableHandler = new File(paramOutputStream);
          if (paramURLDrawableHandler.exists()) {
            return paramURLDrawableHandler;
          }
        }
        if (!(paramDownloadParams.mExtraInfo instanceof ankl)) {
          break label1422;
        }
        localObject2 = ((ankl)paramDownloadParams.mExtraInfo).e;
        paramURLDrawableHandler = (URLDrawableHandler)localObject2;
        localObject1 = paramOutputStream;
        if (QLog.isColorLevel())
        {
          QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject2 }));
          localObject1 = paramOutputStream;
        }
      }
      for (paramURLDrawableHandler = (URLDrawableHandler)localObject2;; paramURLDrawableHandler = null)
      {
        paramOutputStream = (OutputStream)localObject1;
        break label256;
        if ("BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(str))
        {
          if (!TextUtils.isEmpty(paramOutputStream))
          {
            paramURLDrawableHandler = new File(paramOutputStream);
            if (paramURLDrawableHandler.exists()) {
              return paramURLDrawableHandler;
            }
          }
          if (!(paramDownloadParams.mExtraInfo instanceof anhh)) {
            break label1414;
          }
          localObject2 = ((anhh)paramDownloadParams.mExtraInfo).e;
          paramURLDrawableHandler = (URLDrawableHandler)localObject2;
          localObject1 = paramOutputStream;
          if (QLog.isColorLevel())
          {
            QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject2 }));
            localObject1 = paramOutputStream;
          }
        }
        for (paramURLDrawableHandler = (URLDrawableHandler)localObject2;; paramURLDrawableHandler = null)
        {
          paramOutputStream = (OutputStream)localObject1;
          break label256;
          if ("RESOURCE_IMG".equals(str)) {
            break;
          }
          if ("EMOTICON_DIY".equals(str)) {
            return new File(ajed.aU);
          }
          if ("REDPACKET_SEND_PIC".equals(str))
          {
            paramOutputStream = BaseApplicationImpl.sApplication.getRuntime().getAccount();
            try
            {
              paramOutputStream = (AppInterface)this.a.getAppRuntime(paramOutputStream);
              if ((paramOutputStream == null) || (!(paramOutputStream instanceof QQAppInterface)))
              {
                QLog.e("VasExtensionDownloader", 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
                return null;
              }
            }
            catch (Throwable paramOutputStream)
            {
              for (;;)
              {
                QLog.d("VasExtensionDownloader", 2, "exception:" + paramOutputStream.getMessage());
                paramOutputStream = null;
              }
              paramOutputStream = (ajkz)paramOutputStream.getManager(131);
            }
            if (paramOutputStream == null) {
              break;
            }
            paramOutputStream = paramOutputStream.a();
            if (QLog.isColorLevel()) {
              QLog.d("VasExtensionDownloader", 2, "downloadImage redpacket send img filename = " + paramOutputStream);
            }
            if (TextUtils.isEmpty(paramOutputStream)) {
              break;
            }
            return new File(paramOutputStream);
          }
          if (("COMMERCIAL_DRAINAGE".equals(str)) || ("IP_SITE_IMAGE".equals(str)))
          {
            if ((paramDownloadParams.url == null) || (TextUtils.isEmpty(paramDownloadParams.url.getFile()))) {
              break;
            }
            paramOutputStream = paramOutputStream.split("_");
            paramURLDrawableHandler = paramOutputStream[1];
            paramOutputStream = paramOutputStream[0].substring(1);
            if ("COMMERCIAL_DRAINAGE".equals(str)) {}
            for (int i = 22;; i = 23)
            {
              paramDownloadParams = anam.a(i, paramURLDrawableHandler, MD5.toMD5(paramDownloadParams.url.getFile()));
              if (QLog.isColorLevel()) {
                QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
              }
              paramDownloadParams = new File(paramDownloadParams);
              if (!paramDownloadParams.exists()) {
                break;
              }
              return paramDownloadParams;
            }
            paramOutputStream = new batm(paramOutputStream, paramDownloadParams);
            paramOutputStream.e = anfj.b;
            if (bato.a(paramOutputStream, null) != 0) {
              break;
            }
            return paramDownloadParams;
          }
          if (("COMIC_IP_SITE_ROUND_IMAGE".equals(str)) || ("COMIC_IPSITE_GAME_IMAGE".equals(str))) {
            return a(".comicIPSite", paramDownloadParams);
          }
          if ("FONT_BUBBLE".equals(str)) {
            return a(".fontbubble", paramDownloadParams);
          }
          paramOutputStream = null;
          paramURLDrawableHandler = null;
          break label256;
          label1412:
          break;
          label1414:
          localObject1 = null;
        }
        label1422:
        localObject1 = null;
      }
    }
  }
  
  public void a(ankl paramankl)
  {
    if (paramankl == null) {
      return;
    }
    ThreadManager.post(new VasExtensionDownloader.1(this, paramankl), 5, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +32 -> 50
    //   21: ldc 181
    //   23: iconst_2
    //   24: new 152	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 413
    //   34: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   41: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   54: invokevirtual 231	java/net/URL:getHost	()Ljava/lang/String;
    //   57: astore_3
    //   58: ldc_w 321
    //   61: aload_3
    //   62: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +160 -> 225
    //   68: aload_2
    //   69: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   72: invokevirtual 123	java/net/URL:getFile	()Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 131
    //   81: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifeq +13 -> 97
    //   87: aload_2
    //   88: iconst_1
    //   89: aload_2
    //   90: invokevirtual 140	java/lang/String:length	()I
    //   93: invokevirtual 144	java/lang/String:substring	(II)Ljava/lang/String;
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +14 -> 115
    //   104: ldc 181
    //   106: iconst_1
    //   107: ldc_w 418
    //   110: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_1
    //   116: invokestatic 423	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   119: invokevirtual 426	java/lang/Integer:intValue	()I
    //   122: istore 4
    //   124: invokestatic 430	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   127: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   130: iload 4
    //   132: invokestatic 436	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   135: astore_2
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: ldc 181
    //   141: iconst_1
    //   142: new 152	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 438
    //   152: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_2
    //   168: ldc 181
    //   170: iconst_1
    //   171: new 152	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 440
    //   181: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_2
    //   197: ldc 181
    //   199: iconst_1
    //   200: new 152	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 442
    //   210: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: ldc_w 323
    //   228: aload_3
    //   229: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +227 -> 459
    //   235: aload_2
    //   236: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   239: invokevirtual 123	java/net/URL:getFile	()Ljava/lang/String;
    //   242: astore_3
    //   243: aload_3
    //   244: invokestatic 444	anam:b	(Ljava/lang/String;)Z
    //   247: ifeq +52 -> 299
    //   250: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +29 -> 282
    //   256: ldc 181
    //   258: iconst_2
    //   259: new 152	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 446
    //   269: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_3
    //   273: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: new 155	java/io/File
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: iconst_1
    //   291: iconst_1
    //   292: iconst_0
    //   293: iconst_0
    //   294: fconst_0
    //   295: invokestatic 452	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   298: areturn
    //   299: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +29 -> 331
    //   305: ldc 181
    //   307: iconst_2
    //   308: new 152	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 454
    //   318: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_3
    //   332: invokestatic 457	anam:b	(Ljava/lang/String;)[B
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +92 -> 429
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_1
    //   343: iconst_0
    //   344: aload_1
    //   345: arraylength
    //   346: aconst_null
    //   347: invokestatic 461	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   350: astore_1
    //   351: aload_1
    //   352: astore_2
    //   353: aload_2
    //   354: astore_1
    //   355: aload_2
    //   356: ifnonnull -343 -> 13
    //   359: ldc 181
    //   361: iconst_2
    //   362: new 152	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 463
    //   372: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aconst_null
    //   386: areturn
    //   387: astore_1
    //   388: ldc_w 465
    //   391: iconst_1
    //   392: new 152	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 467
    //   402: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_3
    //   406: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto -62 -> 353
    //   418: astore_1
    //   419: ldc 181
    //   421: iconst_1
    //   422: ldc_w 469
    //   425: aload_1
    //   426: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aconst_null
    //   430: areturn
    //   431: astore_1
    //   432: ldc 181
    //   434: iconst_1
    //   435: ldc_w 469
    //   438: aload_1
    //   439: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: ldc 181
    //   448: iconst_1
    //   449: ldc_w 469
    //   452: aload_1
    //   453: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: goto -27 -> 429
    //   459: ldc_w 325
    //   462: aload_3
    //   463: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +146 -> 612
    //   469: aload_1
    //   470: ifnonnull +14 -> 484
    //   473: ldc 181
    //   475: iconst_1
    //   476: ldc_w 474
    //   479: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aconst_null
    //   483: areturn
    //   484: aload_1
    //   485: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   488: astore_1
    //   489: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +29 -> 521
    //   495: ldc 181
    //   497: iconst_2
    //   498: new 152	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 479
    //   508: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: new 481	java/io/FileInputStream
    //   524: dup
    //   525: aload_1
    //   526: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   529: astore_2
    //   530: new 484	java/io/BufferedInputStream
    //   533: dup
    //   534: aload_2
    //   535: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   538: invokestatic 493	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   541: astore_1
    //   542: aload_2
    //   543: invokevirtual 496	java/io/FileInputStream:close	()V
    //   546: aload_1
    //   547: areturn
    //   548: astore_2
    //   549: ldc 181
    //   551: iconst_1
    //   552: new 152	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 498
    //   562: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_2
    //   566: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aload_1
    //   579: areturn
    //   580: astore_1
    //   581: ldc 181
    //   583: iconst_1
    //   584: new 152	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 501
    //   594: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aconst_null
    //   611: areturn
    //   612: ldc_w 274
    //   615: aload_3
    //   616: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   619: ifne +23 -> 642
    //   622: ldc_w 276
    //   625: aload_3
    //   626: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   629: ifne +13 -> 642
    //   632: ldc_w 278
    //   635: aload_3
    //   636: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   639: ifeq +526 -> 1165
    //   642: aload_2
    //   643: getfield 504	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   646: instanceof 506
    //   649: ifne +34 -> 683
    //   652: ldc 181
    //   654: iconst_1
    //   655: new 152	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 508
    //   665: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_2
    //   669: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   672: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aconst_null
    //   682: areturn
    //   683: aload_2
    //   684: getfield 504	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   687: checkcast 506	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   690: astore_1
    //   691: aload_1
    //   692: ifnull +442 -> 1134
    //   695: aload_1
    //   696: getfield 511	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   699: astore 6
    //   701: new 155	java/io/File
    //   704: dup
    //   705: aload 6
    //   707: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   710: astore 7
    //   712: aload 7
    //   714: invokestatic 517	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   717: ifeq +87 -> 804
    //   720: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +30 -> 753
    //   726: ldc 181
    //   728: iconst_2
    //   729: new 152	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 446
    //   739: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 6
    //   744: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: new 519	axwh
    //   756: dup
    //   757: aload_0
    //   758: aload 7
    //   760: iconst_1
    //   761: aload_2
    //   762: getfield 522	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   765: invokespecial 525	axwh:<init>	(Laxwg;Ljava/io/File;ZF)V
    //   768: astore_1
    //   769: aload_1
    //   770: areturn
    //   771: astore_1
    //   772: ldc 181
    //   774: iconst_2
    //   775: new 152	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 527
    //   785: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_2
    //   789: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   792: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: aload_1
    //   799: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   802: aconst_null
    //   803: areturn
    //   804: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq +30 -> 837
    //   810: ldc 181
    //   812: iconst_2
    //   813: new 152	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 529
    //   823: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 6
    //   828: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: new 531	android/graphics/BitmapFactory$Options
    //   840: dup
    //   841: invokespecial 532	android/graphics/BitmapFactory$Options:<init>	()V
    //   844: astore 7
    //   846: aload 7
    //   848: iconst_1
    //   849: putfield 536	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   852: aload_1
    //   853: getfield 511	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   856: aload 7
    //   858: invokestatic 539	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   861: pop
    //   862: aload 7
    //   864: aload 7
    //   866: aload_1
    //   867: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   870: aload_1
    //   871: getfield 545	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   874: invokestatic 550	bacm:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   877: putfield 553	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   880: aload 7
    //   882: iconst_0
    //   883: putfield 536	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   886: new 481	java/io/FileInputStream
    //   889: dup
    //   890: aload 6
    //   892: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   895: astore 8
    //   897: new 484	java/io/BufferedInputStream
    //   900: dup
    //   901: aload 8
    //   903: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   906: aconst_null
    //   907: aload 7
    //   909: invokestatic 556	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   912: astore 6
    //   914: aload 8
    //   916: invokevirtual 496	java/io/FileInputStream:close	()V
    //   919: aload 6
    //   921: ifnonnull +34 -> 955
    //   924: ldc 181
    //   926: iconst_2
    //   927: new 152	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 558
    //   937: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload_2
    //   941: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   944: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   953: aconst_null
    //   954: areturn
    //   955: ldc_w 278
    //   958: aload_3
    //   959: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   962: ifeq +18 -> 980
    //   965: aload_0
    //   966: aload 6
    //   968: aload_1
    //   969: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   972: aload_1
    //   973: getfield 545	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   976: invokevirtual 560	axwg:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   979: areturn
    //   980: aload 6
    //   982: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   985: istore 4
    //   987: aload 6
    //   989: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   992: istore 5
    //   994: new 67	android/graphics/Rect
    //   997: dup
    //   998: invokespecial 561	android/graphics/Rect:<init>	()V
    //   1001: astore_3
    //   1002: new 72	android/graphics/RectF
    //   1005: dup
    //   1006: fconst_0
    //   1007: fconst_0
    //   1008: aload_1
    //   1009: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1012: i2f
    //   1013: aload_1
    //   1014: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1017: i2f
    //   1018: invokespecial 564	android/graphics/RectF:<init>	(FFFF)V
    //   1021: astore 7
    //   1023: iload 4
    //   1025: iload 5
    //   1027: if_icmple +79 -> 1106
    //   1030: iload 4
    //   1032: iload 5
    //   1034: isub
    //   1035: iconst_2
    //   1036: idiv
    //   1037: istore 4
    //   1039: aload_3
    //   1040: iload 4
    //   1042: iconst_0
    //   1043: iload 4
    //   1045: iload 5
    //   1047: iadd
    //   1048: iload 5
    //   1050: iconst_0
    //   1051: iadd
    //   1052: invokevirtual 567	android/graphics/Rect:set	(IIII)V
    //   1055: aload_1
    //   1056: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1059: aload_1
    //   1060: getfield 542	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1063: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1066: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1069: astore_1
    //   1070: aload_1
    //   1071: ifnull +695 -> 1766
    //   1074: new 59	android/graphics/Canvas
    //   1077: dup
    //   1078: aload_1
    //   1079: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1082: aload 6
    //   1084: aload_3
    //   1085: aload 7
    //   1087: new 64	android/graphics/Paint
    //   1090: dup
    //   1091: bipush 6
    //   1093: invokespecial 569	android/graphics/Paint:<init>	(I)V
    //   1096: invokevirtual 572	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   1099: aload 6
    //   1101: invokevirtual 575	android/graphics/Bitmap:recycle	()V
    //   1104: aload_1
    //   1105: areturn
    //   1106: iload 5
    //   1108: iload 4
    //   1110: isub
    //   1111: iconst_2
    //   1112: idiv
    //   1113: istore 5
    //   1115: aload_3
    //   1116: iconst_0
    //   1117: iload 5
    //   1119: iconst_0
    //   1120: iload 4
    //   1122: iadd
    //   1123: iload 4
    //   1125: iload 5
    //   1127: iadd
    //   1128: invokevirtual 567	android/graphics/Rect:set	(IIII)V
    //   1131: goto -76 -> 1055
    //   1134: ldc 181
    //   1136: iconst_1
    //   1137: new 152	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1144: ldc_w 577
    //   1147: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_2
    //   1151: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1154: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1163: aconst_null
    //   1164: areturn
    //   1165: ldc_w 366
    //   1168: aload_3
    //   1169: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1172: ifeq +316 -> 1488
    //   1175: aload_1
    //   1176: ifnonnull +14 -> 1190
    //   1179: ldc 181
    //   1181: iconst_1
    //   1182: ldc_w 579
    //   1185: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: aconst_null
    //   1189: areturn
    //   1190: aload_1
    //   1191: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1194: astore_1
    //   1195: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1198: ifeq +29 -> 1227
    //   1201: ldc 181
    //   1203: iconst_2
    //   1204: new 152	java/lang/StringBuilder
    //   1207: dup
    //   1208: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1211: ldc_w 581
    //   1214: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload_1
    //   1218: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: new 481	java/io/FileInputStream
    //   1230: dup
    //   1231: aload_1
    //   1232: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1235: astore_2
    //   1236: new 484	java/io/BufferedInputStream
    //   1239: dup
    //   1240: aload_2
    //   1241: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1244: invokestatic 493	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1247: astore_1
    //   1248: aload_2
    //   1249: invokevirtual 496	java/io/FileInputStream:close	()V
    //   1252: aload_1
    //   1253: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1256: aload_1
    //   1257: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1260: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1263: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1266: astore_2
    //   1267: new 59	android/graphics/Canvas
    //   1270: dup
    //   1271: aload_2
    //   1272: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1275: astore_3
    //   1276: new 64	android/graphics/Paint
    //   1279: dup
    //   1280: invokespecial 65	android/graphics/Paint:<init>	()V
    //   1283: astore 6
    //   1285: new 67	android/graphics/Rect
    //   1288: dup
    //   1289: iconst_0
    //   1290: iconst_0
    //   1291: aload_1
    //   1292: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1295: aload_1
    //   1296: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1299: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1302: astore 7
    //   1304: new 72	android/graphics/RectF
    //   1307: dup
    //   1308: new 67	android/graphics/Rect
    //   1311: dup
    //   1312: iconst_0
    //   1313: iconst_0
    //   1314: aload_1
    //   1315: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1318: aload_1
    //   1319: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1322: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1325: invokespecial 75	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   1328: astore 8
    //   1330: aload 6
    //   1332: iconst_1
    //   1333: invokevirtual 79	android/graphics/Paint:setAntiAlias	(Z)V
    //   1336: aload_3
    //   1337: iconst_0
    //   1338: iconst_0
    //   1339: iconst_0
    //   1340: iconst_0
    //   1341: invokevirtual 82	android/graphics/Canvas:drawARGB	(IIII)V
    //   1344: aload 6
    //   1346: ldc_w 582
    //   1349: invokevirtual 87	android/graphics/Paint:setColor	(I)V
    //   1352: aload_3
    //   1353: aload 8
    //   1355: ldc_w 583
    //   1358: ldc_w 583
    //   1361: aload 6
    //   1363: invokevirtual 91	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   1366: aload 6
    //   1368: new 93	android/graphics/PorterDuffXfermode
    //   1371: dup
    //   1372: getstatic 99	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   1375: invokespecial 102	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   1378: invokevirtual 106	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   1381: pop
    //   1382: aload_3
    //   1383: aload_1
    //   1384: new 67	android/graphics/Rect
    //   1387: dup
    //   1388: iconst_0
    //   1389: iconst_0
    //   1390: aload_1
    //   1391: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1394: aload_1
    //   1395: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1398: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1401: aload 7
    //   1403: aload 6
    //   1405: invokevirtual 110	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1408: aload_2
    //   1409: areturn
    //   1410: astore_2
    //   1411: ldc 181
    //   1413: iconst_1
    //   1414: ldc_w 585
    //   1417: aload_2
    //   1418: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1421: aload_1
    //   1422: areturn
    //   1423: astore_1
    //   1424: ldc 181
    //   1426: iconst_1
    //   1427: new 152	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1434: ldc_w 587
    //   1437: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: aload_1
    //   1441: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1444: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1453: aconst_null
    //   1454: areturn
    //   1455: astore_2
    //   1456: ldc 181
    //   1458: iconst_1
    //   1459: new 152	java/lang/StringBuilder
    //   1462: dup
    //   1463: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1466: ldc_w 589
    //   1469: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: aload_2
    //   1473: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1476: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1485: goto -233 -> 1252
    //   1488: ldc_w 378
    //   1491: aload_3
    //   1492: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1495: ifne +13 -> 1508
    //   1498: ldc_w 380
    //   1501: aload_3
    //   1502: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1505: ifeq +180 -> 1685
    //   1508: aload_1
    //   1509: ifnonnull +14 -> 1523
    //   1512: ldc 181
    //   1514: iconst_1
    //   1515: ldc_w 591
    //   1518: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1521: aconst_null
    //   1522: areturn
    //   1523: aload_1
    //   1524: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1527: astore_1
    //   1528: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +29 -> 1560
    //   1534: ldc 181
    //   1536: iconst_2
    //   1537: new 152	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1544: ldc_w 593
    //   1547: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: aload_1
    //   1551: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1560: new 481	java/io/FileInputStream
    //   1563: dup
    //   1564: aload_1
    //   1565: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1568: astore_1
    //   1569: new 484	java/io/BufferedInputStream
    //   1572: dup
    //   1573: aload_1
    //   1574: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1577: invokestatic 493	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1580: astore_2
    //   1581: aload_1
    //   1582: invokevirtual 496	java/io/FileInputStream:close	()V
    //   1585: ldc_w 378
    //   1588: aload_3
    //   1589: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1592: ifeq +74 -> 1666
    //   1595: aload_0
    //   1596: aload_2
    //   1597: invokespecial 595	axwg:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1600: areturn
    //   1601: astore_1
    //   1602: ldc 181
    //   1604: iconst_1
    //   1605: new 152	java/lang/StringBuilder
    //   1608: dup
    //   1609: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1612: ldc_w 597
    //   1615: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: aload_1
    //   1619: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1622: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1631: aconst_null
    //   1632: areturn
    //   1633: astore_1
    //   1634: ldc 181
    //   1636: iconst_1
    //   1637: new 152	java/lang/StringBuilder
    //   1640: dup
    //   1641: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1644: ldc_w 599
    //   1647: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: aload_1
    //   1651: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1654: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1663: goto -78 -> 1585
    //   1666: aload_2
    //   1667: astore_1
    //   1668: ldc_w 380
    //   1671: aload_3
    //   1672: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1675: ifeq -1662 -> 13
    //   1678: aload_0
    //   1679: aload_2
    //   1680: iconst_1
    //   1681: invokespecial 18	axwg:a	(Landroid/graphics/Bitmap;Z)Landroid/graphics/Bitmap;
    //   1684: areturn
    //   1685: ldc_w 386
    //   1688: aload_3
    //   1689: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1692: ifeq -890 -> 802
    //   1695: aload_1
    //   1696: invokestatic 517	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   1699: ifeq +19 -> 1718
    //   1702: aload_1
    //   1703: iconst_0
    //   1704: iconst_0
    //   1705: aload_2
    //   1706: getfield 602	com/tencent/image/DownloadParams:reqWidth	I
    //   1709: aload_2
    //   1710: getfield 605	com/tencent/image/DownloadParams:reqHeight	I
    //   1713: fconst_0
    //   1714: invokestatic 452	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   1717: areturn
    //   1718: new 531	android/graphics/BitmapFactory$Options
    //   1721: dup
    //   1722: invokespecial 532	android/graphics/BitmapFactory$Options:<init>	()V
    //   1725: astore_2
    //   1726: aload_2
    //   1727: aload_0
    //   1728: getfield 13	axwg:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1731: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1734: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1737: getfield 608	android/util/DisplayMetrics:densityDpi	I
    //   1740: putfield 611	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1743: aload_2
    //   1744: aload_2
    //   1745: getfield 611	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1748: sipush 320
    //   1751: invokestatic 617	java/lang/Math:max	(II)I
    //   1754: putfield 620	android/graphics/BitmapFactory$Options:inDensity	I
    //   1757: aload_1
    //   1758: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1761: aload_2
    //   1762: invokestatic 624	azvq:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1765: areturn
    //   1766: aload 6
    //   1768: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1769	0	this	axwg
    //   0	1769	1	paramFile	File
    //   0	1769	2	paramDownloadParams	DownloadParams
    //   0	1769	3	paramURLDrawableHandler	URLDrawableHandler
    //   122	1006	4	i	int
    //   992	136	5	j	int
    //   699	1068	6	localObject1	Object
    //   710	692	7	localObject2	Object
    //   895	459	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   115	136	138	java/lang/NumberFormatException
    //   115	136	167	android/content/res/Resources$NotFoundException
    //   115	136	196	java/lang/OutOfMemoryError
    //   342	351	387	java/lang/OutOfMemoryError
    //   235	282	418	java/io/FileNotFoundException
    //   282	299	418	java/io/FileNotFoundException
    //   299	331	418	java/io/FileNotFoundException
    //   331	336	418	java/io/FileNotFoundException
    //   342	351	418	java/io/FileNotFoundException
    //   359	385	418	java/io/FileNotFoundException
    //   388	415	418	java/io/FileNotFoundException
    //   235	282	431	java/io/IOException
    //   282	299	431	java/io/IOException
    //   299	331	431	java/io/IOException
    //   331	336	431	java/io/IOException
    //   342	351	431	java/io/IOException
    //   359	385	431	java/io/IOException
    //   388	415	431	java/io/IOException
    //   235	282	445	java/lang/Exception
    //   282	299	445	java/lang/Exception
    //   299	331	445	java/lang/Exception
    //   331	336	445	java/lang/Exception
    //   342	351	445	java/lang/Exception
    //   359	385	445	java/lang/Exception
    //   388	415	445	java/lang/Exception
    //   542	546	548	java/lang/Exception
    //   530	542	580	java/lang/Exception
    //   712	753	771	java/lang/Exception
    //   753	769	771	java/lang/Exception
    //   804	837	771	java/lang/Exception
    //   837	919	771	java/lang/Exception
    //   924	953	771	java/lang/Exception
    //   955	980	771	java/lang/Exception
    //   980	1023	771	java/lang/Exception
    //   1030	1055	771	java/lang/Exception
    //   1055	1070	771	java/lang/Exception
    //   1074	1104	771	java/lang/Exception
    //   1106	1131	771	java/lang/Exception
    //   1252	1408	1410	java/lang/Exception
    //   1236	1248	1423	java/lang/Exception
    //   1248	1252	1455	java/lang/Exception
    //   1569	1581	1601	java/lang/Exception
    //   1581	1585	1633	java/lang/Exception
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    try
    {
      paramURL = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramURL = (anfj)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramURL)).getManager(43);
      if (paramURL != null) {
        return paramURL.a;
      }
    }
    catch (Throwable paramURL)
    {
      for (;;)
      {
        paramURL = null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwg
 * JD-Core Version:    0.7.0.1
 */