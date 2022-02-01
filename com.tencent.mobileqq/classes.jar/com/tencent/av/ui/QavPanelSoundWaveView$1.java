package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.BaseActivity;

class QavPanelSoundWaveView$1
  implements Runnable
{
  QavPanelSoundWaveView$1(QavPanelSoundWaveView paramQavPanelSoundWaveView) {}
  
  public void run()
  {
    if (this.this$0.getVisibility() != 0)
    {
      this.this$0.f.postDelayed(this.this$0.h, 200L);
      return;
    }
    if (!this.this$0.e)
    {
      localObject = this.this$0;
      ((QavPanelSoundWaveView)localObject).c += -this.this$0.a * 0.00048F;
    }
    else
    {
      localObject = this.this$0;
      ((QavPanelSoundWaveView)localObject).c += -this.this$0.a * 0.00067F;
    }
    Object localObject = this.this$0.getContext();
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getAppRuntime();
      if ((localObject instanceof VideoAppInterface))
      {
        localObject = ((VideoAppInterface)localObject).b();
        f1 = ((VideoController)localObject).ak() * 0.05F;
        if ((((VideoController)localObject).k().g != 3) && (!((VideoController)localObject).k().j()))
        {
          i = 0;
          break label196;
        }
        i = 1;
        break label196;
      }
    }
    int i = 0;
    float f1 = 1.0F;
    label196:
    float f2 = f1;
    if (i != 0)
    {
      f2 = f1;
      if (!this.this$0.e)
      {
        this.this$0.c = 0.0F;
        f2 = 0.0F;
      }
    }
    localObject = this.this$0.d.iterator();
    int j = 1;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label302;
      }
      QavPanelWave localQavPanelWave = (QavPanelWave)((Iterator)localObject).next();
      localQavPanelWave.a(this.this$0.c, f2);
      if (j != 0)
      {
        if (Float.compare(localQavPanelWave.e, 0.0F) == 0) {
          break;
        }
        j = 0;
      }
    }
    label302:
    if ((i == 0) || (j == 0)) {
      this.this$0.f.postDelayed(this.this$0.h, 66L);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView.1
 * JD-Core Version:    0.7.0.1
 */