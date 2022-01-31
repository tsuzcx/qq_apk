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
import apdh;
import auzr;
import auzt;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import urp;
import vgo;
import vgv;
import vho;
import vlj;
import vlm;

public class ConvertRunnable
  implements auzr, Runnable
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private auzt jdField_a_of_type_Auzt;
  private SlideItemInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<vgo> jdField_a_of_type_JavaLangRefWeakReference;
  vho jdField_a_of_type_Vho;
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
  
  public ConvertRunnable(Context paramContext, long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, vgo paramvgo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvgo);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = true;
    this.f = paramLong1;
    this.jdField_a_of_type_Vho = null;
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
      vgo localvgo = (vgo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localvgo != null)
      {
        vgv localvgv = new vgv();
        localvgv.jdField_a_of_type_Long = this.f;
        localvgv.jdField_a_of_type_Int = paramInt;
        localvgv.jdField_b_of_type_JavaLangString = paramString2;
        localvgv.jdField_a_of_type_JavaLangString = paramString1;
        localvgv.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        localvgv.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        localvgv.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean;
        localvgv.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int;
        localvgo.a(localvgv);
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
    if ((this.jdField_a_of_type_Auzt != null) && (this.jdField_c_of_type_Int > 0) && (this.e < this.jdField_d_of_type_Long))
    {
      this.jdField_a_of_type_Auzt.a(3553, this.jdField_c_of_type_Int, null, null, this.e);
      this.e += 42000000L;
      return true;
    }
    return false;
  }
  
  public void a()
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
    } while (this.jdField_a_of_type_Auzt == null);
    this.jdField_a_of_type_Auzt.b();
  }
  
  public void a(String paramString)
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
      vlm.g(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename start:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      if (vlm.a(paramString, this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_d_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename end:" + this.f + " file:" + this.jdField_b_of_type_JavaLangString + " result:" + this.jdField_d_of_type_Int);
        }
        if (!apdh.a(this.jdField_b_of_type_JavaLangString)) {
          break label458;
        }
        l1 = apdh.a(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_b_of_type_JavaLangString);
        }
        label323:
        paramString = this.jdField_a_of_type_Auzt.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_b_of_type_Long;
        urp.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        urp.a("actImage2VideoResult", new String[] { "0" });
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
      if (this.jdField_a_of_type_Auzt != null)
      {
        this.jdField_a_of_type_Auzt.c();
        this.jdField_a_of_type_Auzt = null;
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
      urp.a("actImage2VideoResult", new String[] { "3" });
      vlm.g(paramString);
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
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
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFrame, mRun is false, tasid." + this.f);
      }
      if (this.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Auzt.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (b());
      if (this.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Auzt.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConvertRunnable", 2, "onEncodeFrame, stop recoder, taskid:" + this.f);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "[runLocalVideo2Video]run begin, taskid:" + this.f + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (a())
    {
      urp.a("actVideo2VideoResult", new String[] { "9" });
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
    vlm.g(this.jdField_b_of_type_JavaLangString);
    localObject1 = this.jdField_b_of_type_JavaLangString + ".dat";
    if (vlm.e((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "before,getPCMFromFile[Have audio File]:  " + this.f + " audioPath: " + (String)localObject1 + " audioFileSize=" + apdh.a((String)localObject1));
      }
      localObject3 = new vlj();
      l1 = System.currentTimeMillis();
      ((vlj)localObject3).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
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
      urp.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
      localObject3 = new vlj();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mDuration = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long;
      l1 = System.currentTimeMillis();
      bool = ((vlj)localObject3).a(localLocalMediaInfo, 0, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long, (String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run,getPCMFromFile:  " + this.f + " cost=" + (l2 - l1) + " ms audioTrack: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean)
      {
        if ((!bool) || (!vlm.e((String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run,getPCMFromFile: failed " + this.f + " path=" + (String)localObject1 + " success=" + bool);
          }
          vlm.g((String)localObject1);
          urp.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
        }
      }
      else
      {
        vlm.g((String)localObject1);
        vlj.a((String)localObject1, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long);
        if (!vlm.e((String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run[video convert],createSilentPCMFile: failed " + this.f + " path=" + (String)localObject1);
          }
          urp.a("actVideo2VideoResult", new String[] { "8" });
          a(8, this.jdField_a_of_type_JavaLangString, null, null);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "After,getPCMFromFile: hasAudioTrack= " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean + " path=" + (String)localObject1 + " success=" + bool + " audioFileSize=" + apdh.a((String)localObject1));
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Vho = new vho();
      if (a())
      {
        urp.a("actVideo2VideoResult", new String[] { "9" });
        a(9, this.jdField_a_of_type_JavaLangString, null, null);
        return;
      }
    }
    finally {}
    long l1 = System.currentTimeMillis();
    boolean bool = this.jdField_a_of_type_Vho.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
    long l2 = System.currentTimeMillis();
    if (a())
    {
      urp.a("actVideo2VideoResult", new String[] { "9" });
      a(9, this.jdField_a_of_type_JavaLangString, null, null);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_c_of_type_Long;
    urp.a("actVideo2VideoTime", new String[] { l3 - l4 + "" });
    if ((bool) && (apdh.a(this.jdField_b_of_type_JavaLangString)))
    {
      l3 = apdh.a(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, file exist, size:" + l3 + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_Int = 0;
      urp.a("actVideo2VideoResult", new String[] { "0" });
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
      urp.a("actVideo2VideoResult", new String[] { "7" });
      vlm.g(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +44 -> 47
    //   6: ldc 161
    //   8: iconst_2
    //   9: new 163	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 478
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
    //   48: invokespecial 359	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   51: ifeq +32 -> 83
    //   54: ldc_w 330
    //   57: iconst_1
    //   58: anewarray 321	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 363
    //   66: aastore
    //   67: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   70: aload_0
    //   71: bipush 9
    //   73: aload_0
    //   74: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   82: return
    //   83: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   86: lstore_2
    //   87: new 480	java/io/FileInputStream
    //   90: dup
    //   91: aload_0
    //   92: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: invokespecial 481	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   98: astore 9
    //   100: new 483	java/io/BufferedInputStream
    //   103: dup
    //   104: aload 9
    //   106: ldc_w 484
    //   109: invokespecial 487	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   112: astore 8
    //   114: aload_0
    //   115: aload 8
    //   117: aconst_null
    //   118: aload_0
    //   119: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   122: aload_0
    //   123: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   126: invokestatic 492	azvq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   129: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   132: aload 8
    //   134: ifnull +8 -> 142
    //   137: aload 8
    //   139: invokevirtual 495	java/io/BufferedInputStream:close	()V
    //   142: aload 9
    //   144: ifnull +8 -> 152
    //   147: aload 9
    //   149: invokevirtual 496	java/io/FileInputStream:close	()V
    //   152: aload_0
    //   153: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   156: ifnonnull +22 -> 178
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   168: aload_0
    //   169: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   172: invokestatic 499	azvq:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   175: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   178: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   181: lstore 4
    //   183: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +51 -> 237
    //   189: ldc 161
    //   191: iconst_2
    //   192: new 163	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 501
    //   202: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   209: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 503
    //   215: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 4
    //   220: lload_2
    //   221: lsub
    //   222: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc_w 278
    //   228: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_0
    //   238: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   241: ifnonnull +200 -> 441
    //   244: aload_0
    //   245: iconst_0
    //   246: putfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   249: ldc_w 330
    //   252: iconst_1
    //   253: anewarray 321	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: ldc_w 505
    //   261: aastore
    //   262: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   265: aload_0
    //   266: iconst_5
    //   267: aload_0
    //   268: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   271: aconst_null
    //   272: aconst_null
    //   273: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   276: return
    //   277: astore 7
    //   279: aload_0
    //   280: aconst_null
    //   281: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   284: aload_0
    //   285: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   288: ifnonnull +305 -> 593
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Boolean	Z
    //   296: ldc_w 330
    //   299: iconst_1
    //   300: anewarray 321	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: ldc_w 505
    //   308: aastore
    //   309: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   312: aload_0
    //   313: iconst_5
    //   314: aload_0
    //   315: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   318: aconst_null
    //   319: aconst_null
    //   320: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   323: return
    //   324: astore 9
    //   326: aconst_null
    //   327: astore 7
    //   329: aconst_null
    //   330: astore 8
    //   332: aload 9
    //   334: invokevirtual 508	java/lang/Exception:printStackTrace	()V
    //   337: aload 8
    //   339: ifnull +8 -> 347
    //   342: aload 8
    //   344: invokevirtual 495	java/io/BufferedInputStream:close	()V
    //   347: aload 7
    //   349: ifnull -197 -> 152
    //   352: aload 7
    //   354: invokevirtual 496	java/io/FileInputStream:close	()V
    //   357: goto -205 -> 152
    //   360: astore 7
    //   362: goto -210 -> 152
    //   365: astore 7
    //   367: aconst_null
    //   368: astore 9
    //   370: aconst_null
    //   371: astore 8
    //   373: aload 8
    //   375: ifnull +8 -> 383
    //   378: aload 8
    //   380: invokevirtual 495	java/io/BufferedInputStream:close	()V
    //   383: aload 9
    //   385: ifnull +8 -> 393
    //   388: aload 9
    //   390: invokevirtual 496	java/io/FileInputStream:close	()V
    //   393: aload 7
    //   395: athrow
    //   396: astore 7
    //   398: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +32 -> 433
    //   404: ldc 161
    //   406: iconst_2
    //   407: new 163	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 510
    //   417: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   424: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_0
    //   434: aconst_null
    //   435: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   438: goto -154 -> 284
    //   441: aload_0
    //   442: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   445: invokestatic 515	bacm:b	(Ljava/lang/String;)I
    //   448: istore_1
    //   449: iload_1
    //   450: ifeq +88 -> 538
    //   453: iload_1
    //   454: bipush 90
    //   456: irem
    //   457: ifne +81 -> 538
    //   460: new 212	android/graphics/Matrix
    //   463: dup
    //   464: invokespecial 213	android/graphics/Matrix:<init>	()V
    //   467: astore 7
    //   469: aload 7
    //   471: iload_1
    //   472: i2f
    //   473: aload_0
    //   474: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   477: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   480: i2f
    //   481: fconst_2
    //   482: fdiv
    //   483: aload_0
    //   484: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   487: invokevirtual 114	android/graphics/Bitmap:getHeight	()I
    //   490: i2f
    //   491: fconst_2
    //   492: fdiv
    //   493: invokevirtual 519	android/graphics/Matrix:postRotate	(FFF)Z
    //   496: pop
    //   497: aload_0
    //   498: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   501: iconst_0
    //   502: iconst_0
    //   503: aload_0
    //   504: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   507: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   510: aload_0
    //   511: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   514: invokevirtual 114	android/graphics/Bitmap:getHeight	()I
    //   517: aload 7
    //   519: iconst_1
    //   520: invokestatic 522	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   523: astore 7
    //   525: aload_0
    //   526: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   529: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   532: aload_0
    //   533: aload 7
    //   535: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   538: aload_0
    //   539: invokespecial 359	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   542: ifeq -258 -> 284
    //   545: aload_0
    //   546: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   549: ifnull +15 -> 564
    //   552: aload_0
    //   553: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   556: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   559: aload_0
    //   560: aconst_null
    //   561: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   564: ldc_w 330
    //   567: iconst_1
    //   568: anewarray 321	java/lang/String
    //   571: dup
    //   572: iconst_0
    //   573: ldc_w 363
    //   576: aastore
    //   577: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   580: aload_0
    //   581: bipush 9
    //   583: aload_0
    //   584: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   587: aconst_null
    //   588: aconst_null
    //   589: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   592: return
    //   593: new 365	java/io/File
    //   596: dup
    //   597: getstatic 366	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   600: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: astore 7
    //   605: aload 7
    //   607: invokevirtual 371	java/io/File:exists	()Z
    //   610: ifne +43 -> 653
    //   613: aload 7
    //   615: invokevirtual 374	java/io/File:mkdirs	()Z
    //   618: istore 6
    //   620: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +30 -> 653
    //   626: ldc 161
    //   628: iconst_2
    //   629: new 163	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 524
    //   639: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: iload 6
    //   644: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   647: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aconst_null
    //   654: astore 7
    //   656: new 365	java/io/File
    //   659: dup
    //   660: aload_0
    //   661: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   664: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   667: astore 8
    //   669: aload 8
    //   671: ifnull +58 -> 729
    //   674: aload 8
    //   676: invokevirtual 379	java/io/File:getName	()Ljava/lang/String;
    //   679: astore 8
    //   681: aload 8
    //   683: astore 7
    //   685: aload 8
    //   687: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   690: ifne +39 -> 729
    //   693: aload 8
    //   695: ldc_w 387
    //   698: ldc_w 389
    //   701: invokevirtual 393	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   704: astore 7
    //   706: new 163	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   713: aload 7
    //   715: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc_w 395
    //   721: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: astore 7
    //   729: aload_0
    //   730: new 163	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   737: getstatic 366	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   740: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 7
    //   745: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: putfield 283	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   754: aload_0
    //   755: new 163	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   762: aload_0
    //   763: getfield 283	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   766: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 526
    //   772: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   778: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   781: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: putfield 528	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   787: aload_0
    //   788: getfield 528	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   791: invokestatic 289	vlm:g	(Ljava/lang/String;)Z
    //   794: pop
    //   795: aload_0
    //   796: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   799: l2i
    //   800: istore_1
    //   801: aload_0
    //   802: lconst_0
    //   803: putfield 238	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:e	J
    //   806: aload_0
    //   807: ldc2_w 529
    //   810: aload_0
    //   811: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   814: lmul
    //   815: putfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   823: ldc2_w 531
    //   826: ldiv
    //   827: putfield 55	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_Long	J
    //   830: aload_0
    //   831: invokespecial 359	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	()Z
    //   834: ifeq +51 -> 885
    //   837: aload_0
    //   838: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   841: ifnull +15 -> 856
    //   844: aload_0
    //   845: getfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   848: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   851: aload_0
    //   852: aconst_null
    //   853: putfield 255	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   856: ldc_w 330
    //   859: iconst_1
    //   860: anewarray 321	java/lang/String
    //   863: dup
    //   864: iconst_0
    //   865: ldc_w 363
    //   868: aastore
    //   869: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   872: aload_0
    //   873: bipush 9
    //   875: aload_0
    //   876: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   879: aconst_null
    //   880: aconst_null
    //   881: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   884: return
    //   885: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   888: lstore 4
    //   890: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq +51 -> 944
    //   896: ldc 161
    //   898: iconst_2
    //   899: new 163	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 534
    //   909: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_0
    //   913: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   916: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   919: ldc_w 536
    //   922: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: lload 4
    //   927: lload_2
    //   928: lsub
    //   929: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   932: ldc_w 278
    //   935: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   947: lstore_2
    //   948: new 163	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   955: getstatic 366	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   958: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload 7
    //   963: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: ldc_w 397
    //   969: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: astore 7
    //   977: aload 7
    //   979: invokestatic 399	vlm:e	(Ljava/lang/String;)Z
    //   982: ifeq +9 -> 991
    //   985: aload 7
    //   987: invokestatic 538	vlm:f	(Ljava/lang/String;)Z
    //   990: pop
    //   991: aload 7
    //   993: iload_1
    //   994: bipush 42
    //   996: iadd
    //   997: bipush 15
    //   999: iadd
    //   1000: invokestatic 445	vlj:a	(Ljava/lang/String;I)V
    //   1003: aload 7
    //   1005: invokestatic 399	vlm:e	(Ljava/lang/String;)Z
    //   1008: ifne +78 -> 1086
    //   1011: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq +43 -> 1057
    //   1017: ldc 161
    //   1019: iconst_2
    //   1020: new 163	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1027: ldc_w 540
    //   1030: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: aload_0
    //   1034: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1037: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1040: ldc_w 438
    //   1043: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 7
    //   1048: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: ldc_w 330
    //   1060: iconst_1
    //   1061: anewarray 321	java/lang/String
    //   1064: dup
    //   1065: iconst_0
    //   1066: ldc_w 442
    //   1069: aastore
    //   1070: invokestatic 328	urp:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1073: aload_0
    //   1074: bipush 8
    //   1076: aload_0
    //   1077: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1080: aconst_null
    //   1081: aconst_null
    //   1082: invokespecial 334	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1085: return
    //   1086: aload_0
    //   1087: aload 7
    //   1089: putfield 145	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1092: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   1095: lstore 4
    //   1097: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1100: ifeq +51 -> 1151
    //   1103: ldc 161
    //   1105: iconst_2
    //   1106: new 163	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 542
    //   1116: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_0
    //   1120: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1123: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1126: ldc_w 544
    //   1129: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: lload 4
    //   1134: lload_2
    //   1135: lsub
    //   1136: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1139: ldc_w 278
    //   1142: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1151: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   1154: lstore_2
    //   1155: aload_0
    //   1156: new 240	auzt
    //   1159: dup
    //   1160: invokespecial 545	auzt:<init>	()V
    //   1163: putfield 236	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Auzt	Lauzt;
    //   1166: new 547	auzf
    //   1169: dup
    //   1170: aload_0
    //   1171: getfield 528	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1174: aload_0
    //   1175: getfield 51	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Int	I
    //   1178: aload_0
    //   1179: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_b_of_type_Int	I
    //   1182: invokestatic 552	auuf:a	()Lauuf;
    //   1185: iconst_1
    //   1186: invokevirtual 554	auuf:a	(I)I
    //   1189: sipush 1000
    //   1192: imul
    //   1193: iconst_1
    //   1194: iconst_0
    //   1195: iconst_0
    //   1196: invokespecial 557	auzf:<init>	(Ljava/lang/String;IIIIZI)V
    //   1199: astore 7
    //   1201: aload 7
    //   1203: invokestatic 563	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1206: invokevirtual 566	auzf:a	(Landroid/opengl/EGLContext;)V
    //   1209: aload_0
    //   1210: getfield 236	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Auzt	Lauzt;
    //   1213: aload 7
    //   1215: aload_0
    //   1216: invokevirtual 569	auzt:a	(Lauzf;Lauzr;)V
    //   1219: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   1222: lstore 4
    //   1224: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1227: ifeq +51 -> 1278
    //   1230: ldc 161
    //   1232: iconst_2
    //   1233: new 163	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 571
    //   1243: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload_0
    //   1247: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1250: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1253: ldc_w 573
    //   1256: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: lload 4
    //   1261: lload_2
    //   1262: lsub
    //   1263: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1266: ldc_w 278
    //   1269: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -1199 -> 82
    //   1284: ldc 161
    //   1286: iconst_2
    //   1287: new 163	java/lang/StringBuilder
    //   1290: dup
    //   1291: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1294: ldc_w 575
    //   1297: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: aload_0
    //   1301: getfield 37	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:f	J
    //   1304: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1313: return
    //   1314: astore 7
    //   1316: goto -1174 -> 142
    //   1319: astore 7
    //   1321: goto -1169 -> 152
    //   1324: astore 8
    //   1326: goto -979 -> 347
    //   1329: astore 8
    //   1331: goto -948 -> 383
    //   1334: astore 8
    //   1336: goto -943 -> 393
    //   1339: astore 7
    //   1341: aconst_null
    //   1342: astore 8
    //   1344: goto -971 -> 373
    //   1347: astore 7
    //   1349: goto -976 -> 373
    //   1352: astore 10
    //   1354: aload 7
    //   1356: astore 9
    //   1358: aload 10
    //   1360: astore 7
    //   1362: goto -989 -> 373
    //   1365: astore 10
    //   1367: aconst_null
    //   1368: astore 8
    //   1370: aload 9
    //   1372: astore 7
    //   1374: aload 10
    //   1376: astore 9
    //   1378: goto -1046 -> 332
    //   1381: astore 10
    //   1383: aload 9
    //   1385: astore 7
    //   1387: aload 10
    //   1389: astore 9
    //   1391: goto -1059 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1394	0	this	ConvertRunnable
    //   448	549	1	i	int
    //   86	1176	2	l1	long
    //   181	1079	4	l2	long
    //   618	25	6	bool	boolean
    //   277	1	7	localException1	java.lang.Exception
    //   327	26	7	localObject1	Object
    //   360	1	7	localException2	java.lang.Exception
    //   365	29	7	localObject2	Object
    //   396	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   467	747	7	localObject3	Object
    //   1314	1	7	localException3	java.lang.Exception
    //   1319	1	7	localException4	java.lang.Exception
    //   1339	1	7	localObject4	Object
    //   1347	8	7	localObject5	Object
    //   1360	26	7	localObject6	Object
    //   112	582	8	localObject7	Object
    //   1324	1	8	localException5	java.lang.Exception
    //   1329	1	8	localException6	java.lang.Exception
    //   1334	1	8	localException7	java.lang.Exception
    //   1342	27	8	localObject8	Object
    //   98	50	9	localFileInputStream	java.io.FileInputStream
    //   324	9	9	localException8	java.lang.Exception
    //   368	1022	9	localObject9	Object
    //   1352	7	10	localObject10	Object
    //   1365	10	10	localException9	java.lang.Exception
    //   1381	7	10	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   152	178	277	java/lang/Exception
    //   178	237	277	java/lang/Exception
    //   237	276	277	java/lang/Exception
    //   393	396	277	java/lang/Exception
    //   441	449	277	java/lang/Exception
    //   460	538	277	java/lang/Exception
    //   538	564	277	java/lang/Exception
    //   564	592	277	java/lang/Exception
    //   87	100	324	java/lang/Exception
    //   352	357	360	java/lang/Exception
    //   87	100	365	finally
    //   137	142	396	java/lang/OutOfMemoryError
    //   147	152	396	java/lang/OutOfMemoryError
    //   152	178	396	java/lang/OutOfMemoryError
    //   178	237	396	java/lang/OutOfMemoryError
    //   237	276	396	java/lang/OutOfMemoryError
    //   342	347	396	java/lang/OutOfMemoryError
    //   352	357	396	java/lang/OutOfMemoryError
    //   378	383	396	java/lang/OutOfMemoryError
    //   388	393	396	java/lang/OutOfMemoryError
    //   393	396	396	java/lang/OutOfMemoryError
    //   441	449	396	java/lang/OutOfMemoryError
    //   460	538	396	java/lang/OutOfMemoryError
    //   538	564	396	java/lang/OutOfMemoryError
    //   564	592	396	java/lang/OutOfMemoryError
    //   137	142	1314	java/lang/Exception
    //   147	152	1319	java/lang/Exception
    //   342	347	1324	java/lang/Exception
    //   378	383	1329	java/lang/Exception
    //   388	393	1334	java/lang/Exception
    //   100	114	1339	finally
    //   114	132	1347	finally
    //   332	337	1352	finally
    //   100	114	1365	java/lang/Exception
    //   114	132	1381	java/lang/Exception
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_b_of_type_Int == 0)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      d();
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */