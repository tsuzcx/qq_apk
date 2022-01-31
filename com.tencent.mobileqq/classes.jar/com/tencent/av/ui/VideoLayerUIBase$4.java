package com.tencent.av.ui;

import ajsf;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import apvb;
import bbdr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class VideoLayerUIBase$4
  implements Runnable
{
  VideoLayerUIBase$4(VideoLayerUIBase paramVideoLayerUIBase, Bitmap paramBitmap, long paramLong) {}
  
  public void run()
  {
    new File(ajsf.bc).mkdirs();
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new SimpleDateFormat("yyyyMMdd.HHmmss.SSS");
    localObject = ((SimpleDateFormat)localObject).format(new Date(System.currentTimeMillis())) + ".jpg";
    File localFile = new File(ajsf.bc, (String)localObject);
    for (;;)
    {
      try
      {
        bool1 = apvb.a(localBitmap, localFile.getAbsolutePath());
        QLog.w(this.this$0.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, screenShotFlag[" + this.jdField_a_of_type_Long + "], Exception", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.w(this.this$0.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, writeBitmapToFile, ret[" + bool1 + "]");
          bool2 = bool1;
          if (bool1)
          {
            bbdr.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
            bool2 = bool1;
          }
          if (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
            this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20001), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(bool2), localFile.getAbsolutePath() });
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          localBitmap.recycle();
          return;
        }
        catch (Exception localException2)
        {
          boolean bool1;
          boolean bool2;
          break label251;
        }
        localException1 = localException1;
        bool1 = false;
      }
      label251:
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.4
 * JD-Core Version:    0.7.0.1
 */