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
import bbmy;
import bbna;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import ykv;
import yzh;
import yzo;
import zah;
import zdy;
import zeb;

public class ConvertRunnable
  implements bbmy, Runnable
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bbna jdField_a_of_type_Bbna;
  private SlideItemInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<yzh> jdField_a_of_type_JavaLangRefWeakReference;
  zah jdField_a_of_type_Zah;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private long e;
  private long f = -1L;
  
  public ConvertRunnable(Context paramContext, long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, yzh paramyzh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyzh);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = true;
    this.f = paramLong1;
    this.jdField_a_of_type_Zah = null;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0)) {
      if (paramBitmap == null) {
        paramInt1 = i;
      }
    }
    do
    {
      return paramInt1;
      return GlUtil.createTexture(3553, paramBitmap);
      i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.deleteTexture(i);
    return paramInt2;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      yzh localyzh = (yzh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localyzh != null)
      {
        yzo localyzo = new yzo();
        localyzo.jdField_a_of_type_Long = this.f;
        localyzo.jdField_a_of_type_Int = paramInt;
        localyzo.jdField_b_of_type_JavaLangString = paramString2;
        localyzo.jdField_a_of_type_JavaLangString = paramString1;
        localyzo.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        localyzo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        localyzo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean;
        localyzo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int;
        localyzh.a(localyzo);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("ConvertRunnable", 2, "run exit:" + this.f + " run:" + this.jdField_a_of_type_Boolean);
    }
    return !this.jdField_a_of_type_Boolean;
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if (paramBitmap == null) {
        return 0;
      }
      return GlUtil.createTexture(3553, paramBitmap);
    }
    Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
    float f2 = paramInt1 * 1.0F / paramInt2;
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localObject1 = new Matrix();
    ((Matrix)localObject1).postTranslate(i * -0.5F, j * -0.5F);
    float f3;
    float f4;
    Object localObject2;
    if (f1 > f2)
    {
      ((Matrix)localObject1).postScale(1.0F, paramInt1 * 1.0F / paramBitmap.getWidth() * paramBitmap.getHeight() / paramInt2);
      f2 = paramInt2;
      f3 = paramInt1 / f1;
      f4 = paramInt1;
      float f5 = paramInt2;
      localObject2 = new RectF(0.0F, 0.5F * (f2 - f3), f4, (paramInt1 / f1 + f5) * 0.5F);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), (RectF)localObject2, null);
    }
    for (;;)
    {
      ((Matrix)localObject1).postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
      ((Matrix)localObject1).postScale(paramInt2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / paramInt1, 1.0F);
      localObject2 = new Rect(0, 0, i, j);
      f2 = paramInt1;
      f3 = paramInt2;
      f4 = paramInt1;
      localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f2 - f3 * f1) * 0.5F, 0.0F, (f1 * paramInt2 + f4) * 0.5F, paramInt2), null);
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bbna != null) && (this.jdField_c_of_type_Int > 0) && (this.e < this.jdField_d_of_type_Long))
    {
      this.jdField_a_of_type_Bbna.a(3553, this.jdField_c_of_type_Int, null, null, this.e);
      this.e += 42000000L;
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "[runLocalVideo2Video]run begin, taskid:" + this.f + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (a())
    {
      ykv.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
    }
    Object localObject1 = new File(Image2Video.jdField_b_of_type_JavaLangString);
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, createDir:" + bool);
      }
    }
    localObject1 = null;
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (localObject3 != null)
    {
      localObject3 = ((File)localObject3).getName();
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = ((String)localObject3).replace(".", "_");
        localObject1 = (String)localObject1 + ".mp4";
      }
    }
    this.jdField_b_of_type_JavaLangString = (Image2Video.jdField_b_of_type_JavaLangString + (String)localObject1);
    zeb.g(this.jdField_b_of_type_JavaLangString);
    localObject1 = this.jdField_b_of_type_JavaLangString + ".dat";
    if (zeb.e((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "before,getPCMFromFile[Have audio File]:  " + this.f + " audioPath: " + (String)localObject1 + " audioFileSize=" + FileUtil.getFileSize((String)localObject1));
      }
      localObject3 = new zdy();
      l1 = System.currentTimeMillis();
      ((zdy)localObject3).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run,getMetaDataFromFile:  " + this.f + " cost=" + (l2 - l1) + " ms audioTrack: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean + " mSampleRate: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaLangString = ((String)localObject1);
      if (!a()) {
        break;
      }
      ykv.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
      localObject3 = new zdy();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mDuration = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long;
      l1 = System.currentTimeMillis();
      bool = ((zdy)localObject3).a(localLocalMediaInfo, 0, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long, (String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run,getPCMFromFile:  " + this.f + " cost=" + (l2 - l1) + " ms audioTrack: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean)
      {
        if ((!bool) || (!zeb.e((String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run,getPCMFromFile: failed " + this.f + " path=" + (String)localObject1 + " success=" + bool);
          }
          zeb.g((String)localObject1);
          ykv.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
        }
      }
      else
      {
        zeb.g((String)localObject1);
        zdy.a((String)localObject1, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long);
        if (!zeb.e((String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run[video convert],createSilentPCMFile: failed " + this.f + " path=" + (String)localObject1);
          }
          ykv.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "After,getPCMFromFile: hasAudioTrack= " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean + " path=" + (String)localObject1 + " success=" + bool + " audioFileSize=" + FileUtil.getFileSize((String)localObject1));
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Zah = new zah();
      if (a())
      {
        ykv.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
    }
    finally {}
    long l1 = System.currentTimeMillis();
    boolean bool = this.jdField_a_of_type_Zah.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
    long l2 = System.currentTimeMillis();
    if (a())
    {
      ykv.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_c_of_type_Long;
    ykv.a("actVideo2VideoTime", new String[] { l3 - l4 + "" });
    if ((bool) && (FileUtil.isFileExists(this.jdField_b_of_type_JavaLangString)))
    {
      l3 = FileUtil.getFileSize(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, file exist, size:" + l3 + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_Int = 0;
      ykv.a("actVideo2VideoResult", new String[] { "0" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, taskid:" + this.f + " run:" + this.jdField_a_of_type_Boolean + " cost:" + (l2 - l1) + " ms successVideo:" + bool);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, [failed]file not exist:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_Int = 7;
      ykv.a("actVideo2VideoResult", new String[] { "7" });
      zeb.g(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +44 -> 47
    //   6: ldc 161
    //   8: iconst_2
    //   9: new 163	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 411
    //   19: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   26: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc 175
    //   31: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   38: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   51: ifeq +31 -> 82
    //   54: ldc_w 413
    //   57: iconst_1
    //   58: anewarray 253	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc 255
    //   65: aastore
    //   66: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   69: aload_0
    //   70: bipush 9
    //   72: aload_0
    //   73: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   81: return
    //   82: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   85: lstore_2
    //   86: new 415	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: invokespecial 416	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   97: astore 9
    //   99: new 418	java/io/BufferedInputStream
    //   102: dup
    //   103: aload 9
    //   105: ldc_w 419
    //   108: invokespecial 422	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   111: astore 8
    //   113: aload_0
    //   114: aload 8
    //   116: aconst_null
    //   117: aload_0
    //   118: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   121: aload_0
    //   122: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   125: invokestatic 427	bgyo:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   128: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   131: aload 8
    //   133: ifnull +8 -> 141
    //   136: aload 8
    //   138: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   141: aload 9
    //   143: ifnull +8 -> 151
    //   146: aload 9
    //   148: invokevirtual 433	java/io/FileInputStream:close	()V
    //   151: aload_0
    //   152: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   155: ifnonnull +22 -> 177
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   167: aload_0
    //   168: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   171: invokestatic 436	bgyo:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   174: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   177: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   180: lstore 4
    //   182: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +51 -> 236
    //   188: ldc 161
    //   190: iconst_2
    //   191: new 163	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 438
    //   201: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   208: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc_w 440
    //   214: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: lload 4
    //   219: lload_2
    //   220: lsub
    //   221: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: ldc_w 442
    //   227: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   240: ifnonnull +200 -> 440
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   248: ldc_w 413
    //   251: iconst_1
    //   252: anewarray 253	java/lang/String
    //   255: dup
    //   256: iconst_0
    //   257: ldc_w 444
    //   260: aastore
    //   261: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   264: aload_0
    //   265: iconst_5
    //   266: aload_0
    //   267: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   270: aconst_null
    //   271: aconst_null
    //   272: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   275: return
    //   276: astore 7
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   283: aload_0
    //   284: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   287: ifnonnull +304 -> 591
    //   290: aload_0
    //   291: iconst_0
    //   292: putfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   295: ldc_w 413
    //   298: iconst_1
    //   299: anewarray 253	java/lang/String
    //   302: dup
    //   303: iconst_0
    //   304: ldc_w 444
    //   307: aastore
    //   308: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   311: aload_0
    //   312: iconst_5
    //   313: aload_0
    //   314: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: aconst_null
    //   318: aconst_null
    //   319: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   322: return
    //   323: astore 9
    //   325: aconst_null
    //   326: astore 7
    //   328: aconst_null
    //   329: astore 8
    //   331: aload 9
    //   333: invokevirtual 447	java/lang/Exception:printStackTrace	()V
    //   336: aload 8
    //   338: ifnull +8 -> 346
    //   341: aload 8
    //   343: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   346: aload 7
    //   348: ifnull -197 -> 151
    //   351: aload 7
    //   353: invokevirtual 433	java/io/FileInputStream:close	()V
    //   356: goto -205 -> 151
    //   359: astore 7
    //   361: goto -210 -> 151
    //   364: astore 7
    //   366: aconst_null
    //   367: astore 9
    //   369: aconst_null
    //   370: astore 8
    //   372: aload 8
    //   374: ifnull +8 -> 382
    //   377: aload 8
    //   379: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   382: aload 9
    //   384: ifnull +8 -> 392
    //   387: aload 9
    //   389: invokevirtual 433	java/io/FileInputStream:close	()V
    //   392: aload 7
    //   394: athrow
    //   395: astore 7
    //   397: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +32 -> 432
    //   403: ldc 161
    //   405: iconst_2
    //   406: new 163	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 449
    //   416: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_0
    //   420: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   423: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_0
    //   433: aconst_null
    //   434: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   437: goto -154 -> 283
    //   440: aload_0
    //   441: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   444: invokestatic 454	bheg:b	(Ljava/lang/String;)I
    //   447: istore_1
    //   448: iload_1
    //   449: ifeq +88 -> 537
    //   452: iload_1
    //   453: bipush 90
    //   455: irem
    //   456: ifne +81 -> 537
    //   459: new 212	android/graphics/Matrix
    //   462: dup
    //   463: invokespecial 213	android/graphics/Matrix:<init>	()V
    //   466: astore 7
    //   468: aload 7
    //   470: iload_1
    //   471: i2f
    //   472: aload_0
    //   473: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   476: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   479: i2f
    //   480: fconst_2
    //   481: fdiv
    //   482: aload_0
    //   483: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   486: invokevirtual 114	android/graphics/Bitmap:getHeight	()I
    //   489: i2f
    //   490: fconst_2
    //   491: fdiv
    //   492: invokevirtual 458	android/graphics/Matrix:postRotate	(FFF)Z
    //   495: pop
    //   496: aload_0
    //   497: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   500: iconst_0
    //   501: iconst_0
    //   502: aload_0
    //   503: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   506: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   509: aload_0
    //   510: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   513: invokevirtual 114	android/graphics/Bitmap:getHeight	()I
    //   516: aload 7
    //   518: iconst_1
    //   519: invokestatic 461	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   522: astore 7
    //   524: aload_0
    //   525: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   528: invokevirtual 464	android/graphics/Bitmap:recycle	()V
    //   531: aload_0
    //   532: aload 7
    //   534: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   537: aload_0
    //   538: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   541: ifeq -258 -> 283
    //   544: aload_0
    //   545: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   548: ifnull +15 -> 563
    //   551: aload_0
    //   552: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   555: invokevirtual 464	android/graphics/Bitmap:recycle	()V
    //   558: aload_0
    //   559: aconst_null
    //   560: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   563: ldc_w 413
    //   566: iconst_1
    //   567: anewarray 253	java/lang/String
    //   570: dup
    //   571: iconst_0
    //   572: ldc 255
    //   574: aastore
    //   575: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   578: aload_0
    //   579: bipush 9
    //   581: aload_0
    //   582: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   585: aconst_null
    //   586: aconst_null
    //   587: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   590: return
    //   591: new 264	java/io/File
    //   594: dup
    //   595: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   598: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   601: astore 7
    //   603: aload 7
    //   605: invokevirtual 271	java/io/File:exists	()Z
    //   608: ifne +43 -> 651
    //   611: aload 7
    //   613: invokevirtual 274	java/io/File:mkdirs	()Z
    //   616: istore 6
    //   618: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq +30 -> 651
    //   624: ldc 161
    //   626: iconst_2
    //   627: new 163	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 466
    //   637: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload 6
    //   642: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: aconst_null
    //   652: astore 7
    //   654: new 264	java/io/File
    //   657: dup
    //   658: aload_0
    //   659: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   662: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   665: astore 8
    //   667: aload 8
    //   669: ifnull +58 -> 727
    //   672: aload 8
    //   674: invokevirtual 279	java/io/File:getName	()Ljava/lang/String;
    //   677: astore 8
    //   679: aload 8
    //   681: astore 7
    //   683: aload 8
    //   685: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +39 -> 727
    //   691: aload 8
    //   693: ldc_w 287
    //   696: ldc_w 289
    //   699: invokevirtual 293	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   702: astore 7
    //   704: new 163	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   711: aload 7
    //   713: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: ldc_w 295
    //   719: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: astore 7
    //   727: aload_0
    //   728: new 163	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   735: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   738: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload 7
    //   743: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: putfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   752: aload_0
    //   753: new 163	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   760: aload_0
    //   761: getfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   764: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: ldc_w 468
    //   770: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   776: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   779: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: putfield 470	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   785: aload_0
    //   786: getfield 470	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   789: invokestatic 302	zeb:g	(Ljava/lang/String;)Z
    //   792: pop
    //   793: aload_0
    //   794: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   797: l2i
    //   798: istore_1
    //   799: aload_0
    //   800: lconst_0
    //   801: putfield 238	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:e	J
    //   804: aload_0
    //   805: ldc2_w 471
    //   808: aload_0
    //   809: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   812: lmul
    //   813: putfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   816: aload_0
    //   817: aload_0
    //   818: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   821: ldc2_w 473
    //   824: ldiv
    //   825: putfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   828: aload_0
    //   829: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   832: ifeq +50 -> 882
    //   835: aload_0
    //   836: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   839: ifnull +15 -> 854
    //   842: aload_0
    //   843: getfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   846: invokevirtual 464	android/graphics/Bitmap:recycle	()V
    //   849: aload_0
    //   850: aconst_null
    //   851: putfield 429	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   854: ldc_w 413
    //   857: iconst_1
    //   858: anewarray 253	java/lang/String
    //   861: dup
    //   862: iconst_0
    //   863: ldc 255
    //   865: aastore
    //   866: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   869: aload_0
    //   870: bipush 9
    //   872: aload_0
    //   873: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   876: aconst_null
    //   877: aconst_null
    //   878: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   881: return
    //   882: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   885: lstore 4
    //   887: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq +51 -> 941
    //   893: ldc 161
    //   895: iconst_2
    //   896: new 163	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 476
    //   906: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_0
    //   910: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   913: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: ldc_w 478
    //   919: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: lload 4
    //   924: lload_2
    //   925: lsub
    //   926: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   929: ldc_w 442
    //   932: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   944: lstore_2
    //   945: new 163	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   952: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   955: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 7
    //   960: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: ldc_w 304
    //   966: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: astore 7
    //   974: aload 7
    //   976: invokestatic 306	zeb:e	(Ljava/lang/String;)Z
    //   979: ifeq +9 -> 988
    //   982: aload 7
    //   984: invokestatic 480	zeb:f	(Ljava/lang/String;)Z
    //   987: pop
    //   988: aload 7
    //   990: iload_1
    //   991: bipush 42
    //   993: iadd
    //   994: bipush 15
    //   996: iadd
    //   997: invokestatic 367	zdy:a	(Ljava/lang/String;I)V
    //   1000: aload 7
    //   1002: invokestatic 306	zeb:e	(Ljava/lang/String;)Z
    //   1005: ifne +78 -> 1083
    //   1008: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq +43 -> 1054
    //   1014: ldc 161
    //   1016: iconst_2
    //   1017: new 163	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1024: ldc_w 482
    //   1027: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload_0
    //   1031: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1034: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1037: ldc_w 360
    //   1040: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload 7
    //   1045: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: ldc_w 413
    //   1057: iconst_1
    //   1058: anewarray 253	java/lang/String
    //   1061: dup
    //   1062: iconst_0
    //   1063: ldc_w 364
    //   1066: aastore
    //   1067: invokestatic 260	ykv:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1070: aload_0
    //   1071: bipush 8
    //   1073: aload_0
    //   1074: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1077: aconst_null
    //   1078: aconst_null
    //   1079: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1082: return
    //   1083: aload_0
    //   1084: aload 7
    //   1086: putfield 145	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1089: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   1092: lstore 4
    //   1094: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1097: ifeq +51 -> 1148
    //   1100: ldc 161
    //   1102: iconst_2
    //   1103: new 163	java/lang/StringBuilder
    //   1106: dup
    //   1107: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1110: ldc_w 484
    //   1113: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: aload_0
    //   1117: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1120: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1123: ldc_w 486
    //   1126: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: lload 4
    //   1131: lload_2
    //   1132: lsub
    //   1133: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1136: ldc_w 442
    //   1139: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   1151: lstore_2
    //   1152: aload_0
    //   1153: new 240	bbna
    //   1156: dup
    //   1157: invokespecial 487	bbna:<init>	()V
    //   1160: putfield 236	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Bbna	Lbbna;
    //   1163: new 489	bbmm
    //   1166: dup
    //   1167: aload_0
    //   1168: getfield 470	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1171: aload_0
    //   1172: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   1175: aload_0
    //   1176: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   1179: invokestatic 494	bbhu:a	()Lbbhu;
    //   1182: iconst_1
    //   1183: invokevirtual 496	bbhu:a	(I)I
    //   1186: sipush 1000
    //   1189: imul
    //   1190: iconst_1
    //   1191: iconst_0
    //   1192: iconst_0
    //   1193: invokespecial 499	bbmm:<init>	(Ljava/lang/String;IIIIZI)V
    //   1196: astore 7
    //   1198: aload 7
    //   1200: invokestatic 505	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1203: invokevirtual 508	bbmm:a	(Landroid/opengl/EGLContext;)V
    //   1206: aload_0
    //   1207: getfield 236	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Bbna	Lbbna;
    //   1210: aload 7
    //   1212: aload_0
    //   1213: invokevirtual 511	bbna:a	(Lbbmm;Lbbmy;)V
    //   1216: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   1219: lstore 4
    //   1221: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1224: ifeq +51 -> 1275
    //   1227: ldc 161
    //   1229: iconst_2
    //   1230: new 163	java/lang/StringBuilder
    //   1233: dup
    //   1234: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1237: ldc_w 513
    //   1240: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: aload_0
    //   1244: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1247: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 515
    //   1253: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: lload 4
    //   1258: lload_2
    //   1259: lsub
    //   1260: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1263: ldc_w 442
    //   1266: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1278: ifeq -1197 -> 81
    //   1281: ldc 161
    //   1283: iconst_2
    //   1284: new 163	java/lang/StringBuilder
    //   1287: dup
    //   1288: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1291: ldc_w 517
    //   1294: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload_0
    //   1298: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1301: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1304: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1307: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1310: return
    //   1311: astore 7
    //   1313: goto -1172 -> 141
    //   1316: astore 7
    //   1318: goto -1167 -> 151
    //   1321: astore 8
    //   1323: goto -977 -> 346
    //   1326: astore 8
    //   1328: goto -946 -> 382
    //   1331: astore 8
    //   1333: goto -941 -> 392
    //   1336: astore 7
    //   1338: aconst_null
    //   1339: astore 8
    //   1341: goto -969 -> 372
    //   1344: astore 7
    //   1346: goto -974 -> 372
    //   1349: astore 10
    //   1351: aload 7
    //   1353: astore 9
    //   1355: aload 10
    //   1357: astore 7
    //   1359: goto -987 -> 372
    //   1362: astore 10
    //   1364: aconst_null
    //   1365: astore 8
    //   1367: aload 9
    //   1369: astore 7
    //   1371: aload 10
    //   1373: astore 9
    //   1375: goto -1044 -> 331
    //   1378: astore 10
    //   1380: aload 9
    //   1382: astore 7
    //   1384: aload 10
    //   1386: astore 9
    //   1388: goto -1057 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1391	0	this	ConvertRunnable
    //   447	547	1	i	int
    //   85	1174	2	l1	long
    //   180	1077	4	l2	long
    //   616	25	6	bool	boolean
    //   276	1	7	localException1	java.lang.Exception
    //   326	26	7	localObject1	Object
    //   359	1	7	localException2	java.lang.Exception
    //   364	29	7	localObject2	Object
    //   395	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   466	745	7	localObject3	Object
    //   1311	1	7	localException3	java.lang.Exception
    //   1316	1	7	localException4	java.lang.Exception
    //   1336	1	7	localObject4	Object
    //   1344	8	7	localObject5	Object
    //   1357	26	7	localObject6	Object
    //   111	581	8	localObject7	Object
    //   1321	1	8	localException5	java.lang.Exception
    //   1326	1	8	localException6	java.lang.Exception
    //   1331	1	8	localException7	java.lang.Exception
    //   1339	27	8	localObject8	Object
    //   97	50	9	localFileInputStream	java.io.FileInputStream
    //   323	9	9	localException8	java.lang.Exception
    //   367	1020	9	localObject9	Object
    //   1349	7	10	localObject10	Object
    //   1362	10	10	localException9	java.lang.Exception
    //   1378	7	10	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   151	177	276	java/lang/Exception
    //   177	236	276	java/lang/Exception
    //   236	275	276	java/lang/Exception
    //   392	395	276	java/lang/Exception
    //   440	448	276	java/lang/Exception
    //   459	537	276	java/lang/Exception
    //   537	563	276	java/lang/Exception
    //   563	590	276	java/lang/Exception
    //   86	99	323	java/lang/Exception
    //   351	356	359	java/lang/Exception
    //   86	99	364	finally
    //   136	141	395	java/lang/OutOfMemoryError
    //   146	151	395	java/lang/OutOfMemoryError
    //   151	177	395	java/lang/OutOfMemoryError
    //   177	236	395	java/lang/OutOfMemoryError
    //   236	275	395	java/lang/OutOfMemoryError
    //   341	346	395	java/lang/OutOfMemoryError
    //   351	356	395	java/lang/OutOfMemoryError
    //   377	382	395	java/lang/OutOfMemoryError
    //   387	392	395	java/lang/OutOfMemoryError
    //   392	395	395	java/lang/OutOfMemoryError
    //   440	448	395	java/lang/OutOfMemoryError
    //   459	537	395	java/lang/OutOfMemoryError
    //   537	563	395	java/lang/OutOfMemoryError
    //   563	590	395	java/lang/OutOfMemoryError
    //   136	141	1311	java/lang/Exception
    //   146	151	1316	java/lang/Exception
    //   341	346	1321	java/lang/Exception
    //   377	382	1326	java/lang/Exception
    //   387	392	1331	java/lang/Exception
    //   99	113	1336	finally
    //   113	131	1344	finally
    //   331	336	1349	finally
    //   99	113	1362	java/lang/Exception
    //   113	131	1378	java/lang/Exception
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ConvertRunnable", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.f + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Int = 7;
      a(this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, taskid:" + this.f + " run:" + this.jdField_a_of_type_Boolean + " finish cost: " + (l1 - this.jdField_a_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, delete old:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      zeb.g(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename start:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      if (zeb.a(paramString, this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_d_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename end:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString + " result:" + this.jdField_d_of_type_Int);
        }
        if (!FileUtil.isFileExists(this.jdField_b_of_type_JavaLangString)) {
          break label458;
        }
        l1 = FileUtil.getFileSize(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_b_of_type_JavaLangString);
        }
        label323:
        paramString = this.jdField_a_of_type_Bbna.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_b_of_type_Long;
        ykv.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        ykv.a("actImage2VideoResult", new String[] { "0" });
        a(this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (this.jdField_a_of_type_Bbna != null)
      {
        this.jdField_a_of_type_Bbna.c();
        this.jdField_a_of_type_Bbna = null;
      }
      return;
      this.jdField_d_of_type_Int = 7;
      break;
      label458:
      if (!QLog.isColorLevel()) {
        break label323;
      }
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, file not exist:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString);
      break label323;
      ykv.a("actImage2VideoResult", new String[] { "3" });
      zeb.g(paramString);
    }
  }
  
  public void onEncodeFrame()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFrame, mRun is false, tasid." + this.f);
      }
      if (this.jdField_a_of_type_Bbna != null) {
        this.jdField_a_of_type_Bbna.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (b());
      if (this.jdField_a_of_type_Bbna != null) {
        this.jdField_a_of_type_Bbna.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConvertRunnable", 2, "onEncodeFrame, stop recoder, taskid:" + this.f);
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.f);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = b(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.f + " run:" + this.jdField_a_of_type_Boolean + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + this.jdField_b_of_type_Boolean);
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        b();
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_Int = a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      break;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    } while (this.jdField_a_of_type_Bbna == null);
    this.jdField_a_of_type_Bbna.b();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_b_of_type_Int == 0)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      b();
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */