package com.tencent.featuretoggle.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.featuretoggle.ToggleConfig;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.net.CacheManager;
import com.tencent.featuretoggle.net.HalleyRequestImpl;

class HeaderThreadUtil$1
  extends Handler
{
  HeaderThreadUtil$1(HeaderThreadUtil paramHeaderThreadUtil, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      int i = paramMessage.what;
      if (i != 2)
      {
        switch (i)
        {
        default: 
          return;
        case 1005: 
          if (ToggleSetting.f()) {
            break;
          }
          CacheManager.a().d();
          sendEmptyMessageDelayed(1005, ToggleSetting.a().j());
          return;
        case 1004: 
          HalleyRequestImpl.a().a(false);
          return;
        case 1003: 
          HeaderThreadUtil.d();
          return;
        case 1002: 
          if (!ToggleSetting.g()) {
            break;
          }
          HalleyRequestImpl.a().b();
          return;
        case 1001: 
          if (!ToggleSetting.f()) {
            break;
          }
          HalleyRequestImpl.a().a(true);
          return;
        }
      }
      else
      {
        if (paramMessage.obj == null) {
          ToggleSetting.a(2);
        }
        if (ToggleSetting.g()) {
          HalleyRequestImpl.a().b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.HeaderThreadUtil.1
 * JD-Core Version:    0.7.0.1
 */