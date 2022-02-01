package com.tencent.mobileqq.apollo.player.api.impl;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class ApolloBrickPlayerImpl$1
  implements Runnable
{
  ApolloBrickPlayerImpl$1(ApolloBrickPlayerImpl paramApolloBrickPlayerImpl) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mCMSAIOAction.a(null, null);
    boolean bool;
    if ((ApolloBrickPlayerImpl.access$000(this.this$0) != null) && (!ApolloBrickPlayerImpl.access$000(this.this$0).equals(localObject1))) {
      bool = true;
    } else {
      bool = false;
    }
    ApolloBrickPlayerImpl.access$002(this.this$0, (String)localObject1);
    Object localObject2 = (String)ApolloBrickPlayerImpl.access$100().get(localObject1);
    if (localObject2 != null)
    {
      if (this.this$0.mCMSAIOAction.a() == MODE.ACTION_MODE_RECORD_GIF)
      {
        localObject1 = ApolloBrickPlayerImpl.access$400((String)localObject2, ApolloBrickPlayerImpl.access$200(this.this$0), ApolloBrickPlayerImpl.access$300(this.this$0));
        ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).putAction2GifFilePath(ApolloBrickPlayerImpl.access$500(this.this$0), this.this$0.mCMSAIOAction.a().a, (String)localObject2);
      }
      else
      {
        localObject1 = ApolloBrickPlayerImpl.access$600((String)localObject2, ApolloBrickPlayerImpl.access$200(this.this$0));
      }
      ApolloBrickPlayerImpl.access$900(this.this$0).post(new ApolloBrickPlayerImpl.1.1(this, (URLDrawable)localObject1));
      return;
    }
    if (ApolloBrickPlayerImpl.access$1000(this.this$0) != null) {
      ApolloBrickPlayerImpl.access$1000(this.this$0).a();
    }
    localObject2 = this.this$0;
    ApolloBrickPlayerImpl.access$1002((ApolloBrickPlayerImpl)localObject2, ApolloBrickPlayerImpl.access$1100((ApolloBrickPlayerImpl)localObject2));
    this.this$0.mCMSPlayer.a(null, this.this$0.mCMSAIOAction, ApolloBrickPlayerImpl.access$1000(this.this$0));
    if (ApolloBrickPlayerImpl.access$1200().containsKey(localObject1))
    {
      localObject2 = ApolloBrickPlayerImpl.access$1000(this.this$0);
      ThreadManager.getSubThreadHandler().post(new ApolloBrickPlayerImpl.1.2(this, (String)localObject1, (ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject2));
    }
    ApolloBrickPlayerImpl.access$900(this.this$0).post(new ApolloBrickPlayerImpl.1.3(this, bool));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" start recordAction ");
      ((StringBuilder)localObject1).append(ApolloBrickPlayerImpl.access$500(this.this$0));
      ((StringBuilder)localObject1).append(", listener:");
      ((StringBuilder)localObject1).append(ApolloBrickPlayerImpl.access$1000(this.this$0));
      QLog.d("[cmshow]ApolloBrickPlayer", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */