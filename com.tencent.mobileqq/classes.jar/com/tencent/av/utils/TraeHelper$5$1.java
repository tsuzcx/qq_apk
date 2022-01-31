package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import lga;
import mao;
import mqq.util.WeakReference;
import msn;
import mtq;
import mtz;
import nao;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    lga locallga;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      locallga = this.a.this$0.a.a();
      if ((locallga.d == 2) || ((locallga.d == 4) && (locallga.I) && (nao.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label931;
      }
      if (!mtq.b(this.a.this$0)) {
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
    localObject1 = ((Resources)localObject3).getString(2131695753);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((mtq.a(this.a.this$0)) && (msn.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(locallga.q))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131695751);
        mao.a(localVideoAppInterface, 3012);
        if (!mtq.c(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!mtq.d(this.a.this$0)) {
            break label928;
          }
        }
        mtq.a(this.a.this$0, false);
        mtq.b(this.a.this$0, false);
        mao.a(localVideoAppInterface, 5, 3000L);
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
      localObject3 = mtq.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, mtq.e(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      if (this.a.this$0.c != null)
      {
        localObject3 = (mtz)this.a.this$0.c.get();
        if (localObject3 != null) {
          ((mtz)localObject3).a(locallga.N, this.a.this$0.d);
        }
      }
      if (((mtq.f(this.a.this$0)) || (mtq.d(this.a.this$0))) && (!mtq.a(this.a.this$0)))
      {
        mtq.c(this.a.this$0, false);
        mtq.b(this.a.this$0, false);
        if (locallga.N)
        {
          i = 2;
          mao.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + locallga.q + "], mCurrentAudioLevel[" + this.a.this$0.d + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(locallga.q))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131695754);
          if (!mtq.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mtq.d(this.a.this$0)) {
              break label928;
            }
          }
          mtq.a(this.a.this$0, false);
          mtq.b(this.a.this$0, false);
          mao.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(locallga.q))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131695752);
          if (!mtq.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mtq.d(this.a.this$0)) {
              break label928;
            }
          }
          mtq.a(this.a.this$0, false);
          mtq.b(this.a.this$0, false);
          mao.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(locallga.q)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131695753);
        if (!mtq.c(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!mtq.d(this.a.this$0)) {
            break label928;
          }
        }
        mtq.a(this.a.this$0, false);
        mtq.b(this.a.this$0, false);
        mao.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        mao.a(localVideoAppInterface, 3012);
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
      localObject2 = ((Resources)localObject3).getString(2131695753);
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