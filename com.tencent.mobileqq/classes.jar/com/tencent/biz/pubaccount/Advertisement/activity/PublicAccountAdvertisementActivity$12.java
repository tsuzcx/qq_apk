package com.tencent.biz.pubaccount.Advertisement.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class PublicAccountAdvertisementActivity$12
  extends Handler
{
  PublicAccountAdvertisementActivity$12(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = false;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            if (!this.a.isResume()) {
              return;
            }
            paramMessage = this.a.getSupportFragmentManager().beginTransaction();
            localObject = this.a;
            PublicAccountAdvertisementActivity.a((PublicAccountAdvertisementActivity)localObject, WebpageFragment.a(((PublicAccountAdvertisementActivity)localObject).getIntent()));
            PublicAccountAdvertisementActivity.a(this.a).a(PublicAccountAdvertisementActivity.a(this.a));
            paramMessage.add(2131381076, PublicAccountAdvertisementActivity.a(this.a));
            paramMessage.commit();
            if (!ThemeUtil.isInNightMode(this.a.getAppRuntime())) {
              return;
            }
            paramMessage = this.a.findViewById(2131371885);
            if (paramMessage == null) {
              return;
            }
            paramMessage.setVisibility(0);
            return;
          }
          if (PublicAccountAdvertisementActivity.a(this.a) == null) {
            return;
          }
          Object localObject = PublicAccountAdvertisementActivity.a(this.a);
          if (paramMessage.arg1 == 1) {
            bool = true;
          }
          ((VideoCoverFragment)localObject).c(bool);
          return;
        }
        paramMessage = this.a;
        paramMessage.b(paramMessage.getString(2131689579));
        return;
      }
      i = paramMessage.arg1;
      if (i != -24) {
        if (i == 600) {}
      }
    }
    switch (i)
    {
    default: 
      this.a.a(2131689580);
      return;
      this.a.a(2131689581);
      return;
      paramMessage = this.a;
      paramMessage.b(paramMessage.getString(2131689578));
      return;
      i = paramMessage.arg1;
      if (PublicAccountAdvertisementActivity.a(this.a) != null)
      {
        PublicAccountAdvertisementActivity.a(this.a).a(i);
        if ((i > 0) && (i < 100))
        {
          PublicAccountAdvertisementActivity.a(this.a).c(true);
          return;
        }
        if (i == 100) {
          PublicAccountAdvertisementActivity.a(this.a).c(false);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.12
 * JD-Core Version:    0.7.0.1
 */