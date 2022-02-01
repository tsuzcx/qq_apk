package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    SessionInfo localSessionInfo;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      localSessionInfo = this.a.this$0.a.a();
      if ((localSessionInfo.d == 2) || ((localSessionInfo.d == 4) && (localSessionInfo.J) && (NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label931;
      }
      if (!TraeHelper.b(this.a.this$0)) {
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
    localObject1 = ((Resources)localObject3).getString(2131695432);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((TraeHelper.a(this.a.this$0)) && (QAVConfigUtils.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(localSessionInfo.q))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131695430);
        TipsUtil.a(localVideoAppInterface, 3012);
        if (!TraeHelper.c(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!TraeHelper.d(this.a.this$0)) {
            break label928;
          }
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        TipsUtil.a(localVideoAppInterface, 5, 3000L);
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
      localObject3 = TraeHelper.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, TraeHelper.e(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
      if (this.a.this$0.c != null)
      {
        localObject3 = (TraeHelper.TraeHelperListener)this.a.this$0.c.get();
        if (localObject3 != null) {
          ((TraeHelper.TraeHelperListener)localObject3).a(localSessionInfo.P, this.a.this$0.d);
        }
      }
      if (((TraeHelper.f(this.a.this$0)) || (TraeHelper.d(this.a.this$0))) && (!TraeHelper.a(this.a.this$0)))
      {
        TraeHelper.c(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        if (localSessionInfo.P)
        {
          i = 2;
          TipsUtil.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + localSessionInfo.q + "], mCurrentAudioLevel[" + this.a.this$0.d + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(localSessionInfo.q))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131695433);
          if (!TraeHelper.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!TraeHelper.d(this.a.this$0)) {
              break label928;
            }
          }
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(localSessionInfo.q))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131695431);
          if (!TraeHelper.c(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!TraeHelper.d(this.a.this$0)) {
              break label928;
            }
          }
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(localSessionInfo.q)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131695432);
        if (!TraeHelper.c(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!TraeHelper.d(this.a.this$0)) {
            break label928;
          }
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        TipsUtil.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        TipsUtil.a(localVideoAppInterface, 3012);
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
      localObject2 = ((Resources)localObject3).getString(2131695432);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */