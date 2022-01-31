package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import lgf;
import mat;
import mqq.util.WeakReference;
import msq;
import mtt;
import muc;
import nar;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    lgf locallgf;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      locallgf = this.a.this$0.a.a();
      if ((locallgf.d == 2) || ((locallgf.d == 4) && (locallgf.I) && (nar.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label931;
      }
      if (!mtt.b(this.a.this$0)) {
        break label549;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", localException);
      return;
    }
    int i = 8;
    localObject1 = ((Resources)localObject3).getString(2131695752);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((mtt.a(this.a.this$0)) && (msq.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(locallgf.q))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131695750);
        mat.a(localVideoAppInterface, 3012);
        if (!mtt.c(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!mtt.d(this.a.this$0)) {
            break label928;
          }
        }
        mtt.a(this.a.this$0, false);
        mtt.b(this.a.this$0, false);
        mat.a(localVideoAppInterface, 5, 3000L);
        i = 5;
        localObject1 = localObject3;
      }
    }
    label272:
    label463:
    int j;
    label549:
    Object localObject2;
    for (;;)
    {
      localObject3 = mtt.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, mtt.e(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      if (this.a.this$0.c != null)
      {
        localObject3 = (muc)this.a.this$0.c.get();
        if (localObject3 != null) {
          ((muc)localObject3).a(locallgf.N, this.a.this$0.d);
        }
      }
      if (((mtt.f(this.a.this$0)) || (mtt.d(this.a.this$0))) && (!mtt.a(this.a.this$0)))
      {
        mtt.c(this.a.this$0, false);
        mtt.b(this.a.this$0, false);
        if (locallgf.N)
        {
          i = 2;
          mat.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + locallgf.q + "], mCurrentAudioLevel[" + this.a.this$0.d + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(locallgf.q))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131695753);
          if (!mtt.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mtt.d(this.a.this$0)) {
              break label928;
            }
          }
          mtt.a(this.a.this$0, false);
          mtt.b(this.a.this$0, false);
          mat.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(locallgf.q))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131695751);
          if (!mtt.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mtt.d(this.a.this$0)) {
              break label928;
            }
          }
          mtt.a(this.a.this$0, false);
          mtt.b(this.a.this$0, false);
          mat.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(locallgf.q)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131695752);
        if (!mtt.c(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!mtt.d(this.a.this$0)) {
            break label928;
          }
        }
        mtt.a(this.a.this$0, false);
        mtt.b(this.a.this$0, false);
        mat.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        mat.a(localVideoAppInterface, 3012);
        if (this.a.this$0.d == 1)
        {
          if (j == 0) {
            break label936;
          }
          i = 3;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((Resources)localObject3).getString(2131695752);
      break label272;
      int k = this.a.this$0.d;
      if (k == 2) {
        if (j != 0)
        {
          i = 4;
        }
        else
        {
          i = 2;
          continue;
          i = 3;
          break label463;
          label928:
          break label272;
          label931:
          j = 1;
          break;
          label936:
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */