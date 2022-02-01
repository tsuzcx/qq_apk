package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ExtractPCMFromFile;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

class ConvertRunnable
  implements HWEncodeListener, Runnable
{
  QQFilterRenderManager a = null;
  Video2Video b;
  long c;
  Context d;
  long e;
  long f;
  private String g;
  private SlideItemInfo h;
  private int i;
  private int j;
  private long k;
  private long l = 0L;
  private int m = -1;
  private WeakReference<ConvertRunnable.ConvertRunnableListener> n;
  private HWVideoRecorder o;
  private volatile boolean p = false;
  private int q;
  private boolean r;
  private long s = -1L;
  private String t;
  private String u;
  private String v;
  private Bitmap w;
  
  public ConvertRunnable(Context paramContext, long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, ConvertRunnable.ConvertRunnableListener paramConvertRunnableListener)
  {
    this.d = paramContext;
    this.h = paramSlideItemInfo;
    this.g = this.h.f;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramLong2;
    this.n = new WeakReference(paramConvertRunnableListener);
    this.r = paramBoolean;
    this.p = true;
    this.s = paramLong1;
    this.b = null;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      int i1 = GlUtil.createTexture(3553, paramBitmap);
      if (this.a == null) {
        this.a = new QQFilterRenderManager();
      }
      this.a.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.a.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.a.pushChain(new int[] { 170 }, null);
      List localList = this.a.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt1 = this.a.drawFrame(i1);
      if (i1 > 0) {
        GlUtil.deleteTexture(i1);
      }
      return paramInt1;
    }
    if (paramBitmap == null) {
      return 0;
    }
    return GlUtil.createTexture(3553, paramBitmap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = (ConvertRunnable.ConvertRunnableListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ResultInfo localResultInfo = new ResultInfo();
        localResultInfo.a = this.s;
        localResultInfo.b = paramInt;
        localResultInfo.d = paramString2;
        localResultInfo.c = paramString1;
        localResultInfo.e = paramMediaFormat;
        localResultInfo.f = this.u;
        localResultInfo.i = this.h.m;
        localResultInfo.j = this.h.n;
        ((ConvertRunnable.ConvertRunnableListener)localObject).a(localResultInfo);
      }
    }
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      float f1 = paramInt1;
      float f3 = f1 * 1.0F;
      float f2 = paramInt2;
      float f4 = f3 / f2;
      float f5 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
      paramInt1 = paramBitmap.getWidth();
      paramInt2 = paramBitmap.getHeight();
      localObject1 = new Matrix();
      ((Matrix)localObject1).postTranslate(paramInt1 * -0.5F, paramInt2 * -0.5F);
      Object localObject2;
      if (f5 > f4)
      {
        ((Matrix)localObject1).postScale(1.0F, f3 / paramBitmap.getWidth() * paramBitmap.getHeight() / f2);
        f3 = f1 / f5;
        localObject2 = new RectF(0.0F, (f2 - f3) * 0.5F, f1, (f3 + f2) * 0.5F);
        localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramInt1, paramInt2), (RectF)localObject2, null);
      }
      else
      {
        ((Matrix)localObject1).postScale(f2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / f1, 1.0F);
        localObject2 = new Rect(0, 0, paramInt1, paramInt2);
        f3 = f5 * f2;
        localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f1 - f3) * 0.5F, 0.0F, (f3 + f1) * 0.5F, f2), null);
      }
      ((Matrix)localObject1).postTranslate(f1 * 0.5F, f2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
    }
    if (paramBitmap == null) {
      return 0;
    }
    return GlUtil.createTexture(3553, paramBitmap);
  }
  
  private boolean c()
  {
    if ((!this.p) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("run exit:");
      localStringBuilder.append(this.s);
      localStringBuilder.append(" run:");
      localStringBuilder.append(this.p);
      QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
    }
    return this.p ^ true;
  }
  
  private boolean d()
  {
    HWVideoRecorder localHWVideoRecorder = this.o;
    if (localHWVideoRecorder != null)
    {
      int i1 = this.m;
      if (i1 > 0)
      {
        long l1 = this.l;
        if (l1 < this.k)
        {
          localHWVideoRecorder.a(3553, i1, null, null, l1);
          this.l += 42000000L;
          return true;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[runLocalVideo2Video]run begin, taskid:");
      ((StringBuilder)localObject1).append(this.s);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(this.p);
      QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
    }
    if (c())
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.g, null, null);
      return;
    }
    Object localObject1 = new File(Image2Video.b);
    boolean bool;
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, createDir:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
      }
    }
    Object localObject3 = new File(this.g).getName();
    localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = ((String)localObject3).replace(".", "_");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".mp4");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(Image2Video.b);
    ((StringBuilder)localObject3).append((String)localObject1);
    this.t = ((StringBuilder)localObject3).toString();
    FileUtils.k(this.t);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.t);
    ((StringBuilder)localObject1).append(".dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    long l1;
    long l2;
    if (FileUtils.i((String)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("before,getPCMFromFile[Have audio File]:  ");
        ((StringBuilder)localObject3).append(this.s);
        ((StringBuilder)localObject3).append(" audioPath: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" audioFileSize=");
        ((StringBuilder)localObject3).append(FileUtil.f((String)localObject1));
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new ExtractPCMFromFile();
      l1 = System.currentTimeMillis();
      ((ExtractPCMFromFile)localObject3).a(this.g, this.h);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run,getMetaDataFromFile:  ");
        ((StringBuilder)localObject3).append(this.s);
        ((StringBuilder)localObject3).append(" cost=");
        ((StringBuilder)localObject3).append(l2 - l1);
        ((StringBuilder)localObject3).append(" ms audioTrack: ");
        ((StringBuilder)localObject3).append(this.h.m);
        ((StringBuilder)localObject3).append(" mSampleRate: ");
        ((StringBuilder)localObject3).append(this.h.n);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject3 = new ExtractPCMFromFile();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.g;
      localLocalMediaInfo.mDuration = this.h.h;
      l1 = System.currentTimeMillis();
      bool = ((ExtractPCMFromFile)localObject3).a(localLocalMediaInfo, 0, (int)this.h.h, (String)localObject1, this.h);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run,getPCMFromFile:  ");
        ((StringBuilder)localObject3).append(this.s);
        ((StringBuilder)localObject3).append(" cost=");
        ((StringBuilder)localObject3).append(l2 - l1);
        ((StringBuilder)localObject3).append(" ms audioTrack: ");
        ((StringBuilder)localObject3).append(this.h.m);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
      if (this.h.m)
      {
        if ((!bool) || (!FileUtils.i((String)localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run,getPCMFromFile: failed ");
            ((StringBuilder)localObject3).append(this.s);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" success=");
            ((StringBuilder)localObject3).append(bool);
            QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
          }
          FileUtils.k((String)localObject1);
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.g, null, null);
        }
      }
      else
      {
        FileUtils.k((String)localObject1);
        ExtractPCMFromFile.a((String)localObject1, (int)this.h.h);
        if (!FileUtils.i((String)localObject1))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run[video convert],createSilentPCMFile: failed ");
            ((StringBuilder)localObject3).append(this.s);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
          }
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.g, null, null);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("After,getPCMFromFile: hasAudioTrack= ");
        ((StringBuilder)localObject3).append(this.h.m);
        ((StringBuilder)localObject3).append(" path=");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" success=");
        ((StringBuilder)localObject3).append(bool);
        ((StringBuilder)localObject3).append(" audioFileSize=");
        ((StringBuilder)localObject3).append(FileUtil.f((String)localObject1));
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
    }
    this.u = ((String)localObject1);
    if (c())
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.g, null, null);
      return;
    }
    this.h.k = this.t;
    try
    {
      this.b = new Video2Video();
      if (c())
      {
        StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.g, null, null);
        return;
      }
      l1 = System.currentTimeMillis();
      bool = this.b.a(this.h);
      l2 = System.currentTimeMillis();
      if (c())
      {
        StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.g, null, null);
        return;
      }
      long l3 = System.currentTimeMillis();
      long l4 = this.f;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l3 - l4);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actVideo2VideoTime", new String[] { ((StringBuilder)localObject1).toString() });
      if ((bool) && (FileUtil.d(this.t)))
      {
        l3 = FileUtil.f(this.t);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("runLocalVideo2Video, file exist, size:");
          ((StringBuilder)localObject1).append(l3);
          ((StringBuilder)localObject1).append(" file:");
          ((StringBuilder)localObject1).append(this.t);
          QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
        }
        this.q = 0;
        StoryReportor.a("actVideo2VideoResult", new String[] { "0" });
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("runLocalVideo2Video, [failed]file not exist:");
          ((StringBuilder)localObject1).append(this.s);
          ((StringBuilder)localObject1).append(" file:");
          ((StringBuilder)localObject1).append(this.t);
          QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
        }
        this.q = 7;
        StoryReportor.a("actVideo2VideoResult", new String[] { "7" });
        FileUtils.k(this.t);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, taskid:");
        ((StringBuilder)localObject1).append(this.s);
        ((StringBuilder)localObject1).append(" run:");
        ((StringBuilder)localObject1).append(this.p);
        ((StringBuilder)localObject1).append(" cost:");
        ((StringBuilder)localObject1).append(l2 - l1);
        ((StringBuilder)localObject1).append(" ms successVideo:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.p) {
        a(this.q, this.g, this.t, null);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +60 -> 63
    //   6: new 235	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: ldc_w 435
    //   20: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 7
    //   26: aload_0
    //   27: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   30: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 247
    //   38: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 7
    //   44: aload_0
    //   45: getfield 54	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:p	Z
    //   48: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 252
    //   54: iconst_2
    //   55: aload 7
    //   57: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: invokespecial 272	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:c	()Z
    //   67: ifeq +32 -> 99
    //   70: ldc_w 437
    //   73: iconst_1
    //   74: anewarray 276	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc_w 278
    //   82: aastore
    //   83: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   86: aload_0
    //   87: bipush 9
    //   89: aload_0
    //   90: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   98: return
    //   99: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   102: lstore_2
    //   103: new 439	java/io/FileInputStream
    //   106: dup
    //   107: aload_0
    //   108: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   111: invokespecial 440	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   114: astore 7
    //   116: new 442	java/io/BufferedInputStream
    //   119: dup
    //   120: aload 7
    //   122: ldc_w 443
    //   125: invokespecial 446	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   128: astore 8
    //   130: aload 8
    //   132: astore 9
    //   134: aload 7
    //   136: astore 11
    //   138: aload_0
    //   139: aload 8
    //   141: aconst_null
    //   142: aload_0
    //   143: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:i	I
    //   146: aload_0
    //   147: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:j	I
    //   150: invokestatic 451	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   153: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   156: aload 8
    //   158: invokevirtual 456	java/io/BufferedInputStream:close	()V
    //   161: aload 7
    //   163: invokevirtual 457	java/io/FileInputStream:close	()V
    //   166: goto +79 -> 245
    //   169: astore 10
    //   171: goto +40 -> 211
    //   174: astore 8
    //   176: aconst_null
    //   177: astore 9
    //   179: goto +368 -> 547
    //   182: astore 10
    //   184: aconst_null
    //   185: astore 8
    //   187: goto +24 -> 211
    //   190: astore 8
    //   192: aconst_null
    //   193: astore 9
    //   195: aload 9
    //   197: astore 7
    //   199: goto +348 -> 547
    //   202: astore 10
    //   204: aconst_null
    //   205: astore 8
    //   207: aload 8
    //   209: astore 7
    //   211: aload 8
    //   213: astore 9
    //   215: aload 7
    //   217: astore 11
    //   219: aload 10
    //   221: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   224: aload 8
    //   226: ifnull +11 -> 237
    //   229: aload 8
    //   231: invokevirtual 456	java/io/BufferedInputStream:close	()V
    //   234: goto +3 -> 237
    //   237: aload 7
    //   239: ifnull +6 -> 245
    //   242: goto -81 -> 161
    //   245: aload_0
    //   246: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   249: ifnonnull +22 -> 271
    //   252: aload_0
    //   253: aload_0
    //   254: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:i	I
    //   261: aload_0
    //   262: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:j	I
    //   265: invokestatic 463	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   268: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   271: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   274: lstore 4
    //   276: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +70 -> 349
    //   282: new 235	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   289: astore 7
    //   291: aload 7
    //   293: ldc_w 465
    //   296: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 7
    //   302: aload_0
    //   303: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   306: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: ldc_w 467
    //   315: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 7
    //   321: lload 4
    //   323: lload_2
    //   324: lsub
    //   325: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 7
    //   331: ldc_w 469
    //   334: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: ldc 252
    //   340: iconst_2
    //   341: aload 7
    //   343: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   353: ifnonnull +36 -> 389
    //   356: aload_0
    //   357: iconst_0
    //   358: putfield 54	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:p	Z
    //   361: ldc_w 437
    //   364: iconst_1
    //   365: anewarray 276	java/lang/String
    //   368: dup
    //   369: iconst_0
    //   370: ldc_w 471
    //   373: aastore
    //   374: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   377: aload_0
    //   378: iconst_5
    //   379: aload_0
    //   380: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   383: aconst_null
    //   384: aconst_null
    //   385: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   388: return
    //   389: aload_0
    //   390: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   393: invokestatic 476	com/tencent/mobileqq/utils/ImageUtil:h	(Ljava/lang/String;)I
    //   396: istore_1
    //   397: iload_1
    //   398: ifeq +88 -> 486
    //   401: iload_1
    //   402: bipush 90
    //   404: irem
    //   405: ifne +81 -> 486
    //   408: new 205	android/graphics/Matrix
    //   411: dup
    //   412: invokespecial 206	android/graphics/Matrix:<init>	()V
    //   415: astore 7
    //   417: aload 7
    //   419: iload_1
    //   420: i2f
    //   421: aload_0
    //   422: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   425: invokevirtual 130	android/graphics/Bitmap:getWidth	()I
    //   428: i2f
    //   429: fconst_2
    //   430: fdiv
    //   431: aload_0
    //   432: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   435: invokevirtual 133	android/graphics/Bitmap:getHeight	()I
    //   438: i2f
    //   439: fconst_2
    //   440: fdiv
    //   441: invokevirtual 480	android/graphics/Matrix:postRotate	(FFF)Z
    //   444: pop
    //   445: aload_0
    //   446: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   449: iconst_0
    //   450: iconst_0
    //   451: aload_0
    //   452: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   455: invokevirtual 130	android/graphics/Bitmap:getWidth	()I
    //   458: aload_0
    //   459: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   462: invokevirtual 133	android/graphics/Bitmap:getHeight	()I
    //   465: aload 7
    //   467: iconst_1
    //   468: invokestatic 483	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   471: astore 7
    //   473: aload_0
    //   474: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   477: invokevirtual 486	android/graphics/Bitmap:recycle	()V
    //   480: aload_0
    //   481: aload 7
    //   483: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   486: aload_0
    //   487: invokespecial 272	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:c	()Z
    //   490: ifeq +144 -> 634
    //   493: aload_0
    //   494: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   497: ifnull +15 -> 512
    //   500: aload_0
    //   501: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   504: invokevirtual 486	android/graphics/Bitmap:recycle	()V
    //   507: aload_0
    //   508: aconst_null
    //   509: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   512: ldc_w 437
    //   515: iconst_1
    //   516: anewarray 276	java/lang/String
    //   519: dup
    //   520: iconst_0
    //   521: ldc_w 278
    //   524: aastore
    //   525: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   528: aload_0
    //   529: bipush 9
    //   531: aload_0
    //   532: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   535: aconst_null
    //   536: aconst_null
    //   537: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   540: return
    //   541: astore 8
    //   543: aload 11
    //   545: astore 7
    //   547: aload 9
    //   549: ifnull +14 -> 563
    //   552: aload 9
    //   554: invokevirtual 456	java/io/BufferedInputStream:close	()V
    //   557: goto +6 -> 563
    //   560: goto +16 -> 576
    //   563: aload 7
    //   565: ifnull +8 -> 573
    //   568: aload 7
    //   570: invokevirtual 457	java/io/FileInputStream:close	()V
    //   573: aload 8
    //   575: athrow
    //   576: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +42 -> 621
    //   582: new 235	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   589: astore 7
    //   591: aload 7
    //   593: ldc_w 488
    //   596: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 7
    //   602: aload_0
    //   603: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   606: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: ldc 252
    //   612: iconst_2
    //   613: aload 7
    //   615: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: aload_0
    //   622: aconst_null
    //   623: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   626: goto +8 -> 634
    //   629: aload_0
    //   630: aconst_null
    //   631: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   634: aload_0
    //   635: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   638: ifnonnull +36 -> 674
    //   641: aload_0
    //   642: iconst_0
    //   643: putfield 54	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:p	Z
    //   646: ldc_w 437
    //   649: iconst_1
    //   650: anewarray 276	java/lang/String
    //   653: dup
    //   654: iconst_0
    //   655: ldc_w 471
    //   658: aastore
    //   659: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   662: aload_0
    //   663: iconst_5
    //   664: aload_0
    //   665: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   668: aconst_null
    //   669: aconst_null
    //   670: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   673: return
    //   674: new 287	java/io/File
    //   677: dup
    //   678: getstatic 289	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   681: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   684: astore 7
    //   686: aload 7
    //   688: invokevirtual 295	java/io/File:exists	()Z
    //   691: ifne +53 -> 744
    //   694: aload 7
    //   696: invokevirtual 298	java/io/File:mkdirs	()Z
    //   699: istore 6
    //   701: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   704: ifeq +40 -> 744
    //   707: new 235	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   714: astore 7
    //   716: aload 7
    //   718: ldc_w 490
    //   721: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 7
    //   727: iload 6
    //   729: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc 252
    //   735: iconst_2
    //   736: aload 7
    //   738: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: new 287	java/io/File
    //   747: dup
    //   748: aload_0
    //   749: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   752: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   755: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   758: astore 8
    //   760: aload 8
    //   762: astore 7
    //   764: aload 8
    //   766: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   769: ifne +49 -> 818
    //   772: aload 8
    //   774: ldc_w 311
    //   777: ldc_w 313
    //   780: invokevirtual 317	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   783: astore 7
    //   785: new 235	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   792: astore 8
    //   794: aload 8
    //   796: aload 7
    //   798: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 8
    //   804: ldc_w 319
    //   807: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 8
    //   813: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: astore 7
    //   818: new 235	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   825: astore 8
    //   827: aload 8
    //   829: getstatic 289	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   832: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 8
    //   838: aload 7
    //   840: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload_0
    //   845: aload 8
    //   847: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: putfield 321	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:t	Ljava/lang/String;
    //   853: new 235	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   860: astore 8
    //   862: aload 8
    //   864: aload_0
    //   865: getfield 321	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:t	Ljava/lang/String;
    //   868: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: aload 8
    //   874: ldc_w 492
    //   877: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 8
    //   883: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   886: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload_0
    //   891: aload 8
    //   893: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   896: putfield 494	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:v	Ljava/lang/String;
    //   899: aload_0
    //   900: getfield 494	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:v	Ljava/lang/String;
    //   903: invokestatic 326	com/tencent/biz/qqstory/utils/FileUtils:k	(Ljava/lang/String;)Z
    //   906: pop
    //   907: aload_0
    //   908: getfield 76	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:k	J
    //   911: lstore 4
    //   913: lload 4
    //   915: l2i
    //   916: istore_1
    //   917: aload_0
    //   918: lconst_0
    //   919: putfield 50	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:l	J
    //   922: aload_0
    //   923: lload 4
    //   925: ldc2_w 495
    //   928: lmul
    //   929: putfield 76	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:k	J
    //   932: aload_0
    //   933: aload_0
    //   934: getfield 76	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:k	J
    //   937: ldc2_w 497
    //   940: ldiv
    //   941: putfield 76	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:k	J
    //   944: aload_0
    //   945: invokespecial 272	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:c	()Z
    //   948: ifeq +53 -> 1001
    //   951: aload_0
    //   952: getfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   955: astore 7
    //   957: aload 7
    //   959: ifnull +13 -> 972
    //   962: aload 7
    //   964: invokevirtual 486	android/graphics/Bitmap:recycle	()V
    //   967: aload_0
    //   968: aconst_null
    //   969: putfield 453	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:w	Landroid/graphics/Bitmap;
    //   972: ldc_w 437
    //   975: iconst_1
    //   976: anewarray 276	java/lang/String
    //   979: dup
    //   980: iconst_0
    //   981: ldc_w 278
    //   984: aastore
    //   985: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   988: aload_0
    //   989: bipush 9
    //   991: aload_0
    //   992: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   995: aconst_null
    //   996: aconst_null
    //   997: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1000: return
    //   1001: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1004: lstore 4
    //   1006: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq +70 -> 1079
    //   1012: new 235	java/lang/StringBuilder
    //   1015: dup
    //   1016: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1019: astore 8
    //   1021: aload 8
    //   1023: ldc_w 500
    //   1026: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload 8
    //   1032: aload_0
    //   1033: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   1036: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 8
    //   1042: ldc_w 502
    //   1045: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 8
    //   1051: lload 4
    //   1053: lload_2
    //   1054: lsub
    //   1055: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 8
    //   1061: ldc_w 469
    //   1064: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: ldc 252
    //   1070: iconst_2
    //   1071: aload 8
    //   1073: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1079: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1082: lstore_2
    //   1083: new 235	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1090: astore 8
    //   1092: aload 8
    //   1094: getstatic 289	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   1097: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload 8
    //   1103: aload 7
    //   1105: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: aload 8
    //   1111: ldc_w 328
    //   1114: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: pop
    //   1118: aload 8
    //   1120: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1123: astore 7
    //   1125: aload 7
    //   1127: invokestatic 330	com/tencent/biz/qqstory/utils/FileUtils:i	(Ljava/lang/String;)Z
    //   1130: ifeq +9 -> 1139
    //   1133: aload 7
    //   1135: invokestatic 504	com/tencent/biz/qqstory/utils/FileUtils:j	(Ljava/lang/String;)Z
    //   1138: pop
    //   1139: aload 7
    //   1141: iload_1
    //   1142: bipush 42
    //   1144: iadd
    //   1145: bipush 15
    //   1147: iadd
    //   1148: invokestatic 391	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Ljava/lang/String;I)V
    //   1151: aload 7
    //   1153: invokestatic 330	com/tencent/biz/qqstory/utils/FileUtils:i	(Ljava/lang/String;)Z
    //   1156: ifne +94 -> 1250
    //   1159: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1162: ifeq +59 -> 1221
    //   1165: new 235	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1172: astore 8
    //   1174: aload 8
    //   1176: ldc_w 506
    //   1179: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: aload 8
    //   1185: aload_0
    //   1186: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   1189: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload 8
    //   1195: ldc_w 384
    //   1198: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload 8
    //   1204: aload 7
    //   1206: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: ldc 252
    //   1212: iconst_2
    //   1213: aload 8
    //   1215: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1221: ldc_w 437
    //   1224: iconst_1
    //   1225: anewarray 276	java/lang/String
    //   1228: dup
    //   1229: iconst_0
    //   1230: ldc_w 388
    //   1233: aastore
    //   1234: invokestatic 283	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1237: aload_0
    //   1238: bipush 8
    //   1240: aload_0
    //   1241: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:g	Ljava/lang/String;
    //   1244: aconst_null
    //   1245: aconst_null
    //   1246: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1249: return
    //   1250: aload_0
    //   1251: aload 7
    //   1253: putfield 167	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:u	Ljava/lang/String;
    //   1256: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1259: lstore 4
    //   1261: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1264: ifeq +70 -> 1334
    //   1267: new 235	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1274: astore 7
    //   1276: aload 7
    //   1278: ldc_w 508
    //   1281: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload 7
    //   1287: aload_0
    //   1288: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   1291: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: aload 7
    //   1297: ldc_w 510
    //   1300: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: aload 7
    //   1306: lload 4
    //   1308: lload_2
    //   1309: lsub
    //   1310: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload 7
    //   1316: ldc_w 469
    //   1319: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: ldc 252
    //   1325: iconst_2
    //   1326: aload 7
    //   1328: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1331: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1334: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1337: lstore_2
    //   1338: aload_0
    //   1339: new 263	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder
    //   1342: dup
    //   1343: invokespecial 511	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:<init>	()V
    //   1346: putfield 261	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:o	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1349: new 513	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   1352: dup
    //   1353: aload_0
    //   1354: getfield 494	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:v	Ljava/lang/String;
    //   1357: aload_0
    //   1358: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:i	I
    //   1361: aload_0
    //   1362: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:j	I
    //   1365: invokestatic 518	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	()Lcom/tencent/mobileqq/richmedia/capture/util/SVParamManager;
    //   1368: iconst_1
    //   1369: invokevirtual 520	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:c	(I)I
    //   1372: sipush 1000
    //   1375: imul
    //   1376: iconst_1
    //   1377: iconst_0
    //   1378: iconst_0
    //   1379: invokespecial 523	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   1382: astore 7
    //   1384: aload 7
    //   1386: invokestatic 529	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1389: invokevirtual 532	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:a	(Landroid/opengl/EGLContext;)V
    //   1392: aload_0
    //   1393: getfield 261	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:o	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1396: aload 7
    //   1398: aload_0
    //   1399: invokevirtual 535	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:a	(Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;)V
    //   1402: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1405: lstore 4
    //   1407: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1410: ifeq +70 -> 1480
    //   1413: new 235	java/lang/StringBuilder
    //   1416: dup
    //   1417: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1420: astore 7
    //   1422: aload 7
    //   1424: ldc_w 537
    //   1427: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 7
    //   1433: aload_0
    //   1434: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   1437: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: aload 7
    //   1443: ldc_w 539
    //   1446: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload 7
    //   1452: lload 4
    //   1454: lload_2
    //   1455: lsub
    //   1456: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 7
    //   1462: ldc_w 469
    //   1465: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: ldc 252
    //   1471: iconst_2
    //   1472: aload 7
    //   1474: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1480: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1483: ifeq +42 -> 1525
    //   1486: new 235	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1493: astore 7
    //   1495: aload 7
    //   1497: ldc_w 541
    //   1500: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: pop
    //   1504: aload 7
    //   1506: aload_0
    //   1507: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:s	J
    //   1510: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1513: pop
    //   1514: ldc 252
    //   1516: iconst_2
    //   1517: aload 7
    //   1519: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1525: return
    //   1526: astore 8
    //   1528: goto -1367 -> 161
    //   1531: astore 7
    //   1533: goto -973 -> 560
    //   1536: astore 7
    //   1538: goto -1293 -> 245
    //   1541: astore 8
    //   1543: goto -1306 -> 237
    //   1546: astore 7
    //   1548: goto -919 -> 629
    //   1551: astore 9
    //   1553: goto -990 -> 563
    //   1556: astore 7
    //   1558: goto -985 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1561	0	this	ConvertRunnable
    //   396	749	1	i1	int
    //   102	1353	2	l1	long
    //   274	1179	4	l2	long
    //   699	29	6	bool	boolean
    //   13	1505	7	localObject1	Object
    //   1531	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1536	1	7	localException1	java.lang.Exception
    //   1546	1	7	localException2	java.lang.Exception
    //   1556	1	7	localException3	java.lang.Exception
    //   128	29	8	localBufferedInputStream	java.io.BufferedInputStream
    //   174	1	8	localObject2	Object
    //   185	1	8	localObject3	Object
    //   190	1	8	localObject4	Object
    //   205	25	8	localObject5	Object
    //   541	33	8	localObject6	Object
    //   758	456	8	localObject7	Object
    //   1526	1	8	localException4	java.lang.Exception
    //   1541	1	8	localException5	java.lang.Exception
    //   132	421	9	localObject8	Object
    //   1551	1	9	localException6	java.lang.Exception
    //   169	1	10	localException7	java.lang.Exception
    //   182	1	10	localException8	java.lang.Exception
    //   202	18	10	localException9	java.lang.Exception
    //   136	408	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   138	156	169	java/lang/Exception
    //   116	130	174	finally
    //   116	130	182	java/lang/Exception
    //   103	116	190	finally
    //   103	116	202	java/lang/Exception
    //   138	156	541	finally
    //   219	224	541	finally
    //   156	161	1526	java/lang/Exception
    //   156	161	1531	java/lang/OutOfMemoryError
    //   161	166	1531	java/lang/OutOfMemoryError
    //   229	234	1531	java/lang/OutOfMemoryError
    //   245	271	1531	java/lang/OutOfMemoryError
    //   271	349	1531	java/lang/OutOfMemoryError
    //   349	388	1531	java/lang/OutOfMemoryError
    //   389	397	1531	java/lang/OutOfMemoryError
    //   408	486	1531	java/lang/OutOfMemoryError
    //   486	512	1531	java/lang/OutOfMemoryError
    //   512	540	1531	java/lang/OutOfMemoryError
    //   552	557	1531	java/lang/OutOfMemoryError
    //   568	573	1531	java/lang/OutOfMemoryError
    //   573	576	1531	java/lang/OutOfMemoryError
    //   161	166	1536	java/lang/Exception
    //   229	234	1541	java/lang/Exception
    //   245	271	1546	java/lang/Exception
    //   271	349	1546	java/lang/Exception
    //   349	388	1546	java/lang/Exception
    //   389	397	1546	java/lang/Exception
    //   408	486	1546	java/lang/Exception
    //   486	512	1546	java/lang/Exception
    //   512	540	1546	java/lang/Exception
    //   573	576	1546	java/lang/Exception
    //   552	557	1551	java/lang/Exception
    //   568	573	1556	java/lang/Exception
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("onEncodeError, code:");
      paramThrowable.append(paramInt);
      paramThrowable.append(" taskID:");
      paramThrowable.append(this.s);
      paramThrowable.append(" run:");
      paramThrowable.append(this.p);
      QLog.e("ConvertRunnable", 2, paramThrowable.toString());
    }
    if (this.p)
    {
      this.p = false;
      this.q = 7;
      a(this.q, this.g, this.t, null);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEncodeFinish, taskid:");
      localStringBuilder.append(this.s);
      localStringBuilder.append(" run:");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" finish cost: ");
      localStringBuilder.append(l1 - this.c);
      localStringBuilder.append(" ms");
      QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
    }
    if (this.p)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFinish, delete old:");
        localStringBuilder.append(this.s);
        localStringBuilder.append(" file:");
        localStringBuilder.append(this.t);
        QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
      }
      FileUtils.k(this.t);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFinish, rename start:");
        localStringBuilder.append(this.s);
        localStringBuilder.append(" file:");
        localStringBuilder.append(this.t);
        QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
      }
      if (FileUtils.a(paramString, this.t)) {
        this.q = 0;
      } else {
        this.q = 7;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onEncodeFinish, rename end:");
        paramString.append(this.s);
        paramString.append(" file:");
        paramString.append(this.t);
        paramString.append(" result:");
        paramString.append(this.q);
        QLog.d("ConvertRunnable", 2, paramString.toString());
      }
      if (FileUtil.d(this.t))
      {
        l1 = FileUtil.f(this.t);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onEncodeFinish, file exist, size:");
          paramString.append(l1);
          paramString.append(" file:");
          paramString.append(this.t);
          QLog.d("ConvertRunnable", 2, paramString.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onEncodeFinish, file not exist:");
        paramString.append(this.s);
        paramString.append(" file:");
        paramString.append(this.t);
        QLog.d("ConvertRunnable", 2, paramString.toString());
      }
      paramString = this.o.d();
      l1 = System.currentTimeMillis();
      long l2 = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("");
      StoryReportor.a("actImage2VideoTime", new String[] { localStringBuilder.toString() });
      StoryReportor.a("actImage2VideoResult", new String[] { "0" });
      a(this.q, this.g, this.t, paramString);
    }
    else
    {
      StoryReportor.a("actImage2VideoResult", new String[] { "3" });
      FileUtils.k(paramString);
    }
    paramString = this.a;
    if (paramString != null)
    {
      paramString.surfaceDestroyed();
      this.a = null;
    }
    paramString = this.o;
    if (paramString != null)
    {
      paramString.e();
      this.o = null;
    }
  }
  
  public void onEncodeFrame()
  {
    Object localObject;
    if (!this.p)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeFrame, mRun is false, tasid.");
        ((StringBuilder)localObject).append(this.s);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.o;
      if (localObject != null) {
        ((HWVideoRecorder)localObject).b();
      }
      return;
    }
    if (!d())
    {
      localObject = this.o;
      if (localObject != null) {
        ((HWVideoRecorder)localObject).b();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeFrame, stop recoder, taskid:");
        ((StringBuilder)localObject).append(this.s);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onEncodeStart()
  {
    if (this.p)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.s);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.r) {
        this.m = b(this.w, this.i, this.j);
      } else {
        this.m = a(this.w, this.i, this.j);
      }
      localObject = this.w;
      if (localObject != null)
      {
        ((Bitmap)localObject).recycle();
        this.w = null;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.s);
        ((StringBuilder)localObject).append(" run:");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append(" preProcess cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms mGpuBlur:");
        ((StringBuilder)localObject).append(this.r);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      this.c = System.currentTimeMillis();
      d();
      return;
    }
    Object localObject = this.w;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.w = null;
    }
    localObject = this.o;
    if (localObject != null) {
      ((HWVideoRecorder)localObject).b();
    }
  }
  
  public void run()
  {
    if (this.h.e == 0)
    {
      this.e = System.currentTimeMillis();
      b();
      return;
    }
    this.f = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */