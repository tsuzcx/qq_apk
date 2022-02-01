package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoHelper;

final class GVideoGrayConfig$3
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  GVideoGrayConfig$3(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, String paramString) {}
  
  private void a(Context paramContext)
  {
    if ((paramContext instanceof JumpActivity)) {
      ((Activity)paramContext).finish();
    }
  }
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      Object localObject;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              a(this.b);
              return;
            }
            localObject = this.b;
            if ((localObject instanceof Activity))
            {
              GVideoGrayConfig.a((Context)localObject, paramRecord.d, paramRecord.e, new GVideoGrayConfig.3.2(this));
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
            }
          }
          else
          {
            localObject = this.b;
            if ((localObject instanceof Activity))
            {
              GVideoGrayConfig.a((Context)localObject, paramRecord.d, paramRecord.e, new GVideoGrayConfig.3.1(this));
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
            }
          }
        }
        else {
          ((IGroupVideoManager)this.a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(this.b, this.a.getCurrentAccountUin(), this.d, "4", "openRoom");
        }
      }
      else
      {
        localObject = new Intent(this.b, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramRecord.c);
        if (!(this.b instanceof Activity)) {
          ((Intent)localObject).addFlags(268435456);
        }
        this.b.startActivity((Intent)localObject);
        a(this.b);
      }
    }
    else
    {
      ((IGroupVideoHelper)QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(this.a, this.b, this.c, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig.3
 * JD-Core Version:    0.7.0.1
 */