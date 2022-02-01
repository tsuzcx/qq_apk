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
    int j;
    int i;
    try
    {
      if (this.a.this$0.d == null) {
        return;
      }
      localObject2 = this.a.a.getResources();
      localSessionInfo = this.a.this$0.d.k();
      if ((localSessionInfo.g == 2) || ((localSessionInfo.g == 4) && (localSessionInfo.am) && (NetworkUtil.a(this.a.b)))) {
        break label937;
      }
      if (!TraeHelper.e(this.a.this$0)) {
        break label932;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      SessionInfo localSessionInfo;
      Object localObject1;
      VideoAppInterface localVideoAppInterface;
      boolean bool;
      int m;
      int k;
      QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", localException);
      return;
    }
    localObject1 = ((Resources)localObject2).getString(2131893190);
    localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bool = TraeHelper.b(this.a.this$0);
    m = 1064;
    k = 8;
    if ((bool) && (QAVConfigUtils.a()))
    {
      if ("DEVICE_BLUETOOTH_HEADSET".equals(localSessionInfo.aD))
      {
        j = 5;
        localObject2 = ((Resources)localObject2).getString(2131893188);
        TipsUtil.b(localVideoAppInterface, 3012);
        if (!TraeHelper.f(this.a.this$0))
        {
          localObject1 = localObject2;
          i = j;
          if (!TraeHelper.g(this.a.this$0)) {}
        }
        else
        {
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 1067, 3000L);
          localObject1 = localObject2;
          i = j;
        }
      }
      else if ("DEVICE_WIRED_HEADSET".equals(localSessionInfo.aD))
      {
        j = 6;
        localObject2 = ((Resources)localObject2).getString(2131893191);
        if (!TraeHelper.f(this.a.this$0))
        {
          localObject1 = localObject2;
          i = j;
          if (!TraeHelper.g(this.a.this$0)) {}
        }
        else
        {
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 1068, 3000L);
          localObject1 = localObject2;
          i = j;
        }
      }
      else if ("DEVICE_EARPHONE".equals(localSessionInfo.aD))
      {
        j = 7;
        localObject2 = ((Resources)localObject2).getString(2131893189);
        if (!TraeHelper.f(this.a.this$0))
        {
          localObject1 = localObject2;
          i = j;
          if (!TraeHelper.g(this.a.this$0)) {}
        }
        else
        {
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          TipsUtil.a(localVideoAppInterface, 1069, 3000L);
          localObject1 = localObject2;
          i = j;
        }
      }
      else
      {
        i = k;
        if ("DEVICE_SPEAKERPHONE".equals(localSessionInfo.aD))
        {
          localObject2 = ((Resources)localObject2).getString(2131893190);
          if (!TraeHelper.f(this.a.this$0))
          {
            localObject1 = localObject2;
            i = k;
            if (!TraeHelper.g(this.a.this$0)) {}
          }
          else
          {
            TraeHelper.a(this.a.this$0, false);
            TraeHelper.b(this.a.this$0, false);
            TipsUtil.a(localVideoAppInterface, 1064, 3000L);
            localObject1 = localObject2;
            i = k;
          }
        }
      }
    }
    else
    {
      TipsUtil.b(localVideoAppInterface, 3012);
      if (this.a.this$0.n == 1)
      {
        if (j == 0) {
          break label942;
        }
        i = 3;
      }
      else
      {
        i = k;
        if (this.a.this$0.n == 2)
        {
          if (j == 0) {
            break label947;
          }
          i = 4;
        }
      }
      label617:
      localObject1 = ((Resources)localObject2).getString(2131893190);
    }
    localObject2 = TraeHelper.a(this.a.this$0, this.a.b.getResources(), i, TraeHelper.h(this.a.this$0));
    this.a.a.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.a.a.setText((CharSequence)localObject1);
    if (this.a.this$0.h != null)
    {
      localObject2 = (TraeHelper.TraeHelperListener)this.a.this$0.h.get();
      if (localObject2 != null) {
        ((TraeHelper.TraeHelperListener)localObject2).a(localSessionInfo.aG, this.a.this$0.n);
      }
    }
    if (((TraeHelper.i(this.a.this$0)) || (TraeHelper.g(this.a.this$0))) && (!TraeHelper.b(this.a.this$0)))
    {
      TraeHelper.c(this.a.this$0, false);
      TraeHelper.b(this.a.this$0, false);
      if (!localSessionInfo.aG) {
        break label952;
      }
      i = m;
    }
    for (;;)
    {
      TipsUtil.a(localVideoAppInterface, i, 3000L);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateButtonHandFree, btnText[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], deviceName[");
      ((StringBuilder)localObject2).append(localSessionInfo.aD);
      ((StringBuilder)localObject2).append("], mCurrentAudioLevel[");
      ((StringBuilder)localObject2).append(this.a.this$0.n);
      ((StringBuilder)localObject2).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString());
      return;
      label932:
      j = 0;
      break;
      label937:
      j = 1;
      break;
      label942:
      i = 1;
      break label617;
      label947:
      i = 2;
      break label617;
      label952:
      i = 1065;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */