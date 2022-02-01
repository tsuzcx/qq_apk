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

public class beyt
  extends beqz
{
  protected BaseApplicationImpl a;
  
  public beyt(BaseApplicationImpl paramBaseApplicationImpl)
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
        str1 = antf.ba + paramString + str1 + File.separator + str2;
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, paramString + " save local filePath: " + str1);
        }
        paramString = new File(str1);
        if (!paramString.exists()) {
          break;
        }
        return paramString;
      }
      paramDownloadParams = new bihu(paramDownloadParams, paramString);
      paramDownloadParams.e = askd.b;
      if (bihw.a(paramDownloadParams, null) == 0) {
        return paramString;
      }
    }
    return null;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (("FAVOROTE_PANEL_DYNAMIC".equals(paramString)) || ("FAVORITE_PANEL_THUMB".equals(paramString)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString))) {
      axfj.e(String.valueOf(paramInt), 6);
    }
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
      Bitmap.Config localConfig = paramBitmap.getConfig();
      Object localObject = localConfig;
      if (localConfig == null) {
        localObject = Bitmap.Config.ARGB_8888;
      }
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, localMatrix, null);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
      return localObject;
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
      label200:
      Object localObject2;
      if (bool1)
      {
        paramURLDrawableHandler = asfa.a(3, paramOutputStream);
        localObject2 = new File(paramURLDrawableHandler);
      }
      label261:
      int i;
      for (;;)
      {
        try
        {
          boolean bool2 = ((File)localObject2).exists();
          if (bool2)
          {
            return localObject2;
            paramURLDrawableHandler = asfa.a(4, paramOutputStream);
            break label200;
          }
          if (!bool1) {
            continue;
          }
          if (((Boolean)localObject1).booleanValue()) {
            continue;
          }
          paramOutputStream = asfa.b(3, paramOutputStream);
        }
        catch (OutOfMemoryError paramOutputStream)
        {
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
          break label1423;
        }
        if ((!"FAVORITE_PANEL_THUMB".equals(str)) && (!"BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(str)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(str))) {
          paramDownloadParams.url = new URL(paramURLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "downloadImage : " + paramURLDrawableHandler + " -> " + paramOutputStream);
        }
        localObject1 = new File(paramOutputStream);
        localObject2 = new bihu(paramURLDrawableHandler, (File)localObject1);
        ((bihu)localObject2).e = askd.b;
        i = bihw.a((bihu)localObject2, null);
        a(str, i);
        if (i != 0) {
          break;
        }
        if (((paramDownloadParams.mExtraInfo instanceof asqn)) && (("FAVORITE_PANEL_THUMB".equals(str)) || ("FAVORITE_PANEL_THUMB_NEW".equals(str)))) {
          a((asqn)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "download sucessful " + paramURLDrawableHandler + " to path " + paramOutputStream);
        }
        return localObject1;
        paramOutputStream = asfa.b(17, paramOutputStream);
        continue;
        if (!((Boolean)localObject1).booleanValue()) {
          paramOutputStream = asfa.b(4, paramOutputStream);
        } else {
          paramOutputStream = asfa.b(18, paramOutputStream);
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
        if ((paramDownloadParams.mExtraInfo instanceof asqn))
        {
          localObject1 = ((asqn)paramDownloadParams.mExtraInfo).f;
          paramURLDrawableHandler = (URLDrawableHandler)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramOutputStream, localObject1 }));
            paramURLDrawableHandler = (URLDrawableHandler)localObject1;
          }
        }
        for (;;)
        {
          break label261;
          if ((paramDownloadParams.mExtraInfo instanceof asmg))
          {
            localObject1 = ((asmg)paramDownloadParams.mExtraInfo).f;
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
        if (!(paramDownloadParams.mExtraInfo instanceof asqn)) {
          break label1433;
        }
        localObject2 = ((asqn)paramDownloadParams.mExtraInfo).f;
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
        break label261;
        if ("BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(str))
        {
          if (!TextUtils.isEmpty(paramOutputStream))
          {
            paramURLDrawableHandler = new File(paramOutputStream);
            if (paramURLDrawableHandler.exists()) {
              return paramURLDrawableHandler;
            }
          }
          if (!(paramDownloadParams.mExtraInfo instanceof asmg)) {
            break label1425;
          }
          localObject2 = ((asmg)paramDownloadParams.mExtraInfo).f;
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
          break label261;
          if ("RESOURCE_IMG".equals(str)) {
            break;
          }
          if ("EMOTICON_DIY".equals(str)) {
            return new File(antf.ba);
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
              paramOutputStream = (aoan)paramOutputStream.getManager(131);
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
            for (i = 22;; i = 23)
            {
              paramDownloadParams = asfa.a(i, paramURLDrawableHandler, MD5.toMD5(paramDownloadParams.url.getFile()));
              if (QLog.isColorLevel()) {
                QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
              }
              paramDownloadParams = new File(paramDownloadParams);
              if (!paramDownloadParams.exists()) {
                break;
              }
              return paramDownloadParams;
            }
            paramOutputStream = new bihu(paramOutputStream, paramDownloadParams);
            paramOutputStream.e = askd.b;
            if (bihw.a(paramOutputStream, null) != 0) {
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
          break label261;
          label1423:
          break;
          label1425:
          localObject1 = null;
        }
        label1433:
        localObject1 = null;
      }
    }
  }
  
  public void a(asqn paramasqn)
  {
    if (paramasqn == null) {
      return;
    }
    ThreadManager.post(new VasExtensionDownloader.1(this, paramasqn), 5, null, false);
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
    //   31: ldc_w 433
    //   34: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   41: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   54: invokevirtual 260	java/net/URL:getHost	()Ljava/lang/String;
    //   57: astore 7
    //   59: ldc_w 342
    //   62: aload 7
    //   64: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +160 -> 227
    //   70: aload_2
    //   71: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   74: invokevirtual 123	java/net/URL:getFile	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: ldc 131
    //   83: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   86: ifeq +13 -> 99
    //   89: aload_2
    //   90: iconst_1
    //   91: aload_2
    //   92: invokevirtual 140	java/lang/String:length	()I
    //   95: invokevirtual 144	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +14 -> 117
    //   106: ldc 181
    //   108: iconst_1
    //   109: ldc_w 438
    //   112: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aconst_null
    //   116: areturn
    //   117: aload_1
    //   118: invokestatic 443	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   121: invokevirtual 446	java/lang/Integer:intValue	()I
    //   124: istore 4
    //   126: invokestatic 450	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   129: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   132: iload 4
    //   134: invokestatic 456	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   137: astore_2
    //   138: aload_2
    //   139: areturn
    //   140: astore_2
    //   141: ldc 181
    //   143: iconst_1
    //   144: new 152	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 458
    //   154: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_2
    //   170: ldc 181
    //   172: iconst_1
    //   173: new 152	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 460
    //   183: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_2
    //   199: ldc 181
    //   201: iconst_1
    //   202: new 152	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 462
    //   212: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aconst_null
    //   226: areturn
    //   227: ldc_w 344
    //   230: aload 7
    //   232: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifeq +227 -> 462
    //   238: aload_2
    //   239: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   242: invokevirtual 123	java/net/URL:getFile	()Ljava/lang/String;
    //   245: astore_3
    //   246: aload_3
    //   247: invokestatic 464	asfa:b	(Ljava/lang/String;)Z
    //   250: ifeq +52 -> 302
    //   253: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +29 -> 285
    //   259: ldc 181
    //   261: iconst_2
    //   262: new 152	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 466
    //   272: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_3
    //   276: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: new 155	java/io/File
    //   288: dup
    //   289: aload_3
    //   290: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   293: iconst_1
    //   294: iconst_1
    //   295: iconst_0
    //   296: iconst_0
    //   297: fconst_0
    //   298: invokestatic 472	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   301: areturn
    //   302: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +29 -> 334
    //   308: ldc 181
    //   310: iconst_2
    //   311: new 152	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 474
    //   321: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_3
    //   325: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_3
    //   335: invokestatic 477	asfa:b	(Ljava/lang/String;)[B
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull +92 -> 432
    //   343: aconst_null
    //   344: astore_2
    //   345: aload_1
    //   346: iconst_0
    //   347: aload_1
    //   348: arraylength
    //   349: aconst_null
    //   350: invokestatic 481	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   353: astore_1
    //   354: aload_1
    //   355: astore_2
    //   356: aload_2
    //   357: astore_1
    //   358: aload_2
    //   359: ifnonnull -346 -> 13
    //   362: ldc 181
    //   364: iconst_2
    //   365: new 152	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 483
    //   375: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: aconst_null
    //   389: areturn
    //   390: astore_1
    //   391: ldc_w 485
    //   394: iconst_1
    //   395: new 152	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 487
    //   405: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_3
    //   409: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -62 -> 356
    //   421: astore_1
    //   422: ldc 181
    //   424: iconst_1
    //   425: ldc_w 489
    //   428: aload_1
    //   429: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: aconst_null
    //   433: areturn
    //   434: astore_1
    //   435: ldc 181
    //   437: iconst_1
    //   438: ldc_w 489
    //   441: aload_1
    //   442: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: goto -13 -> 432
    //   448: astore_1
    //   449: ldc 181
    //   451: iconst_1
    //   452: ldc_w 489
    //   455: aload_1
    //   456: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -27 -> 432
    //   462: ldc_w 346
    //   465: aload 7
    //   467: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifeq +146 -> 616
    //   473: aload_1
    //   474: ifnonnull +14 -> 488
    //   477: ldc 181
    //   479: iconst_1
    //   480: ldc_w 494
    //   483: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aconst_null
    //   487: areturn
    //   488: aload_1
    //   489: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   492: astore_1
    //   493: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +29 -> 525
    //   499: ldc 181
    //   501: iconst_2
    //   502: new 152	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 499
    //   512: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_1
    //   516: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: new 501	java/io/FileInputStream
    //   528: dup
    //   529: aload_1
    //   530: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   533: astore_2
    //   534: new 504	java/io/BufferedInputStream
    //   537: dup
    //   538: aload_2
    //   539: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   542: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   545: astore_1
    //   546: aload_2
    //   547: invokevirtual 516	java/io/FileInputStream:close	()V
    //   550: aload_1
    //   551: areturn
    //   552: astore_2
    //   553: ldc 181
    //   555: iconst_1
    //   556: new 152	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 518
    //   566: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_2
    //   570: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_1
    //   583: areturn
    //   584: astore_1
    //   585: ldc 181
    //   587: iconst_1
    //   588: new 152	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 521
    //   598: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_1
    //   602: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   605: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aconst_null
    //   615: areturn
    //   616: ldc 221
    //   618: aload 7
    //   620: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   623: ifne +24 -> 647
    //   626: ldc_w 298
    //   629: aload 7
    //   631: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifne +13 -> 647
    //   637: ldc 223
    //   639: aload 7
    //   641: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +578 -> 1222
    //   647: aload_2
    //   648: getfield 524	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   651: instanceof 526
    //   654: ifne +34 -> 688
    //   657: ldc 181
    //   659: iconst_1
    //   660: new 152	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 528
    //   670: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_2
    //   674: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   677: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aconst_null
    //   687: areturn
    //   688: aload_2
    //   689: getfield 524	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   692: checkcast 526	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   695: astore 8
    //   697: aload 8
    //   699: ifnull +492 -> 1191
    //   702: aload 8
    //   704: getfield 531	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   707: astore_3
    //   708: new 155	java/io/File
    //   711: dup
    //   712: aload_3
    //   713: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   716: astore_1
    //   717: aload_1
    //   718: invokestatic 537	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   721: ifeq +85 -> 806
    //   724: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +29 -> 756
    //   730: ldc 181
    //   732: iconst_2
    //   733: new 152	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   740: ldc_w 466
    //   743: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload_3
    //   747: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: new 539	beyu
    //   759: dup
    //   760: aload_0
    //   761: aload_1
    //   762: iconst_1
    //   763: aload_2
    //   764: getfield 542	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   767: invokespecial 545	beyu:<init>	(Lbeyt;Ljava/io/File;ZF)V
    //   770: astore_1
    //   771: aload_1
    //   772: areturn
    //   773: astore_1
    //   774: ldc 181
    //   776: iconst_2
    //   777: new 152	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   784: ldc_w 547
    //   787: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload_2
    //   791: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   794: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   797: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: aload_1
    //   801: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   804: aconst_null
    //   805: areturn
    //   806: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   809: ifeq +29 -> 838
    //   812: ldc 181
    //   814: iconst_2
    //   815: new 152	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   822: ldc_w 549
    //   825: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_3
    //   829: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   838: new 551	android/graphics/BitmapFactory$Options
    //   841: dup
    //   842: invokespecial 552	android/graphics/BitmapFactory$Options:<init>	()V
    //   845: astore 6
    //   847: aload 6
    //   849: iconst_1
    //   850: putfield 556	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   853: aload 8
    //   855: getfield 531	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   858: aload 6
    //   860: invokestatic 559	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   863: pop
    //   864: aload 6
    //   866: aload 6
    //   868: aload 8
    //   870: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   873: aload 8
    //   875: getfield 565	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   878: invokestatic 570	bhmq:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   881: putfield 573	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   884: aload 6
    //   886: iconst_0
    //   887: putfield 556	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   890: new 501	java/io/FileInputStream
    //   893: dup
    //   894: aload_1
    //   895: invokespecial 576	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   898: astore_3
    //   899: aload_3
    //   900: astore_1
    //   901: new 504	java/io/BufferedInputStream
    //   904: dup
    //   905: aload_3
    //   906: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   909: aconst_null
    //   910: aload 6
    //   912: invokestatic 579	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   915: astore 6
    //   917: aload 6
    //   919: astore_1
    //   920: aload_3
    //   921: ifnull +10 -> 931
    //   924: aload_3
    //   925: invokevirtual 516	java/io/FileInputStream:close	()V
    //   928: aload 6
    //   930: astore_1
    //   931: aload_1
    //   932: ifnonnull +75 -> 1007
    //   935: ldc 181
    //   937: iconst_2
    //   938: new 152	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   945: ldc_w 581
    //   948: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload_2
    //   952: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   955: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   964: aconst_null
    //   965: areturn
    //   966: astore 6
    //   968: aconst_null
    //   969: astore_3
    //   970: aload_3
    //   971: astore_1
    //   972: ldc 181
    //   974: iconst_2
    //   975: aload 6
    //   977: iconst_0
    //   978: anewarray 333	java/lang/Object
    //   981: invokestatic 584	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   984: aload_3
    //   985: ifnull +855 -> 1840
    //   988: aload_3
    //   989: invokevirtual 516	java/io/FileInputStream:close	()V
    //   992: aconst_null
    //   993: astore_1
    //   994: goto -63 -> 931
    //   997: aload_1
    //   998: ifnull +7 -> 1005
    //   1001: aload_1
    //   1002: invokevirtual 516	java/io/FileInputStream:close	()V
    //   1005: aload_3
    //   1006: athrow
    //   1007: ldc 223
    //   1009: aload 7
    //   1011: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1014: ifeq +19 -> 1033
    //   1017: aload_0
    //   1018: aload_1
    //   1019: aload 8
    //   1021: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1024: aload 8
    //   1026: getfield 565	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   1029: invokevirtual 586	beyt:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   1032: areturn
    //   1033: aload_1
    //   1034: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1037: istore 4
    //   1039: aload_1
    //   1040: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1043: istore 5
    //   1045: new 67	android/graphics/Rect
    //   1048: dup
    //   1049: invokespecial 587	android/graphics/Rect:<init>	()V
    //   1052: astore_3
    //   1053: new 72	android/graphics/RectF
    //   1056: dup
    //   1057: fconst_0
    //   1058: fconst_0
    //   1059: aload 8
    //   1061: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1064: i2f
    //   1065: aload 8
    //   1067: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1070: i2f
    //   1071: invokespecial 590	android/graphics/RectF:<init>	(FFFF)V
    //   1074: astore 6
    //   1076: iload 4
    //   1078: iload 5
    //   1080: if_icmple +83 -> 1163
    //   1083: iload 4
    //   1085: iload 5
    //   1087: isub
    //   1088: iconst_2
    //   1089: idiv
    //   1090: istore 4
    //   1092: aload_3
    //   1093: iload 4
    //   1095: iconst_0
    //   1096: iload 4
    //   1098: iload 5
    //   1100: iadd
    //   1101: iload 5
    //   1103: iconst_0
    //   1104: iadd
    //   1105: invokevirtual 593	android/graphics/Rect:set	(IIII)V
    //   1108: aload 8
    //   1110: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1113: aload 8
    //   1115: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1118: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1121: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1124: astore 7
    //   1126: aload 7
    //   1128: ifnull +710 -> 1838
    //   1131: new 59	android/graphics/Canvas
    //   1134: dup
    //   1135: aload 7
    //   1137: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1140: aload_1
    //   1141: aload_3
    //   1142: aload 6
    //   1144: new 64	android/graphics/Paint
    //   1147: dup
    //   1148: bipush 6
    //   1150: invokespecial 595	android/graphics/Paint:<init>	(I)V
    //   1153: invokevirtual 598	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   1156: aload_1
    //   1157: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   1160: aload 7
    //   1162: areturn
    //   1163: iload 5
    //   1165: iload 4
    //   1167: isub
    //   1168: iconst_2
    //   1169: idiv
    //   1170: istore 5
    //   1172: aload_3
    //   1173: iconst_0
    //   1174: iload 5
    //   1176: iconst_0
    //   1177: iload 4
    //   1179: iadd
    //   1180: iload 4
    //   1182: iload 5
    //   1184: iadd
    //   1185: invokevirtual 593	android/graphics/Rect:set	(IIII)V
    //   1188: goto -80 -> 1108
    //   1191: ldc 181
    //   1193: iconst_1
    //   1194: new 152	java/lang/StringBuilder
    //   1197: dup
    //   1198: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1201: ldc_w 600
    //   1204: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload_2
    //   1208: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1211: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1220: aconst_null
    //   1221: areturn
    //   1222: ldc_w 387
    //   1225: aload 7
    //   1227: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1230: ifeq +316 -> 1546
    //   1233: aload_1
    //   1234: ifnonnull +14 -> 1248
    //   1237: ldc 181
    //   1239: iconst_1
    //   1240: ldc_w 602
    //   1243: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1246: aconst_null
    //   1247: areturn
    //   1248: aload_1
    //   1249: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1252: astore_1
    //   1253: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1256: ifeq +29 -> 1285
    //   1259: ldc 181
    //   1261: iconst_2
    //   1262: new 152	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1269: ldc_w 604
    //   1272: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload_1
    //   1276: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1285: new 501	java/io/FileInputStream
    //   1288: dup
    //   1289: aload_1
    //   1290: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1293: astore_2
    //   1294: new 504	java/io/BufferedInputStream
    //   1297: dup
    //   1298: aload_2
    //   1299: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1302: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1305: astore_1
    //   1306: aload_2
    //   1307: invokevirtual 516	java/io/FileInputStream:close	()V
    //   1310: aload_1
    //   1311: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1314: aload_1
    //   1315: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1318: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1321: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1324: astore_2
    //   1325: new 59	android/graphics/Canvas
    //   1328: dup
    //   1329: aload_2
    //   1330: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1333: astore_3
    //   1334: new 64	android/graphics/Paint
    //   1337: dup
    //   1338: invokespecial 65	android/graphics/Paint:<init>	()V
    //   1341: astore 6
    //   1343: new 67	android/graphics/Rect
    //   1346: dup
    //   1347: iconst_0
    //   1348: iconst_0
    //   1349: aload_1
    //   1350: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1353: aload_1
    //   1354: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1357: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1360: astore 7
    //   1362: new 72	android/graphics/RectF
    //   1365: dup
    //   1366: new 67	android/graphics/Rect
    //   1369: dup
    //   1370: iconst_0
    //   1371: iconst_0
    //   1372: aload_1
    //   1373: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1376: aload_1
    //   1377: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1380: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1383: invokespecial 75	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   1386: astore 8
    //   1388: aload 6
    //   1390: iconst_1
    //   1391: invokevirtual 79	android/graphics/Paint:setAntiAlias	(Z)V
    //   1394: aload_3
    //   1395: iconst_0
    //   1396: iconst_0
    //   1397: iconst_0
    //   1398: iconst_0
    //   1399: invokevirtual 82	android/graphics/Canvas:drawARGB	(IIII)V
    //   1402: aload 6
    //   1404: ldc_w 605
    //   1407: invokevirtual 87	android/graphics/Paint:setColor	(I)V
    //   1410: aload_3
    //   1411: aload 8
    //   1413: ldc_w 606
    //   1416: ldc_w 606
    //   1419: aload 6
    //   1421: invokevirtual 91	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   1424: aload 6
    //   1426: new 93	android/graphics/PorterDuffXfermode
    //   1429: dup
    //   1430: getstatic 99	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   1433: invokespecial 102	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   1436: invokevirtual 106	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   1439: pop
    //   1440: aload_3
    //   1441: aload_1
    //   1442: new 67	android/graphics/Rect
    //   1445: dup
    //   1446: iconst_0
    //   1447: iconst_0
    //   1448: aload_1
    //   1449: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1452: aload_1
    //   1453: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1456: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1459: aload 7
    //   1461: aload 6
    //   1463: invokevirtual 110	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1466: aload_2
    //   1467: areturn
    //   1468: astore_2
    //   1469: ldc 181
    //   1471: iconst_1
    //   1472: ldc_w 608
    //   1475: aload_2
    //   1476: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1479: aload_1
    //   1480: areturn
    //   1481: astore_1
    //   1482: ldc 181
    //   1484: iconst_1
    //   1485: new 152	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1492: ldc_w 610
    //   1495: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: aload_1
    //   1499: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1502: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1508: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1511: aconst_null
    //   1512: areturn
    //   1513: astore_2
    //   1514: ldc 181
    //   1516: iconst_1
    //   1517: new 152	java/lang/StringBuilder
    //   1520: dup
    //   1521: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1524: ldc_w 612
    //   1527: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload_2
    //   1531: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1534: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1543: goto -233 -> 1310
    //   1546: ldc_w 398
    //   1549: aload 7
    //   1551: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1554: ifne +14 -> 1568
    //   1557: ldc_w 400
    //   1560: aload 7
    //   1562: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1565: ifeq +182 -> 1747
    //   1568: aload_1
    //   1569: ifnonnull +14 -> 1583
    //   1572: ldc 181
    //   1574: iconst_1
    //   1575: ldc_w 614
    //   1578: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1581: aconst_null
    //   1582: areturn
    //   1583: aload_1
    //   1584: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1587: astore_1
    //   1588: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1591: ifeq +29 -> 1620
    //   1594: ldc 181
    //   1596: iconst_2
    //   1597: new 152	java/lang/StringBuilder
    //   1600: dup
    //   1601: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1604: ldc_w 616
    //   1607: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: aload_1
    //   1611: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1617: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1620: new 501	java/io/FileInputStream
    //   1623: dup
    //   1624: aload_1
    //   1625: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1628: astore_1
    //   1629: new 504	java/io/BufferedInputStream
    //   1632: dup
    //   1633: aload_1
    //   1634: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1637: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1640: astore_2
    //   1641: aload_1
    //   1642: invokevirtual 516	java/io/FileInputStream:close	()V
    //   1645: ldc_w 398
    //   1648: aload 7
    //   1650: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1653: ifeq +74 -> 1727
    //   1656: aload_0
    //   1657: aload_2
    //   1658: invokespecial 618	beyt:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1661: areturn
    //   1662: astore_1
    //   1663: ldc 181
    //   1665: iconst_1
    //   1666: new 152	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1673: ldc_w 620
    //   1676: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: aload_1
    //   1680: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1683: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1692: aconst_null
    //   1693: areturn
    //   1694: astore_1
    //   1695: ldc 181
    //   1697: iconst_1
    //   1698: new 152	java/lang/StringBuilder
    //   1701: dup
    //   1702: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1705: ldc_w 622
    //   1708: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: aload_1
    //   1712: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1715: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1721: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1724: goto -79 -> 1645
    //   1727: aload_2
    //   1728: astore_1
    //   1729: ldc_w 400
    //   1732: aload 7
    //   1734: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1737: ifeq -1724 -> 13
    //   1740: aload_0
    //   1741: aload_2
    //   1742: iconst_1
    //   1743: invokespecial 18	beyt:a	(Landroid/graphics/Bitmap;Z)Landroid/graphics/Bitmap;
    //   1746: areturn
    //   1747: ldc_w 406
    //   1750: aload 7
    //   1752: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1755: ifeq -951 -> 804
    //   1758: aload_1
    //   1759: invokestatic 537	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   1762: ifeq +19 -> 1781
    //   1765: aload_1
    //   1766: iconst_0
    //   1767: iconst_0
    //   1768: aload_2
    //   1769: getfield 625	com/tencent/image/DownloadParams:reqWidth	I
    //   1772: aload_2
    //   1773: getfield 628	com/tencent/image/DownloadParams:reqHeight	I
    //   1776: fconst_0
    //   1777: invokestatic 472	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   1780: areturn
    //   1781: new 551	android/graphics/BitmapFactory$Options
    //   1784: dup
    //   1785: invokespecial 552	android/graphics/BitmapFactory$Options:<init>	()V
    //   1788: astore_2
    //   1789: aload_2
    //   1790: aload_0
    //   1791: getfield 13	beyt:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1794: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1797: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1800: getfield 631	android/util/DisplayMetrics:densityDpi	I
    //   1803: putfield 634	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1806: aload_2
    //   1807: aload_2
    //   1808: getfield 634	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1811: sipush 320
    //   1814: invokestatic 640	java/lang/Math:max	(II)I
    //   1817: putfield 643	android/graphics/BitmapFactory$Options:inDensity	I
    //   1820: aload_1
    //   1821: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1824: aload_2
    //   1825: invokestatic 647	bhgm:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1828: areturn
    //   1829: astore_3
    //   1830: goto -833 -> 997
    //   1833: astore 6
    //   1835: goto -865 -> 970
    //   1838: aload_1
    //   1839: areturn
    //   1840: aconst_null
    //   1841: astore_1
    //   1842: goto -911 -> 931
    //   1845: astore_3
    //   1846: aconst_null
    //   1847: astore_1
    //   1848: goto -851 -> 997
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1851	0	this	beyt
    //   0	1851	1	paramFile	File
    //   0	1851	2	paramDownloadParams	DownloadParams
    //   0	1851	3	paramURLDrawableHandler	URLDrawableHandler
    //   124	1061	4	i	int
    //   1043	142	5	j	int
    //   845	84	6	localObject1	Object
    //   966	10	6	localException1	java.lang.Exception
    //   1074	388	6	localObject2	Object
    //   1833	1	6	localException2	java.lang.Exception
    //   57	1694	7	localObject3	Object
    //   695	717	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   117	138	140	java/lang/NumberFormatException
    //   117	138	169	android/content/res/Resources$NotFoundException
    //   117	138	198	java/lang/OutOfMemoryError
    //   345	354	390	java/lang/OutOfMemoryError
    //   238	285	421	java/io/FileNotFoundException
    //   285	302	421	java/io/FileNotFoundException
    //   302	334	421	java/io/FileNotFoundException
    //   334	339	421	java/io/FileNotFoundException
    //   345	354	421	java/io/FileNotFoundException
    //   362	388	421	java/io/FileNotFoundException
    //   391	418	421	java/io/FileNotFoundException
    //   238	285	434	java/io/IOException
    //   285	302	434	java/io/IOException
    //   302	334	434	java/io/IOException
    //   334	339	434	java/io/IOException
    //   345	354	434	java/io/IOException
    //   362	388	434	java/io/IOException
    //   391	418	434	java/io/IOException
    //   238	285	448	java/lang/Exception
    //   285	302	448	java/lang/Exception
    //   302	334	448	java/lang/Exception
    //   334	339	448	java/lang/Exception
    //   345	354	448	java/lang/Exception
    //   362	388	448	java/lang/Exception
    //   391	418	448	java/lang/Exception
    //   546	550	552	java/lang/Exception
    //   534	546	584	java/lang/Exception
    //   717	756	773	java/lang/Exception
    //   756	771	773	java/lang/Exception
    //   806	838	773	java/lang/Exception
    //   838	890	773	java/lang/Exception
    //   924	928	773	java/lang/Exception
    //   935	964	773	java/lang/Exception
    //   988	992	773	java/lang/Exception
    //   1001	1005	773	java/lang/Exception
    //   1005	1007	773	java/lang/Exception
    //   1007	1033	773	java/lang/Exception
    //   1033	1076	773	java/lang/Exception
    //   1083	1108	773	java/lang/Exception
    //   1108	1126	773	java/lang/Exception
    //   1131	1160	773	java/lang/Exception
    //   1163	1188	773	java/lang/Exception
    //   890	899	966	java/lang/Exception
    //   1310	1466	1468	java/lang/Exception
    //   1294	1306	1481	java/lang/Exception
    //   1306	1310	1513	java/lang/Exception
    //   1629	1641	1662	java/lang/Exception
    //   1641	1645	1694	java/lang/Exception
    //   901	917	1829	finally
    //   972	984	1829	finally
    //   901	917	1833	java/lang/Exception
    //   890	899	1845	finally
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    try
    {
      paramURL = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramURL = (askd)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramURL)).getManager(43);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyt
 * JD-Core Version:    0.7.0.1
 */