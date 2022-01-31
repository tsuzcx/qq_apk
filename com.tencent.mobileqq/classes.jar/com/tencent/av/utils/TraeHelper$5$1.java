package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import lid;
import mdd;
import mqq.util.WeakReference;
import mvh;
import mwk;
import mwt;
import ndk;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    lid locallid;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      locallid = this.a.this$0.a.a();
      if ((locallid.d == 2) || ((locallid.d == 4) && (locallid.J) && (ndk.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label931;
      }
      if (!mwk.b(this.a.this$0)) {
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
    localObject1 = ((Resources)localObject3).getString(2131695915);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((mwk.a(this.a.this$0)) && (mvh.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(locallid.q))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131695913);
        mdd.a(localVideoAppInterface, 3012);
        if (!mwk.c(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!mwk.d(this.a.this$0)) {
            break label928;
          }
        }
        mwk.a(this.a.this$0, false);
        mwk.b(this.a.this$0, false);
        mdd.a(localVideoAppInterface, 5, 3000L);
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
      localObject3 = mwk.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, mwk.e(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      if (this.a.this$0.c != null)
      {
        localObject3 = (mwt)this.a.this$0.c.get();
        if (localObject3 != null) {
          ((mwt)localObject3).a(locallid.O, this.a.this$0.d);
        }
      }
      if (((mwk.f(this.a.this$0)) || (mwk.d(this.a.this$0))) && (!mwk.a(this.a.this$0)))
      {
        mwk.c(this.a.this$0, false);
        mwk.b(this.a.this$0, false);
        if (locallid.O)
        {
          i = 2;
          mdd.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + locallid.q + "], mCurrentAudioLevel[" + this.a.this$0.d + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(locallid.q))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131695916);
          if (!mwk.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mwk.d(this.a.this$0)) {
              break label928;
            }
          }
          mwk.a(this.a.this$0, false);
          mwk.b(this.a.this$0, false);
          mdd.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(locallid.q))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131695914);
          if (!mwk.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mwk.d(this.a.this$0)) {
              break label928;
            }
          }
          mwk.a(this.a.this$0, false);
          mwk.b(this.a.this$0, false);
          mdd.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(locallid.q)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131695915);
        if (!mwk.c(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!mwk.d(this.a.this$0)) {
            break label928;
          }
        }
        mwk.a(this.a.this$0, false);
        mwk.b(this.a.this$0, false);
        mdd.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        mdd.a(localVideoAppInterface, 3012);
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
      localObject2 = ((Resources)localObject3).getString(2131695915);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */