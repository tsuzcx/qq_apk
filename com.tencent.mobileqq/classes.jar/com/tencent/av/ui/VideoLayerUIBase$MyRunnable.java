package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

class VideoLayerUIBase$MyRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<VideoLayerUIBase> jdField_a_of_type_JavaLangRefWeakReference;
  
  public VideoLayerUIBase$MyRunnable(String paramString, Bitmap paramBitmap, long paramLong, VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void run()
  {
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).setScale(1.0F, -1.0F);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject1, true);
    localObject1 = new SimpleDateFormat("yyyyMMdd.HHmmss.SSS");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject1).format(new Date(System.currentTimeMillis())));
    ((StringBuilder)localObject3).append(".jpg");
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new File(AppConstants.SDCARD_IMG_SAVE, (String)localObject1);
    boolean bool1;
    Object localObject4;
    try
    {
      bool1 = FileUtil.a(localBitmap, ((File)localObject3).getAbsolutePath());
      try
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("tryScreenShot, writeBitmapToFile, ret[");
        ((StringBuilder)localObject4).append(bool1);
        ((StringBuilder)localObject4).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject4).toString());
        bool2 = bool1;
        if (!bool1) {
          break label266;
        }
        ImageUtil.a(BaseApplicationImpl.getContext(), ((File)localObject3).getAbsolutePath());
        bool2 = bool1;
      }
      catch (Exception localException1) {}
      localObject4 = this.jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException2)
    {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryScreenShot, screenShotFlag[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], Exception");
    QLog.w((String)localObject4, 1, localStringBuilder.toString(), localException2);
    boolean bool2 = bool1;
    label266:
    Object localObject2 = (VideoLayerUIBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 != null)
    {
      localObject2 = ((VideoLayerUIBase)localObject2).a;
      if (localObject2 != null) {
        ((VideoAppInterface)localObject2).a(new Object[] { Integer.valueOf(20001), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(bool2), ((File)localObject3).getAbsolutePath() });
      }
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    localBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.MyRunnable
 * JD-Core Version:    0.7.0.1
 */