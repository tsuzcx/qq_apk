package com.tencent.mobileqq.apollo.api.player.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.app.ThreadManager;
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
    if ((ApolloBrickPlayerImpl.access$000(this.this$0) != null) && (!ApolloBrickPlayerImpl.access$000(this.this$0).equals(localObject1))) {}
    for (boolean bool = true;; bool = false)
    {
      ApolloBrickPlayerImpl.access$002(this.this$0, (String)localObject1);
      Object localObject2 = (String)ApolloBrickPlayerImpl.access$100().get(localObject1);
      if (localObject2 != null) {
        if (this.this$0.mCMSAIOAction.a() == MODE.ACTION_MODE_RECORD_GIF)
        {
          localObject1 = ApolloBrickPlayerImpl.access$400((String)localObject2, ApolloBrickPlayerImpl.access$200(this.this$0), ApolloBrickPlayerImpl.access$300(this.this$0));
          ApolloAvatarFileManager.a().a(ApolloBrickPlayerImpl.access$500(this.this$0), (String)localObject2);
          BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0).edit().putString("sp_key_avatar_cmshow_face_gif_path" + ApolloBrickPlayerImpl.access$500(this.this$0), (String)localObject2).commit();
          ApolloBrickPlayerImpl.access$900(this.this$0).post(new ApolloBrickPlayerImpl.1.1(this, (URLDrawable)localObject1));
        }
      }
      do
      {
        return;
        localObject1 = ApolloBrickPlayerImpl.access$600((String)localObject2, ApolloBrickPlayerImpl.access$200(this.this$0));
        break;
        if (ApolloBrickPlayerImpl.access$1000(this.this$0) != null) {
          ApolloBrickPlayerImpl.access$1000(this.this$0).a();
        }
        ApolloBrickPlayerImpl.access$1002(this.this$0, new ApolloBrickPlayerImpl.BrickCMSPlayerListener(ApolloBrickPlayerImpl.access$500(this.this$0), ApolloBrickPlayerImpl.access$700(this.this$0), ApolloBrickPlayerImpl.access$1100(this.this$0), ApolloBrickPlayerImpl.access$1200(this.this$0), ApolloBrickPlayerImpl.access$300(this.this$0), ApolloBrickPlayerImpl.access$900(this.this$0), ApolloBrickPlayerImpl.access$200(this.this$0), ApolloBrickPlayerImpl.access$1300(this.this$0)));
        this.this$0.mCMSPlayer.a(null, this.this$0.mCMSAIOAction, ApolloBrickPlayerImpl.access$1000(this.this$0));
        if (ApolloBrickPlayerImpl.access$1400().containsKey(localObject1))
        {
          localObject2 = ApolloBrickPlayerImpl.access$1000(this.this$0);
          ThreadManager.getSubThreadHandler().post(new ApolloBrickPlayerImpl.1.2(this, (String)localObject1, (ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject2));
        }
        ApolloBrickPlayerImpl.access$900(this.this$0).post(new ApolloBrickPlayerImpl.1.3(this, bool));
      } while (!QLog.isColorLevel());
      QLog.d("ApolloBrickPlayer", 2, this + " start recordAction " + ApolloBrickPlayerImpl.access$500(this.this$0) + ", listener:" + ApolloBrickPlayerImpl.access$1000(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */