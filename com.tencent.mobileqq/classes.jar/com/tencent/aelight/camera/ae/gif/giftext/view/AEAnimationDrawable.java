package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEAnimationDrawable
  extends GifAnimationDrawable
{
  public AEAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    super(paramContext, paramArrayList, paramLong);
  }
  
  public void start()
  {
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zswp20pro", 2, "start");
      }
      this.b = true;
      this.c = true;
      this.e = false;
      a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zswp20pro", 2, "start but isRunning");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.AEAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */