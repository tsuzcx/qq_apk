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
    int i;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject2 = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      localSessionInfo = this.a.this$0.a.a();
      i = localSessionInfo.d;
      j = 2;
      if ((i == 2) || ((localSessionInfo.d == 4) && (localSessionInfo.y) && (NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext)))) {
        break label889;
      }
      if (!TraeHelper.b(this.a.this$0)) {
        break label884;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      SessionInfo localSessionInfo;
      int j;
      Object localObject1;
      VideoAppInterface localVideoAppInterface;
      boolean bool;
      int k;
      QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", localException);
      return;
    }
    localObject1 = ((Resources)localObject2).getString(2131695442);
    localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bool = TraeHelper.a(this.a.this$0);
    k = 7;
    if ((bool) && (QAVConfigUtils.a()))
    {
      if ("DEVICE_BLUETOOTH_HEADSET".equals(localSessionInfo.p))
      {
        localObject1 = ((Resources)localObject2).getString(2131695440);
        TipsUtil.a(localVideoAppInterface, 3012);
        if ((!TraeHelper.c(this.a.this$0)) && (!TraeHelper.d(this.a.this$0))) {
          break label894;
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        TipsUtil.a(localVideoAppInterface, 5, 3000L);
        break label894;
      }
      if ("DEVICE_WIRED_HEADSET".equals(localSessionInfo.p))
      {
        localObject1 = ((Resources)localObject2).getString(2131695443);
        if ((!TraeHelper.c(this.a.this$0)) && (!TraeHelper.d(this.a.this$0))) {
          break label899;
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        TipsUtil.a(localVideoAppInterface, 6, 3000L);
        break label899;
      }
      if ("DEVICE_EARPHONE".equals(localSessionInfo.p))
      {
        localObject2 = ((Resources)localObject2).getString(2131695441);
        if (!TraeHelper.c(this.a.this$0))
        {
          localObject1 = localObject2;
          i = k;
          if (!TraeHelper.d(this.a.this$0)) {}
        }
        else
        {
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 7, 3000L);
          localObject1 = localObject2;
          i = k;
        }
      }
      else
      {
        if (!"DEVICE_SPEAKERPHONE".equals(localSessionInfo.p)) {
          break label905;
        }
        localObject2 = ((Resources)localObject2).getString(2131695442);
        if (!TraeHelper.c(this.a.this$0))
        {
          localObject1 = localObject2;
          if (!TraeHelper.d(this.a.this$0)) {
            break label905;
          }
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        TipsUtil.a(localVideoAppInterface, 2, 3000L);
        localObject1 = localObject2;
        break label905;
      }
    }
    else
    {
      TipsUtil.a(localVideoAppInterface, 3012);
      if (this.a.this$0.d == 1)
      {
        if (i == 0) {
          break label911;
        }
        i = 3;
      }
      else
      {
        if (this.a.this$0.d != 2) {
          break label921;
        }
        if (i == 0) {
          break label916;
        }
        i = 4;
      }
      label570:
      localObject1 = ((Resources)localObject2).getString(2131695442);
    }
    label579:
    localObject2 = TraeHelper.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, TraeHelper.e(this.a.this$0));
    this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.a.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
    if (this.a.this$0.c != null)
    {
      localObject2 = (TraeHelper.TraeHelperListener)this.a.this$0.c.get();
      if (localObject2 != null) {
        ((TraeHelper.TraeHelperListener)localObject2).a(localSessionInfo.E, this.a.this$0.d);
      }
    }
    if (((TraeHelper.f(this.a.this$0)) || (TraeHelper.d(this.a.this$0))) && (!TraeHelper.a(this.a.this$0)))
    {
      TraeHelper.c(this.a.this$0, false);
      TraeHelper.b(this.a.this$0, false);
      if (!localSessionInfo.E) {
        break label927;
      }
      i = j;
    }
    for (;;)
    {
      TipsUtil.a(localVideoAppInterface, i, 3000L);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateButtonHandFree, btnText[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], deviceName[");
      ((StringBuilder)localObject2).append(localSessionInfo.p);
      ((StringBuilder)localObject2).append("], mCurrentAudioLevel[");
      ((StringBuilder)localObject2).append(this.a.this$0.d);
      ((StringBuilder)localObject2).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString());
      return;
      label884:
      i = 0;
      break;
      label889:
      i = 1;
      break;
      label894:
      i = 5;
      break label579;
      label899:
      i = 6;
      break label579;
      label905:
      i = 8;
      break label579;
      label911:
      i = 1;
      break label570;
      label916:
      i = 2;
      break label570;
      label921:
      i = 8;
      break label570;
      label927:
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */