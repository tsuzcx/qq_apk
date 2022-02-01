package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lff;
import mbb;
import mtl;
import mur;
import mva;
import nny;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    lff locallff;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      locallff = this.a.this$0.a.a();
      if ((locallff.d == 2) || ((locallff.d == 4) && (locallff.J) && (nny.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label931;
      }
      if (!mur.b(this.a.this$0)) {
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
    localObject1 = ((Resources)localObject3).getString(2131694835);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((mur.a(this.a.this$0)) && (mtl.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(locallff.q))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131694833);
        mbb.a(localVideoAppInterface, 3012);
        if (!mur.c(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!mur.d(this.a.this$0)) {
            break label928;
          }
        }
        mur.a(this.a.this$0, false);
        mur.b(this.a.this$0, false);
        mbb.a(localVideoAppInterface, 5, 3000L);
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
      localObject3 = mur.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, mur.e(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      if (this.a.this$0.c != null)
      {
        localObject3 = (mva)this.a.this$0.c.get();
        if (localObject3 != null) {
          ((mva)localObject3).a(locallff.P, this.a.this$0.d);
        }
      }
      if (((mur.f(this.a.this$0)) || (mur.d(this.a.this$0))) && (!mur.a(this.a.this$0)))
      {
        mur.c(this.a.this$0, false);
        mur.b(this.a.this$0, false);
        if (locallff.P)
        {
          i = 2;
          mbb.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + locallff.q + "], mCurrentAudioLevel[" + this.a.this$0.d + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(locallff.q))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131694836);
          if (!mur.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mur.d(this.a.this$0)) {
              break label928;
            }
          }
          mur.a(this.a.this$0, false);
          mur.b(this.a.this$0, false);
          mbb.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(locallff.q))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131694834);
          if (!mur.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!mur.d(this.a.this$0)) {
              break label928;
            }
          }
          mur.a(this.a.this$0, false);
          mur.b(this.a.this$0, false);
          mbb.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(locallff.q)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131694835);
        if (!mur.c(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!mur.d(this.a.this$0)) {
            break label928;
          }
        }
        mur.a(this.a.this$0, false);
        mur.b(this.a.this$0, false);
        mbb.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        mbb.a(localVideoAppInterface, 3012);
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
      localObject2 = ((Resources)localObject3).getString(2131694835);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */