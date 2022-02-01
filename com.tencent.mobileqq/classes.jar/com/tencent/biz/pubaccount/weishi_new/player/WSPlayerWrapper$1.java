package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.Properties;

class WSPlayerWrapper$1
  implements Runnable
{
  WSPlayerWrapper$1(WSPlayerWrapper paramWSPlayerWrapper, IWSPlayer paramIWSPlayer) {}
  
  public void run()
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.a();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      localObject = WSPlayerUtils.a((String)localObject);
      if (localObject == null) {
        continue;
      }
      try
      {
        WSPlayerWrapper.a(this.this$0, Long.parseLong(((Properties)localObject).getProperty("VideoBitRate")));
        localObject = WSPlayerWrapper.a(this.this$0);
        if (localObject == null) {
          continue;
        }
        ((WSPlayerListenerAdapter)localObject).a(this.this$0, WSPlayerWrapper.a(this.this$0));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          WSLog.d("WS_VIDEO_PLAYER", localNumberFormatException.getLocalizedMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */