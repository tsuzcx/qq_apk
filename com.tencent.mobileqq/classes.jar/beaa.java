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

public class beaa
  extends bdsh
{
  protected BaseApplicationImpl a;
  
  public beaa(BaseApplicationImpl paramBaseApplicationImpl)
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
        str1 = anhk.ba + paramString + str1 + File.separator + str2;
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, paramString + " save local filePath: " + str1);
        }
        paramString = new File(str1);
        if (!paramString.exists()) {
          break;
        }
        return paramString;
      }
      paramDownloadParams = new bhhf(paramDownloadParams, paramString);
      paramDownloadParams.e = arup.b;
      if (bhhh.a(paramDownloadParams, null) == 0) {
        return paramString;
      }
    }
    return null;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (("FAVOROTE_PANEL_DYNAMIC".equals(paramString)) || ("FAVORITE_PANEL_THUMB".equals(paramString)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString))) {
      awmr.e(String.valueOf(paramInt), 6);
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
        paramURLDrawableHandler = arpm.a(3, paramOutputStream);
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
            paramURLDrawableHandler = arpm.a(4, paramOutputStream);
            break label200;
          }
          if (!bool1) {
            continue;
          }
          if (((Boolean)localObject1).booleanValue()) {
            continue;
          }
          paramOutputStream = arpm.b(3, paramOutputStream);
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
        localObject2 = new bhhf(paramURLDrawableHandler, (File)localObject1);
        ((bhhf)localObject2).e = arup.b;
        i = bhhh.a((bhhf)localObject2, null);
        a(str, i);
        if (i != 0) {
          break;
        }
        if (((paramDownloadParams.mExtraInfo instanceof asaz)) && (("FAVORITE_PANEL_THUMB".equals(str)) || ("FAVORITE_PANEL_THUMB_NEW".equals(str)))) {
          a((asaz)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "download sucessful " + paramURLDrawableHandler + " to path " + paramOutputStream);
        }
        return localObject1;
        paramOutputStream = arpm.b(17, paramOutputStream);
        continue;
        if (!((Boolean)localObject1).booleanValue()) {
          paramOutputStream = arpm.b(4, paramOutputStream);
        } else {
          paramOutputStream = arpm.b(18, paramOutputStream);
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
        if ((paramDownloadParams.mExtraInfo instanceof asaz))
        {
          localObject1 = ((asaz)paramDownloadParams.mExtraInfo).f;
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
          if ((paramDownloadParams.mExtraInfo instanceof arws))
          {
            localObject1 = ((arws)paramDownloadParams.mExtraInfo).f;
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
        if (!(paramDownloadParams.mExtraInfo instanceof asaz)) {
          break label1433;
        }
        localObject2 = ((asaz)paramDownloadParams.mExtraInfo).f;
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
          if (!(paramDownloadParams.mExtraInfo instanceof arws)) {
            break label1425;
          }
          localObject2 = ((arws)paramDownloadParams.mExtraInfo).f;
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
            return new File(anhk.ba);
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
              paramOutputStream = (anom)paramOutputStream.getManager(131);
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
              paramDownloadParams = arpm.a(i, paramURLDrawableHandler, MD5.toMD5(paramDownloadParams.url.getFile()));
              if (QLog.isColorLevel()) {
                QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
              }
              paramDownloadParams = new File(paramDownloadParams);
              if (!paramDownloadParams.exists()) {
                break;
              }
              return paramDownloadParams;
            }
            paramOutputStream = new bhhf(paramOutputStream, paramDownloadParams);
            paramOutputStream.e = arup.b;
            if (bhhh.a(paramOutputStream, null) != 0) {
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
  
  public void a(asaz paramasaz)
  {
    if (paramasaz == null) {
      return;
    }
    ThreadManager.post(new VasExtensionDownloader.1(this, paramasaz), 5, null, false);
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
    //   57: astore_3
    //   58: ldc_w 342
    //   61: aload_3
    //   62: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   107: ldc_w 438
    //   110: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_1
    //   116: invokestatic 443	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   119: invokevirtual 446	java/lang/Integer:intValue	()I
    //   122: istore 4
    //   124: invokestatic 450	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   127: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   130: iload 4
    //   132: invokestatic 456	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   135: astore_2
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: ldc 181
    //   141: iconst_1
    //   142: new 152	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 458
    //   152: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_2
    //   168: ldc 181
    //   170: iconst_1
    //   171: new 152	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 460
    //   181: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_2
    //   197: ldc 181
    //   199: iconst_1
    //   200: new 152	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 462
    //   210: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: ldc_w 344
    //   228: aload_3
    //   229: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +227 -> 459
    //   235: aload_2
    //   236: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   239: invokevirtual 123	java/net/URL:getFile	()Ljava/lang/String;
    //   242: astore_3
    //   243: aload_3
    //   244: invokestatic 464	arpm:b	(Ljava/lang/String;)Z
    //   247: ifeq +52 -> 299
    //   250: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +29 -> 282
    //   256: ldc 181
    //   258: iconst_2
    //   259: new 152	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 466
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
    //   295: invokestatic 472	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   298: areturn
    //   299: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +29 -> 331
    //   305: ldc 181
    //   307: iconst_2
    //   308: new 152	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 474
    //   318: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_3
    //   332: invokestatic 477	arpm:b	(Ljava/lang/String;)[B
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
    //   347: invokestatic 481	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
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
    //   369: ldc_w 483
    //   372: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aconst_null
    //   386: areturn
    //   387: astore_1
    //   388: ldc_w 485
    //   391: iconst_1
    //   392: new 152	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 487
    //   402: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_3
    //   406: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto -62 -> 353
    //   418: astore_1
    //   419: ldc 181
    //   421: iconst_1
    //   422: ldc_w 489
    //   425: aload_1
    //   426: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aconst_null
    //   430: areturn
    //   431: astore_1
    //   432: ldc 181
    //   434: iconst_1
    //   435: ldc_w 489
    //   438: aload_1
    //   439: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: ldc 181
    //   448: iconst_1
    //   449: ldc_w 489
    //   452: aload_1
    //   453: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: goto -27 -> 429
    //   459: ldc_w 346
    //   462: aload_3
    //   463: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +146 -> 612
    //   469: aload_1
    //   470: ifnonnull +14 -> 484
    //   473: ldc 181
    //   475: iconst_1
    //   476: ldc_w 494
    //   479: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aconst_null
    //   483: areturn
    //   484: aload_1
    //   485: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   488: astore_1
    //   489: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +29 -> 521
    //   495: ldc 181
    //   497: iconst_2
    //   498: new 152	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 499
    //   508: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: new 501	java/io/FileInputStream
    //   524: dup
    //   525: aload_1
    //   526: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   529: astore_2
    //   530: new 504	java/io/BufferedInputStream
    //   533: dup
    //   534: aload_2
    //   535: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   538: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   541: astore_1
    //   542: aload_2
    //   543: invokevirtual 516	java/io/FileInputStream:close	()V
    //   546: aload_1
    //   547: areturn
    //   548: astore_2
    //   549: ldc 181
    //   551: iconst_1
    //   552: new 152	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 518
    //   562: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_2
    //   566: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aload_1
    //   579: areturn
    //   580: astore_1
    //   581: ldc 181
    //   583: iconst_1
    //   584: new 152	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 521
    //   594: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aconst_null
    //   611: areturn
    //   612: ldc 221
    //   614: aload_3
    //   615: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifne +22 -> 640
    //   621: ldc_w 298
    //   624: aload_3
    //   625: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: ifne +12 -> 640
    //   631: ldc 223
    //   633: aload_3
    //   634: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   637: ifeq +525 -> 1162
    //   640: aload_2
    //   641: getfield 524	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   644: instanceof 526
    //   647: ifne +34 -> 681
    //   650: ldc 181
    //   652: iconst_1
    //   653: new 152	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 528
    //   663: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_2
    //   667: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   670: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: aconst_null
    //   680: areturn
    //   681: aload_2
    //   682: getfield 524	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   685: checkcast 526	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   688: astore_1
    //   689: aload_1
    //   690: ifnull +441 -> 1131
    //   693: aload_1
    //   694: getfield 531	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   697: astore 6
    //   699: new 155	java/io/File
    //   702: dup
    //   703: aload 6
    //   705: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   708: astore 7
    //   710: aload 7
    //   712: invokestatic 537	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   715: ifeq +87 -> 802
    //   718: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +30 -> 751
    //   724: ldc 181
    //   726: iconst_2
    //   727: new 152	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 466
    //   737: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 6
    //   742: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: new 539	beab
    //   754: dup
    //   755: aload_0
    //   756: aload 7
    //   758: iconst_1
    //   759: aload_2
    //   760: getfield 542	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   763: invokespecial 545	beab:<init>	(Lbeaa;Ljava/io/File;ZF)V
    //   766: astore_1
    //   767: aload_1
    //   768: areturn
    //   769: astore_1
    //   770: ldc 181
    //   772: iconst_2
    //   773: new 152	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   780: ldc_w 547
    //   783: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload_2
    //   787: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   790: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   793: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: aload_1
    //   797: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: aconst_null
    //   801: areturn
    //   802: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   805: ifeq +30 -> 835
    //   808: ldc 181
    //   810: iconst_2
    //   811: new 152	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 549
    //   821: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload 6
    //   826: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: new 551	android/graphics/BitmapFactory$Options
    //   838: dup
    //   839: invokespecial 552	android/graphics/BitmapFactory$Options:<init>	()V
    //   842: astore 7
    //   844: aload 7
    //   846: iconst_1
    //   847: putfield 556	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   850: aload_1
    //   851: getfield 531	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   854: aload 7
    //   856: invokestatic 559	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   859: pop
    //   860: aload 7
    //   862: aload 7
    //   864: aload_1
    //   865: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   868: aload_1
    //   869: getfield 565	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   872: invokestatic 570	bgmo:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   875: putfield 573	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   878: aload 7
    //   880: iconst_0
    //   881: putfield 556	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   884: new 501	java/io/FileInputStream
    //   887: dup
    //   888: aload 6
    //   890: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   893: astore 8
    //   895: new 504	java/io/BufferedInputStream
    //   898: dup
    //   899: aload 8
    //   901: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   904: aconst_null
    //   905: aload 7
    //   907: invokestatic 576	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   910: astore 6
    //   912: aload 8
    //   914: invokevirtual 516	java/io/FileInputStream:close	()V
    //   917: aload 6
    //   919: ifnonnull +34 -> 953
    //   922: ldc 181
    //   924: iconst_2
    //   925: new 152	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 578
    //   935: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_2
    //   939: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   942: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   951: aconst_null
    //   952: areturn
    //   953: ldc 223
    //   955: aload_3
    //   956: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   959: ifeq +18 -> 977
    //   962: aload_0
    //   963: aload 6
    //   965: aload_1
    //   966: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   969: aload_1
    //   970: getfield 565	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   973: invokevirtual 580	beaa:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   976: areturn
    //   977: aload 6
    //   979: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   982: istore 4
    //   984: aload 6
    //   986: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   989: istore 5
    //   991: new 67	android/graphics/Rect
    //   994: dup
    //   995: invokespecial 581	android/graphics/Rect:<init>	()V
    //   998: astore_3
    //   999: new 72	android/graphics/RectF
    //   1002: dup
    //   1003: fconst_0
    //   1004: fconst_0
    //   1005: aload_1
    //   1006: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1009: i2f
    //   1010: aload_1
    //   1011: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1014: i2f
    //   1015: invokespecial 584	android/graphics/RectF:<init>	(FFFF)V
    //   1018: astore 7
    //   1020: iload 4
    //   1022: iload 5
    //   1024: if_icmple +79 -> 1103
    //   1027: iload 4
    //   1029: iload 5
    //   1031: isub
    //   1032: iconst_2
    //   1033: idiv
    //   1034: istore 4
    //   1036: aload_3
    //   1037: iload 4
    //   1039: iconst_0
    //   1040: iload 4
    //   1042: iload 5
    //   1044: iadd
    //   1045: iload 5
    //   1047: iconst_0
    //   1048: iadd
    //   1049: invokevirtual 587	android/graphics/Rect:set	(IIII)V
    //   1052: aload_1
    //   1053: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1056: aload_1
    //   1057: getfield 562	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1060: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1063: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1066: astore_1
    //   1067: aload_1
    //   1068: ifnull +695 -> 1763
    //   1071: new 59	android/graphics/Canvas
    //   1074: dup
    //   1075: aload_1
    //   1076: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1079: aload 6
    //   1081: aload_3
    //   1082: aload 7
    //   1084: new 64	android/graphics/Paint
    //   1087: dup
    //   1088: bipush 6
    //   1090: invokespecial 589	android/graphics/Paint:<init>	(I)V
    //   1093: invokevirtual 592	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   1096: aload 6
    //   1098: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   1101: aload_1
    //   1102: areturn
    //   1103: iload 5
    //   1105: iload 4
    //   1107: isub
    //   1108: iconst_2
    //   1109: idiv
    //   1110: istore 5
    //   1112: aload_3
    //   1113: iconst_0
    //   1114: iload 5
    //   1116: iconst_0
    //   1117: iload 4
    //   1119: iadd
    //   1120: iload 4
    //   1122: iload 5
    //   1124: iadd
    //   1125: invokevirtual 587	android/graphics/Rect:set	(IIII)V
    //   1128: goto -76 -> 1052
    //   1131: ldc 181
    //   1133: iconst_1
    //   1134: new 152	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1141: ldc_w 594
    //   1144: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: aload_2
    //   1148: getfield 117	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1151: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1160: aconst_null
    //   1161: areturn
    //   1162: ldc_w 387
    //   1165: aload_3
    //   1166: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1169: ifeq +316 -> 1485
    //   1172: aload_1
    //   1173: ifnonnull +14 -> 1187
    //   1176: ldc 181
    //   1178: iconst_1
    //   1179: ldc_w 596
    //   1182: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: aconst_null
    //   1186: areturn
    //   1187: aload_1
    //   1188: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1191: astore_1
    //   1192: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1195: ifeq +29 -> 1224
    //   1198: ldc 181
    //   1200: iconst_2
    //   1201: new 152	java/lang/StringBuilder
    //   1204: dup
    //   1205: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1208: ldc_w 598
    //   1211: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: aload_1
    //   1215: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1221: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1224: new 501	java/io/FileInputStream
    //   1227: dup
    //   1228: aload_1
    //   1229: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1232: astore_2
    //   1233: new 504	java/io/BufferedInputStream
    //   1236: dup
    //   1237: aload_2
    //   1238: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1241: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1244: astore_1
    //   1245: aload_2
    //   1246: invokevirtual 516	java/io/FileInputStream:close	()V
    //   1249: aload_1
    //   1250: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1253: aload_1
    //   1254: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1257: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1260: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1263: astore_2
    //   1264: new 59	android/graphics/Canvas
    //   1267: dup
    //   1268: aload_2
    //   1269: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1272: astore_3
    //   1273: new 64	android/graphics/Paint
    //   1276: dup
    //   1277: invokespecial 65	android/graphics/Paint:<init>	()V
    //   1280: astore 6
    //   1282: new 67	android/graphics/Rect
    //   1285: dup
    //   1286: iconst_0
    //   1287: iconst_0
    //   1288: aload_1
    //   1289: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1292: aload_1
    //   1293: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1296: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1299: astore 7
    //   1301: new 72	android/graphics/RectF
    //   1304: dup
    //   1305: new 67	android/graphics/Rect
    //   1308: dup
    //   1309: iconst_0
    //   1310: iconst_0
    //   1311: aload_1
    //   1312: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1315: aload_1
    //   1316: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1319: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1322: invokespecial 75	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   1325: astore 8
    //   1327: aload 6
    //   1329: iconst_1
    //   1330: invokevirtual 79	android/graphics/Paint:setAntiAlias	(Z)V
    //   1333: aload_3
    //   1334: iconst_0
    //   1335: iconst_0
    //   1336: iconst_0
    //   1337: iconst_0
    //   1338: invokevirtual 82	android/graphics/Canvas:drawARGB	(IIII)V
    //   1341: aload 6
    //   1343: ldc_w 599
    //   1346: invokevirtual 87	android/graphics/Paint:setColor	(I)V
    //   1349: aload_3
    //   1350: aload 8
    //   1352: ldc_w 600
    //   1355: ldc_w 600
    //   1358: aload 6
    //   1360: invokevirtual 91	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   1363: aload 6
    //   1365: new 93	android/graphics/PorterDuffXfermode
    //   1368: dup
    //   1369: getstatic 99	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   1372: invokespecial 102	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   1375: invokevirtual 106	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   1378: pop
    //   1379: aload_3
    //   1380: aload_1
    //   1381: new 67	android/graphics/Rect
    //   1384: dup
    //   1385: iconst_0
    //   1386: iconst_0
    //   1387: aload_1
    //   1388: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1391: aload_1
    //   1392: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1395: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1398: aload 7
    //   1400: aload 6
    //   1402: invokevirtual 110	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1405: aload_2
    //   1406: areturn
    //   1407: astore_2
    //   1408: ldc 181
    //   1410: iconst_1
    //   1411: ldc_w 602
    //   1414: aload_2
    //   1415: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1418: aload_1
    //   1419: areturn
    //   1420: astore_1
    //   1421: ldc 181
    //   1423: iconst_1
    //   1424: new 152	java/lang/StringBuilder
    //   1427: dup
    //   1428: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1431: ldc_w 604
    //   1434: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload_1
    //   1438: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1441: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1450: aconst_null
    //   1451: areturn
    //   1452: astore_2
    //   1453: ldc 181
    //   1455: iconst_1
    //   1456: new 152	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1463: ldc_w 606
    //   1466: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: aload_2
    //   1470: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1473: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1479: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1482: goto -233 -> 1249
    //   1485: ldc_w 398
    //   1488: aload_3
    //   1489: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1492: ifne +13 -> 1505
    //   1495: ldc_w 400
    //   1498: aload_3
    //   1499: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1502: ifeq +180 -> 1682
    //   1505: aload_1
    //   1506: ifnonnull +14 -> 1520
    //   1509: ldc 181
    //   1511: iconst_1
    //   1512: ldc_w 608
    //   1515: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1518: aconst_null
    //   1519: areturn
    //   1520: aload_1
    //   1521: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1524: astore_1
    //   1525: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1528: ifeq +29 -> 1557
    //   1531: ldc 181
    //   1533: iconst_2
    //   1534: new 152	java/lang/StringBuilder
    //   1537: dup
    //   1538: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1541: ldc_w 610
    //   1544: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload_1
    //   1548: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: new 501	java/io/FileInputStream
    //   1560: dup
    //   1561: aload_1
    //   1562: invokespecial 502	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1565: astore_1
    //   1566: new 504	java/io/BufferedInputStream
    //   1569: dup
    //   1570: aload_1
    //   1571: invokespecial 507	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1574: invokestatic 513	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1577: astore_2
    //   1578: aload_1
    //   1579: invokevirtual 516	java/io/FileInputStream:close	()V
    //   1582: ldc_w 398
    //   1585: aload_3
    //   1586: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1589: ifeq +74 -> 1663
    //   1592: aload_0
    //   1593: aload_2
    //   1594: invokespecial 612	beaa:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1597: areturn
    //   1598: astore_1
    //   1599: ldc 181
    //   1601: iconst_1
    //   1602: new 152	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1609: ldc_w 614
    //   1612: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: aload_1
    //   1616: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1619: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1625: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1628: aconst_null
    //   1629: areturn
    //   1630: astore_1
    //   1631: ldc 181
    //   1633: iconst_1
    //   1634: new 152	java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1641: ldc_w 616
    //   1644: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: aload_1
    //   1648: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1651: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1660: goto -78 -> 1582
    //   1663: aload_2
    //   1664: astore_1
    //   1665: ldc_w 400
    //   1668: aload_3
    //   1669: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1672: ifeq -1659 -> 13
    //   1675: aload_0
    //   1676: aload_2
    //   1677: iconst_1
    //   1678: invokespecial 18	beaa:a	(Landroid/graphics/Bitmap;Z)Landroid/graphics/Bitmap;
    //   1681: areturn
    //   1682: ldc_w 406
    //   1685: aload_3
    //   1686: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1689: ifeq -889 -> 800
    //   1692: aload_1
    //   1693: invokestatic 537	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   1696: ifeq +19 -> 1715
    //   1699: aload_1
    //   1700: iconst_0
    //   1701: iconst_0
    //   1702: aload_2
    //   1703: getfield 619	com/tencent/image/DownloadParams:reqWidth	I
    //   1706: aload_2
    //   1707: getfield 622	com/tencent/image/DownloadParams:reqHeight	I
    //   1710: fconst_0
    //   1711: invokestatic 472	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   1714: areturn
    //   1715: new 551	android/graphics/BitmapFactory$Options
    //   1718: dup
    //   1719: invokespecial 552	android/graphics/BitmapFactory$Options:<init>	()V
    //   1722: astore_2
    //   1723: aload_2
    //   1724: aload_0
    //   1725: getfield 13	beaa:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1728: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1731: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1734: getfield 625	android/util/DisplayMetrics:densityDpi	I
    //   1737: putfield 628	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1740: aload_2
    //   1741: aload_2
    //   1742: getfield 628	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   1745: sipush 320
    //   1748: invokestatic 634	java/lang/Math:max	(II)I
    //   1751: putfield 637	android/graphics/BitmapFactory$Options:inDensity	I
    //   1754: aload_1
    //   1755: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1758: aload_2
    //   1759: invokestatic 641	bggl:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1762: areturn
    //   1763: aload 6
    //   1765: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1766	0	this	beaa
    //   0	1766	1	paramFile	File
    //   0	1766	2	paramDownloadParams	DownloadParams
    //   0	1766	3	paramURLDrawableHandler	URLDrawableHandler
    //   122	1003	4	i	int
    //   989	136	5	j	int
    //   697	1067	6	localObject1	Object
    //   708	691	7	localObject2	Object
    //   893	458	8	localObject3	Object
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
    //   710	751	769	java/lang/Exception
    //   751	767	769	java/lang/Exception
    //   802	835	769	java/lang/Exception
    //   835	917	769	java/lang/Exception
    //   922	951	769	java/lang/Exception
    //   953	977	769	java/lang/Exception
    //   977	1020	769	java/lang/Exception
    //   1027	1052	769	java/lang/Exception
    //   1052	1067	769	java/lang/Exception
    //   1071	1101	769	java/lang/Exception
    //   1103	1128	769	java/lang/Exception
    //   1249	1405	1407	java/lang/Exception
    //   1233	1245	1420	java/lang/Exception
    //   1245	1249	1452	java/lang/Exception
    //   1566	1578	1598	java/lang/Exception
    //   1578	1582	1630	java/lang/Exception
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    try
    {
      paramURL = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramURL = (arup)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramURL)).getManager(43);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaa
 * JD-Core Version:    0.7.0.1
 */