package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import java.util.Iterator;
import java.util.List;
import lid;
import mlc;
import mqq.app.BaseActivity;

class QavPanelSoundWaveView$1
  implements Runnable
{
  QavPanelSoundWaveView$1(QavPanelSoundWaveView paramQavPanelSoundWaveView) {}
  
  public void run()
  {
    if (this.this$0.getVisibility() != 0)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
    }
    Object localObject;
    float f;
    int j;
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      localObject = this.this$0;
      ((QavPanelSoundWaveView)localObject).c += -this.this$0.jdField_a_of_type_Float * 0.00048F;
      localObject = this.this$0.getContext();
      if (!(localObject instanceof BaseActivity)) {
        break label330;
      }
      localObject = ((BaseActivity)localObject).getAppRuntime();
      if (!(localObject instanceof VideoAppInterface)) {
        break label330;
      }
      localObject = ((VideoAppInterface)localObject).a();
      f = ((VideoController)localObject).i() * 0.05F;
      if ((((VideoController)localObject).a().d != 3) && (!((VideoController)localObject).a().k())) {
        break label325;
      }
      j = 1;
    }
    for (;;)
    {
      if ((j != 0) && (!this.this$0.jdField_a_of_type_Boolean))
      {
        this.this$0.c = 0.0F;
        f = 0.0F;
      }
      for (;;)
      {
        localObject = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        int i = 1;
        label190:
        if (((Iterator)localObject).hasNext())
        {
          mlc localmlc = (mlc)((Iterator)localObject).next();
          localmlc.a(this.this$0.c, f);
          if (i == 0) {
            break label319;
          }
          if (Float.compare(localmlc.d, 0.0F) == 0) {
            i = 1;
          }
        }
        label319:
        for (;;)
        {
          break label190;
          localObject = this.this$0;
          ((QavPanelSoundWaveView)localObject).c += -this.this$0.jdField_a_of_type_Float * 0.00067F;
          break;
          i = 0;
          continue;
          if ((j == 0) || (i == 0)) {
            this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 66L);
          }
          this.this$0.invalidate();
          return;
        }
      }
      label325:
      j = 0;
      continue;
      label330:
      j = 0;
      f = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView.1
 * JD-Core Version:    0.7.0.1
 */