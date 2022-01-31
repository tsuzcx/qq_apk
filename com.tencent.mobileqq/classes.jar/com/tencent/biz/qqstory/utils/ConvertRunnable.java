package com.tencent.biz.qqstory.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

public class ConvertRunnable
  implements HWEncodeListener, Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  
  public ConvertRunnable(long paramLong1, String paramString, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, ConvertRunnable.ConvertRunnableListener paramConvertRunnableListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramConvertRunnableListener);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = paramLong1;
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
      return GlUtil.a(3553, paramBitmap);
      i = GlUtil.a(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.m();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(paramInt1, paramInt2, paramInt1, paramInt2);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).a(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.a(i);
    return paramInt2;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ConvertRunnable.ConvertRunnableListener localConvertRunnableListener = (ConvertRunnable.ConvertRunnableListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localConvertRunnableListener != null)
      {
        Image2Video.ResultInfo localResultInfo = new Image2Video.ResultInfo();
        localResultInfo.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        localResultInfo.jdField_a_of_type_Int = paramInt;
        localResultInfo.jdField_b_of_type_JavaLangString = paramString2;
        localResultInfo.jdField_a_of_type_JavaLangString = paramString1;
        localResultInfo.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        localConvertRunnableListener.a(localResultInfo);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("ConvertRunnable", 2, "run exit:" + this.jdField_c_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
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
      return GlUtil.a(3553, paramBitmap);
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
      return GlUtil.a(3553, localBitmap);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) && (this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, this.jdField_c_of_type_Int, null, null, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_Long += 30000000L;
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.jdField_c_of_type_Long);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = b(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
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
    } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder == null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, taskid:" + this.jdField_c_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, delete old:" + this.jdField_c_of_type_Long + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      FileUtils.g(this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename start:" + this.jdField_c_of_type_Long + " file:" + this.jdField_b_of_type_JavaLangString);
      }
      if (FileUtils.a(paramString, this.jdField_b_of_type_JavaLangString))
      {
        this.d = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename end:" + this.jdField_c_of_type_Long + " file:" + this.jdField_b_of_type_JavaLangString + " result:" + this.d);
        }
        if (!FileUtil.a(this.jdField_b_of_type_JavaLangString)) {
          break label362;
        }
        long l = FileUtil.a(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, file exist, size:" + l + " file:" + this.jdField_b_of_type_JavaLangString);
        }
        label289:
        paramString = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
        a(this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.q();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.d();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = null;
      }
      return;
      this.d = 7;
      break;
      label362:
      if (!QLog.isColorLevel()) {
        break label289;
      }
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, file not exist:" + this.jdField_c_of_type_Long + " file:" + this.jdField_b_of_type_JavaLangString);
      break label289;
      FileUtils.g(paramString);
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ConvertRunnable", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_c_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.d = 7;
      a(this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      }
    }
    do
    {
      do
      {
        return;
      } while (b());
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConvertRunnable", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_c_of_type_Long);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "stop, taskid:" + this.jdField_c_of_type_Long + " current is running:" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "run begin, taskid:" + this.jdField_c_of_type_Long + " run:" + this.jdField_a_of_type_Boolean);
    }
    if (a()) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(5, this.jdField_a_of_type_JavaLangString, null, null);
          return;
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            this.jdField_a_of_type_Boolean = false;
            a(5, this.jdField_a_of_type_JavaLangString, null, null);
            return;
            int i = ImageUtil.a(this.jdField_a_of_type_JavaLangString);
            if ((i != 0) && (i % 90 == 0))
            {
              Object localObject1 = new Matrix();
              ((Matrix)localObject1).postRotate(i, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
              localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject1, true);
              this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
              this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
            }
            if (a())
            {
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                break;
              }
              this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
              this.jdField_a_of_type_AndroidGraphicsBitmap = null;
              return;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run decode image OOM, taskid:" + this.jdField_c_of_type_Long);
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        localObject2 = new File(Image2Video.jdField_b_of_type_JavaLangString);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdir();
        }
        localObject2 = new File(this.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break label617;
        }
      }
    }
    String str = ((File)localObject2).getName();
    Object localObject2 = str;
    if (!TextUtils.isEmpty(str)) {
      localObject2 = str.replace(".", "_");
    }
    label617:
    for (localObject2 = (String)localObject2 + ".mp4";; localObject2 = null)
    {
      this.jdField_b_of_type_JavaLangString = (Image2Video.jdField_b_of_type_JavaLangString + (String)localObject2);
      this.jdField_c_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "_tmp_" + System.currentTimeMillis());
      FileUtils.g(this.jdField_c_of_type_JavaLangString);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = (1000000L * this.jdField_a_of_type_Long);
      if (a())
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run, start recording, taskid:" + this.jdField_c_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
      localObject2 = new EncodeConfig(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, SVParamManager.a().a(1) * 1000, 1, false, 0);
      ((EncodeConfig)localObject2).a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a((EncodeConfig)localObject2, this);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ConvertRunnable", 2, "run end, taskid:" + this.jdField_c_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */