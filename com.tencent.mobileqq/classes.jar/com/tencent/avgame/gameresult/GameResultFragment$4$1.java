package com.tencent.avgame.gameresult;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getFilesDir());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("QQGameVideo");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(".jpg");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1).getParentFile();
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      try
      {
        if (FileUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (String)localObject1))
        {
          ThreadManager.getUIHandler().post(new GameResultFragment.4.1.1(this, (String)localObject1));
          return;
        }
        QLog.d("GameResultFragment", 2, "initViewForGameKnowledge save bitmap wrong ");
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initViewForGameKnowledge save bitmap ");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.d("GameResultFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.4.1
 * JD-Core Version:    0.7.0.1
 */