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
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new SimpleDateFormat("yyyyMMdd.HHmmss.SSS");
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis())) + ".jpg";
    File localFile = new File(AppConstants.SDCARD_IMG_SAVE, (String)localObject);
    label249:
    for (;;)
    {
      try
      {
        boolean bool = FileUtil.a(localBitmap, localFile.getAbsolutePath());
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, screenShotFlag[" + this.jdField_a_of_type_Long + "], Exception", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, writeBitmapToFile, ret[" + bool + "]");
          if (bool) {
            ImageUtil.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
          }
          localObject = (VideoLayerUIBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null)
          {
            localObject = ((VideoLayerUIBase)localObject).a;
            if (localObject != null) {
              ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(20001), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(bool), localFile.getAbsolutePath() });
            }
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          localBitmap.recycle();
          return;
        }
        catch (Exception localException2)
        {
          break label249;
        }
        localException1 = localException1;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.MyRunnable
 * JD-Core Version:    0.7.0.1
 */