package com.tencent.avgame.gameresult;

import android.graphics.Bitmap;
import auog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

class GameResultFragment$4$1
  implements Runnable
{
  GameResultFragment$4$1(GameResultFragment.4 param4, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      String str = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "QQGameVideo" + File.separator + System.currentTimeMillis() + ".jpg";
      File localFile = new File(str).getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      try
      {
        if (auog.a(this.jdField_a_of_type_AndroidGraphicsBitmap, str))
        {
          ThreadManager.getUIHandler().post(new GameResultFragment.4.1.1(this, str));
          return;
        }
        QLog.d("GameResultFragment", 2, "initViewForGameKnowledge save bitmap wrong ");
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("GameResultFragment", 2, "initViewForGameKnowledge save bitmap " + localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.4.1
 * JD-Core Version:    0.7.0.1
 */