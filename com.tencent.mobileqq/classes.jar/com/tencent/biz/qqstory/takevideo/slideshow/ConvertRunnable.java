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
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SlideItemInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo;
  Video2Video jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowVideo2Video;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ConvertRunnable.ConvertRunnableListener> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
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
  private long e = 0L;
  private long f = -1L;
  
  public ConvertRunnable(Context paramContext, long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, ConvertRunnable.ConvertRunnableListener paramConvertRunnableListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramConvertRunnableListener);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = true;
    this.f = paramLong1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowVideo2Video = null;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      int i = GlUtil.createTexture(3553, paramBitmap);
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
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      if (i > 0) {
        GlUtil.deleteTexture(i);
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (ConvertRunnable.ConvertRunnableListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ResultInfo localResultInfo = new ResultInfo();
        localResultInfo.jdField_a_of_type_Long = this.f;
        localResultInfo.jdField_a_of_type_Int = paramInt;
        localResultInfo.jdField_b_of_type_JavaLangString = paramString2;
        localResultInfo.jdField_a_of_type_JavaLangString = paramString1;
        localResultInfo.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        localResultInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        localResultInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean;
        localResultInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int;
        ((ConvertRunnable.ConvertRunnableListener)localObject).a(localResultInfo);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("run exit:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" run:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Boolean ^ true;
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
  
  private boolean b()
  {
    HWVideoRecorder localHWVideoRecorder = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
    if (localHWVideoRecorder != null)
    {
      int i = this.jdField_c_of_type_Int;
      if (i > 0)
      {
        long l = this.e;
        if (l < this.jdField_d_of_type_Long)
        {
          localHWVideoRecorder.a(3553, i, null, null, l);
          this.e += 42000000L;
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
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
    }
    if (a())
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
    }
    Object localObject1 = new File(Image2Video.jdField_b_of_type_JavaLangString);
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
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString).getName();
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
    ((StringBuilder)localObject3).append(Image2Video.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject3).append((String)localObject1);
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
    FileUtils.g(this.jdField_b_of_type_JavaLangString);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    long l1;
    long l2;
    if (FileUtils.e((String)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("before,getPCMFromFile[Have audio File]:  ");
        ((StringBuilder)localObject3).append(this.f);
        ((StringBuilder)localObject3).append(" audioPath: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" audioFileSize=");
        ((StringBuilder)localObject3).append(FileUtil.a((String)localObject1));
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new ExtractPCMFromFile();
      l1 = System.currentTimeMillis();
      ((ExtractPCMFromFile)localObject3).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run,getMetaDataFromFile:  ");
        ((StringBuilder)localObject3).append(this.f);
        ((StringBuilder)localObject3).append(" cost=");
        ((StringBuilder)localObject3).append(l2 - l1);
        ((StringBuilder)localObject3).append(" ms audioTrack: ");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject3).append(" mSampleRate: ");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject3 = new ExtractPCMFromFile();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mDuration = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long;
      l1 = System.currentTimeMillis();
      bool = ((ExtractPCMFromFile)localObject3).a(localLocalMediaInfo, 0, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long, (String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run,getPCMFromFile:  ");
        ((StringBuilder)localObject3).append(this.f);
        ((StringBuilder)localObject3).append(" cost=");
        ((StringBuilder)localObject3).append(l2 - l1);
        ((StringBuilder)localObject3).append(" ms audioTrack: ");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean)
      {
        if ((!bool) || (!FileUtils.e((String)localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run,getPCMFromFile: failed ");
            ((StringBuilder)localObject3).append(this.f);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" success=");
            ((StringBuilder)localObject3).append(bool);
            QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
          }
          FileUtils.g((String)localObject1);
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
        }
      }
      else
      {
        FileUtils.g((String)localObject1);
        ExtractPCMFromFile.a((String)localObject1, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long);
        if (!FileUtils.e((String)localObject1))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run[video convert],createSilentPCMFile: failed ");
            ((StringBuilder)localObject3).append(this.f);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
          }
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("After,getPCMFromFile: hasAudioTrack= ");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject3).append(" path=");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" success=");
        ((StringBuilder)localObject3).append(bool);
        ((StringBuilder)localObject3).append(" audioFileSize=");
        ((StringBuilder)localObject3).append(FileUtil.a((String)localObject1));
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject3).toString());
      }
    }
    this.jdField_c_of_type_JavaLangString = ((String)localObject1);
    if (a())
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowVideo2Video = new Video2Video();
      if (a())
      {
        StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
      l1 = System.currentTimeMillis();
      bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowVideo2Video.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (a())
      {
        StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
      long l3 = System.currentTimeMillis();
      long l4 = this.jdField_c_of_type_Long;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l3 - l4);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actVideo2VideoTime", new String[] { ((StringBuilder)localObject1).toString() });
      if ((bool) && (FileUtil.b(this.jdField_b_of_type_JavaLangString)))
      {
        l3 = FileUtil.a(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("runLocalVideo2Video, file exist, size:");
          ((StringBuilder)localObject1).append(l3);
          ((StringBuilder)localObject1).append(" file:");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_d_of_type_Int = 0;
        StoryReportor.a("actVideo2VideoResult", new String[] { "0" });
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("runLocalVideo2Video, [failed]file not exist:");
          ((StringBuilder)localObject1).append(this.f);
          ((StringBuilder)localObject1).append(" file:");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_d_of_type_Int = 7;
        StoryReportor.a("actVideo2VideoResult", new String[] { "7" });
        FileUtils.g(this.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, taskid:");
        ((StringBuilder)localObject1).append(this.f);
        ((StringBuilder)localObject1).append(" run:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject1).append(" cost:");
        ((StringBuilder)localObject1).append(l2 - l1);
        ((StringBuilder)localObject1).append(" ms successVideo:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +60 -> 63
    //   6: new 163	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: ldc_w 409
    //   20: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 7
    //   26: aload_0
    //   27: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   30: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 175
    //   38: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 7
    //   44: aload_0
    //   45: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   48: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 180
    //   54: iconst_2
    //   55: aload 7
    //   57: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   67: ifeq +31 -> 98
    //   70: ldc_w 411
    //   73: iconst_1
    //   74: anewarray 253	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc 255
    //   81: aastore
    //   82: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   85: aload_0
    //   86: bipush 9
    //   88: aload_0
    //   89: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: aconst_null
    //   93: aconst_null
    //   94: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   97: return
    //   98: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   101: lstore_2
    //   102: new 413	java/io/FileInputStream
    //   105: dup
    //   106: aload_0
    //   107: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: invokespecial 414	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   113: astore 7
    //   115: new 416	java/io/BufferedInputStream
    //   118: dup
    //   119: aload 7
    //   121: ldc_w 417
    //   124: invokespecial 420	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   127: astore 8
    //   129: aload 8
    //   131: astore 9
    //   133: aload 7
    //   135: astore 11
    //   137: aload_0
    //   138: aload 8
    //   140: aconst_null
    //   141: aload_0
    //   142: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   145: aload_0
    //   146: getfield 57	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   149: invokestatic 425	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   152: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   155: aload 8
    //   157: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   160: aload 7
    //   162: invokevirtual 431	java/io/FileInputStream:close	()V
    //   165: goto +79 -> 244
    //   168: astore 10
    //   170: goto +40 -> 210
    //   173: astore 8
    //   175: aconst_null
    //   176: astore 9
    //   178: goto +367 -> 545
    //   181: astore 10
    //   183: aconst_null
    //   184: astore 8
    //   186: goto +24 -> 210
    //   189: astore 8
    //   191: aconst_null
    //   192: astore 9
    //   194: aload 9
    //   196: astore 7
    //   198: goto +347 -> 545
    //   201: astore 10
    //   203: aconst_null
    //   204: astore 8
    //   206: aload 8
    //   208: astore 7
    //   210: aload 8
    //   212: astore 9
    //   214: aload 7
    //   216: astore 11
    //   218: aload 10
    //   220: invokevirtual 434	java/lang/Exception:printStackTrace	()V
    //   223: aload 8
    //   225: ifnull +11 -> 236
    //   228: aload 8
    //   230: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   233: goto +3 -> 236
    //   236: aload 7
    //   238: ifnull +6 -> 244
    //   241: goto -81 -> 160
    //   244: aload_0
    //   245: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   248: ifnonnull +22 -> 270
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   260: aload_0
    //   261: getfield 57	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   264: invokestatic 437	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   267: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   270: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   273: lstore 4
    //   275: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +70 -> 348
    //   281: new 163	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   288: astore 7
    //   290: aload 7
    //   292: ldc_w 439
    //   295: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: aload_0
    //   302: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   305: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 7
    //   311: ldc_w 441
    //   314: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 7
    //   320: lload 4
    //   322: lload_2
    //   323: lsub
    //   324: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 7
    //   330: ldc_w 443
    //   333: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: ldc 180
    //   339: iconst_2
    //   340: aload 7
    //   342: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload_0
    //   349: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   352: ifnonnull +36 -> 388
    //   355: aload_0
    //   356: iconst_0
    //   357: putfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   360: ldc_w 411
    //   363: iconst_1
    //   364: anewarray 253	java/lang/String
    //   367: dup
    //   368: iconst_0
    //   369: ldc_w 445
    //   372: aastore
    //   373: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   376: aload_0
    //   377: iconst_5
    //   378: aload_0
    //   379: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   382: aconst_null
    //   383: aconst_null
    //   384: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   387: return
    //   388: aload_0
    //   389: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   392: invokestatic 450	com/tencent/mobileqq/utils/ImageUtil:c	(Ljava/lang/String;)I
    //   395: istore_1
    //   396: iload_1
    //   397: ifeq +88 -> 485
    //   400: iload_1
    //   401: bipush 90
    //   403: irem
    //   404: ifne +81 -> 485
    //   407: new 214	android/graphics/Matrix
    //   410: dup
    //   411: invokespecial 215	android/graphics/Matrix:<init>	()V
    //   414: astore 7
    //   416: aload 7
    //   418: iload_1
    //   419: i2f
    //   420: aload_0
    //   421: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   424: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   427: i2f
    //   428: fconst_2
    //   429: fdiv
    //   430: aload_0
    //   431: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   434: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   437: i2f
    //   438: fconst_2
    //   439: fdiv
    //   440: invokevirtual 454	android/graphics/Matrix:postRotate	(FFF)Z
    //   443: pop
    //   444: aload_0
    //   445: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_0
    //   451: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   454: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   457: aload_0
    //   458: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   461: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   464: aload 7
    //   466: iconst_1
    //   467: invokestatic 457	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   470: astore 7
    //   472: aload_0
    //   473: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   476: invokevirtual 460	android/graphics/Bitmap:recycle	()V
    //   479: aload_0
    //   480: aload 7
    //   482: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   485: aload_0
    //   486: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   489: ifeq +143 -> 632
    //   492: aload_0
    //   493: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   496: ifnull +15 -> 511
    //   499: aload_0
    //   500: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   503: invokevirtual 460	android/graphics/Bitmap:recycle	()V
    //   506: aload_0
    //   507: aconst_null
    //   508: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   511: ldc_w 411
    //   514: iconst_1
    //   515: anewarray 253	java/lang/String
    //   518: dup
    //   519: iconst_0
    //   520: ldc 255
    //   522: aastore
    //   523: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   526: aload_0
    //   527: bipush 9
    //   529: aload_0
    //   530: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   533: aconst_null
    //   534: aconst_null
    //   535: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   538: return
    //   539: astore 8
    //   541: aload 11
    //   543: astore 7
    //   545: aload 9
    //   547: ifnull +14 -> 561
    //   550: aload 9
    //   552: invokevirtual 430	java/io/BufferedInputStream:close	()V
    //   555: goto +6 -> 561
    //   558: goto +16 -> 574
    //   561: aload 7
    //   563: ifnull +8 -> 571
    //   566: aload 7
    //   568: invokevirtual 431	java/io/FileInputStream:close	()V
    //   571: aload 8
    //   573: athrow
    //   574: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +42 -> 619
    //   580: new 163	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   587: astore 7
    //   589: aload 7
    //   591: ldc_w 462
    //   594: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 7
    //   600: aload_0
    //   601: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   604: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: ldc 180
    //   610: iconst_2
    //   611: aload 7
    //   613: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload_0
    //   620: aconst_null
    //   621: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   624: goto +8 -> 632
    //   627: aload_0
    //   628: aconst_null
    //   629: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   632: aload_0
    //   633: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   636: ifnonnull +36 -> 672
    //   639: aload_0
    //   640: iconst_0
    //   641: putfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   644: ldc_w 411
    //   647: iconst_1
    //   648: anewarray 253	java/lang/String
    //   651: dup
    //   652: iconst_0
    //   653: ldc_w 445
    //   656: aastore
    //   657: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   660: aload_0
    //   661: iconst_5
    //   662: aload_0
    //   663: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   666: aconst_null
    //   667: aconst_null
    //   668: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   671: return
    //   672: new 264	java/io/File
    //   675: dup
    //   676: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   679: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   682: astore 7
    //   684: aload 7
    //   686: invokevirtual 271	java/io/File:exists	()Z
    //   689: ifne +53 -> 742
    //   692: aload 7
    //   694: invokevirtual 274	java/io/File:mkdirs	()Z
    //   697: istore 6
    //   699: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +40 -> 742
    //   705: new 163	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   712: astore 7
    //   714: aload 7
    //   716: ldc_w 464
    //   719: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 7
    //   725: iload 6
    //   727: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: ldc 180
    //   733: iconst_2
    //   734: aload 7
    //   736: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: new 264	java/io/File
    //   745: dup
    //   746: aload_0
    //   747: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   750: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   753: invokevirtual 279	java/io/File:getName	()Ljava/lang/String;
    //   756: astore 8
    //   758: aload 8
    //   760: astore 7
    //   762: aload 8
    //   764: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   767: ifne +49 -> 816
    //   770: aload 8
    //   772: ldc_w 287
    //   775: ldc_w 289
    //   778: invokevirtual 293	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   781: astore 7
    //   783: new 163	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   790: astore 8
    //   792: aload 8
    //   794: aload 7
    //   796: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 8
    //   802: ldc_w 295
    //   805: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload 8
    //   811: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: astore 7
    //   816: new 163	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   823: astore 8
    //   825: aload 8
    //   827: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   830: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 8
    //   836: aload 7
    //   838: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload_0
    //   843: aload 8
    //   845: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: putfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   851: new 163	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   858: astore 8
    //   860: aload 8
    //   862: aload_0
    //   863: getfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   866: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 8
    //   872: ldc_w 466
    //   875: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 8
    //   881: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   884: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload_0
    //   889: aload 8
    //   891: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: putfield 468	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   897: aload_0
    //   898: getfield 468	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   901: invokestatic 302	com/tencent/biz/qqstory/utils/FileUtils:g	(Ljava/lang/String;)Z
    //   904: pop
    //   905: aload_0
    //   906: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   909: lstore 4
    //   911: lload 4
    //   913: l2i
    //   914: istore_1
    //   915: aload_0
    //   916: lconst_0
    //   917: putfield 33	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:e	J
    //   920: aload_0
    //   921: lload 4
    //   923: ldc2_w 469
    //   926: lmul
    //   927: putfield 59	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   930: aload_0
    //   931: aload_0
    //   932: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   935: ldc2_w 471
    //   938: ldiv
    //   939: putfield 59	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   942: aload_0
    //   943: invokespecial 249	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   946: ifeq +52 -> 998
    //   949: aload_0
    //   950: getfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   953: astore 7
    //   955: aload 7
    //   957: ifnull +13 -> 970
    //   960: aload 7
    //   962: invokevirtual 460	android/graphics/Bitmap:recycle	()V
    //   965: aload_0
    //   966: aconst_null
    //   967: putfield 427	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   970: ldc_w 411
    //   973: iconst_1
    //   974: anewarray 253	java/lang/String
    //   977: dup
    //   978: iconst_0
    //   979: ldc 255
    //   981: aastore
    //   982: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   985: aload_0
    //   986: bipush 9
    //   988: aload_0
    //   989: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   992: aconst_null
    //   993: aconst_null
    //   994: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   997: return
    //   998: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   1001: lstore 4
    //   1003: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1006: ifeq +70 -> 1076
    //   1009: new 163	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1016: astore 8
    //   1018: aload 8
    //   1020: ldc_w 474
    //   1023: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload 8
    //   1029: aload_0
    //   1030: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1033: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload 8
    //   1039: ldc_w 476
    //   1042: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 8
    //   1048: lload 4
    //   1050: lload_2
    //   1051: lsub
    //   1052: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 8
    //   1058: ldc_w 443
    //   1061: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: ldc 180
    //   1067: iconst_2
    //   1068: aload 8
    //   1070: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   1079: lstore_2
    //   1080: new 163	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1087: astore 8
    //   1089: aload 8
    //   1091: getstatic 265	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1094: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 8
    //   1100: aload 7
    //   1102: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload 8
    //   1108: ldc_w 304
    //   1111: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload 8
    //   1117: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: astore 7
    //   1122: aload 7
    //   1124: invokestatic 306	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1127: ifeq +9 -> 1136
    //   1130: aload 7
    //   1132: invokestatic 478	com/tencent/biz/qqstory/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   1135: pop
    //   1136: aload 7
    //   1138: iload_1
    //   1139: bipush 42
    //   1141: iadd
    //   1142: bipush 15
    //   1144: iadd
    //   1145: invokestatic 366	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Ljava/lang/String;I)V
    //   1148: aload 7
    //   1150: invokestatic 306	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1153: ifne +94 -> 1247
    //   1156: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1159: ifeq +59 -> 1218
    //   1162: new 163	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1169: astore 8
    //   1171: aload 8
    //   1173: ldc_w 480
    //   1176: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: pop
    //   1180: aload 8
    //   1182: aload_0
    //   1183: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1186: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload 8
    //   1192: ldc_w 359
    //   1195: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 8
    //   1201: aload 7
    //   1203: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: ldc 180
    //   1209: iconst_2
    //   1210: aload 8
    //   1212: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: ldc_w 411
    //   1221: iconst_1
    //   1222: anewarray 253	java/lang/String
    //   1225: dup
    //   1226: iconst_0
    //   1227: ldc_w 363
    //   1230: aastore
    //   1231: invokestatic 260	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1234: aload_0
    //   1235: bipush 8
    //   1237: aload_0
    //   1238: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1241: aconst_null
    //   1242: aconst_null
    //   1243: invokespecial 262	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1246: return
    //   1247: aload_0
    //   1248: aload 7
    //   1250: putfield 147	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1253: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   1256: lstore 4
    //   1258: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1261: ifeq +70 -> 1331
    //   1264: new 163	java/lang/StringBuilder
    //   1267: dup
    //   1268: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1271: astore 7
    //   1273: aload 7
    //   1275: ldc_w 482
    //   1278: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload 7
    //   1284: aload_0
    //   1285: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1288: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload 7
    //   1294: ldc_w 484
    //   1297: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: aload 7
    //   1303: lload 4
    //   1305: lload_2
    //   1306: lsub
    //   1307: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: aload 7
    //   1313: ldc_w 443
    //   1316: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: ldc 180
    //   1322: iconst_2
    //   1323: aload 7
    //   1325: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1331: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   1334: lstore_2
    //   1335: aload_0
    //   1336: new 240	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder
    //   1339: dup
    //   1340: invokespecial 485	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:<init>	()V
    //   1343: putfield 238	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1346: new 487	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   1349: dup
    //   1350: aload_0
    //   1351: getfield 468	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1354: aload_0
    //   1355: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   1358: aload_0
    //   1359: getfield 57	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   1362: invokestatic 492	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	()Lcom/tencent/mobileqq/richmedia/capture/util/SVParamManager;
    //   1365: iconst_1
    //   1366: invokevirtual 494	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	(I)I
    //   1369: sipush 1000
    //   1372: imul
    //   1373: iconst_1
    //   1374: iconst_0
    //   1375: iconst_0
    //   1376: invokespecial 497	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   1379: astore 7
    //   1381: aload 7
    //   1383: invokestatic 503	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1386: invokevirtual 506	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:a	(Landroid/opengl/EGLContext;)V
    //   1389: aload_0
    //   1390: getfield 238	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1393: aload 7
    //   1395: aload_0
    //   1396: invokevirtual 509	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:a	(Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;)V
    //   1399: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   1402: lstore 4
    //   1404: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +70 -> 1477
    //   1410: new 163	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1417: astore 7
    //   1419: aload 7
    //   1421: ldc_w 511
    //   1424: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload 7
    //   1430: aload_0
    //   1431: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1434: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload 7
    //   1440: ldc_w 513
    //   1443: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: aload 7
    //   1449: lload 4
    //   1451: lload_2
    //   1452: lsub
    //   1453: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 7
    //   1459: ldc_w 443
    //   1462: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: ldc 180
    //   1468: iconst_2
    //   1469: aload 7
    //   1471: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1477: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1480: ifeq +42 -> 1522
    //   1483: new 163	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1490: astore 7
    //   1492: aload 7
    //   1494: ldc_w 515
    //   1497: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: aload 7
    //   1503: aload_0
    //   1504: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1507: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1510: pop
    //   1511: ldc 180
    //   1513: iconst_2
    //   1514: aload 7
    //   1516: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1519: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1522: return
    //   1523: astore 8
    //   1525: goto -1365 -> 160
    //   1528: astore 7
    //   1530: goto -972 -> 558
    //   1533: astore 7
    //   1535: goto -1291 -> 244
    //   1538: astore 8
    //   1540: goto -1304 -> 236
    //   1543: astore 7
    //   1545: goto -918 -> 627
    //   1548: astore 9
    //   1550: goto -989 -> 561
    //   1553: astore 7
    //   1555: goto -984 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1558	0	this	ConvertRunnable
    //   395	747	1	i	int
    //   101	1351	2	l1	long
    //   273	1177	4	l2	long
    //   697	29	6	bool	boolean
    //   13	1502	7	localObject1	Object
    //   1528	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1533	1	7	localException1	java.lang.Exception
    //   1543	1	7	localException2	java.lang.Exception
    //   1553	1	7	localException3	java.lang.Exception
    //   127	29	8	localBufferedInputStream	java.io.BufferedInputStream
    //   173	1	8	localObject2	Object
    //   184	1	8	localObject3	Object
    //   189	1	8	localObject4	Object
    //   204	25	8	localObject5	Object
    //   539	33	8	localObject6	Object
    //   756	455	8	localObject7	Object
    //   1523	1	8	localException4	java.lang.Exception
    //   1538	1	8	localException5	java.lang.Exception
    //   131	420	9	localObject8	Object
    //   1548	1	9	localException6	java.lang.Exception
    //   168	1	10	localException7	java.lang.Exception
    //   181	1	10	localException8	java.lang.Exception
    //   201	18	10	localException9	java.lang.Exception
    //   135	407	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   137	155	168	java/lang/Exception
    //   115	129	173	finally
    //   115	129	181	java/lang/Exception
    //   102	115	189	finally
    //   102	115	201	java/lang/Exception
    //   137	155	539	finally
    //   218	223	539	finally
    //   155	160	1523	java/lang/Exception
    //   155	160	1528	java/lang/OutOfMemoryError
    //   160	165	1528	java/lang/OutOfMemoryError
    //   228	233	1528	java/lang/OutOfMemoryError
    //   244	270	1528	java/lang/OutOfMemoryError
    //   270	348	1528	java/lang/OutOfMemoryError
    //   348	387	1528	java/lang/OutOfMemoryError
    //   388	396	1528	java/lang/OutOfMemoryError
    //   407	485	1528	java/lang/OutOfMemoryError
    //   485	511	1528	java/lang/OutOfMemoryError
    //   511	538	1528	java/lang/OutOfMemoryError
    //   550	555	1528	java/lang/OutOfMemoryError
    //   566	571	1528	java/lang/OutOfMemoryError
    //   571	574	1528	java/lang/OutOfMemoryError
    //   160	165	1533	java/lang/Exception
    //   228	233	1538	java/lang/Exception
    //   244	270	1543	java/lang/Exception
    //   270	348	1543	java/lang/Exception
    //   348	387	1543	java/lang/Exception
    //   388	396	1543	java/lang/Exception
    //   407	485	1543	java/lang/Exception
    //   485	511	1543	java/lang/Exception
    //   511	538	1543	java/lang/Exception
    //   571	574	1543	java/lang/Exception
    //   550	555	1548	java/lang/Exception
    //   566	571	1553	java/lang/Exception
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("onEncodeError, code:");
      paramThrowable.append(paramInt);
      paramThrowable.append(" taskID:");
      paramThrowable.append(this.f);
      paramThrowable.append(" run:");
      paramThrowable.append(this.jdField_a_of_type_Boolean);
      QLog.e("ConvertRunnable", 2, paramThrowable.toString());
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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEncodeFinish, taskid:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" run:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" finish cost: ");
      localStringBuilder.append(l1 - this.jdField_a_of_type_Long);
      localStringBuilder.append(" ms");
      QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFinish, delete old:");
        localStringBuilder.append(this.f);
        localStringBuilder.append(" file:");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
      }
      FileUtils.g(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFinish, rename start:");
        localStringBuilder.append(this.f);
        localStringBuilder.append(" file:");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("ConvertRunnable", 2, localStringBuilder.toString());
      }
      if (FileUtils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
        this.jdField_d_of_type_Int = 0;
      } else {
        this.jdField_d_of_type_Int = 7;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onEncodeFinish, rename end:");
        paramString.append(this.f);
        paramString.append(" file:");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        paramString.append(" result:");
        paramString.append(this.jdField_d_of_type_Int);
        QLog.d("ConvertRunnable", 2, paramString.toString());
      }
      if (FileUtil.b(this.jdField_b_of_type_JavaLangString))
      {
        l1 = FileUtil.a(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onEncodeFinish, file exist, size:");
          paramString.append(l1);
          paramString.append(" file:");
          paramString.append(this.jdField_b_of_type_JavaLangString);
          QLog.d("ConvertRunnable", 2, paramString.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onEncodeFinish, file not exist:");
        paramString.append(this.f);
        paramString.append(" file:");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("ConvertRunnable", 2, paramString.toString());
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a();
      l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("");
      StoryReportor.a("actImage2VideoTime", new String[] { localStringBuilder.toString() });
      StoryReportor.a("actImage2VideoResult", new String[] { "0" });
      a(this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
    }
    else
    {
      StoryReportor.a("actImage2VideoResult", new String[] { "3" });
      FileUtils.g(paramString);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (paramString != null)
    {
      paramString.surfaceDestroyed();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
    if (paramString != null)
    {
      paramString.c();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = null;
    }
  }
  
  public void onEncodeFrame()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeFrame, mRun is false, tasid.");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
      if (localObject != null) {
        ((HWVideoRecorder)localObject).b();
      }
      return;
    }
    if (!b())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
      if (localObject != null) {
        ((HWVideoRecorder)localObject).b();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeFrame, stop recoder, taskid:");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Int = b(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      } else {
        this.jdField_c_of_type_Int = a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject != null)
      {
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" run:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject).append(" preProcess cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms mGpuBlur:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d("ConvertRunnable", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      b();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
    if (localObject != null) {
      ((HWVideoRecorder)localObject).b();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */