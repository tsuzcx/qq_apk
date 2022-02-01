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
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((IWSPlayer)localObject).a();
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = WSPlayerUtils.a((String)localObject);
    if (localObject == null) {
      return;
    }
    try
    {
      WSPlayerWrapper.a(this.this$0, Long.parseLong(((Properties)localObject).getProperty("VideoBitRate")));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      WSLog.d("WS_VIDEO_PLAYER", localNumberFormatException.getLocalizedMessage());
    }
    WSPlayerListenerAdapter localWSPlayerListenerAdapter = WSPlayerWrapper.a(this.this$0);
    if (localWSPlayerListenerAdapter != null)
    {
      WSPlayerWrapper localWSPlayerWrapper = this.this$0;
      localWSPlayerListenerAdapter.a(localWSPlayerWrapper, WSPlayerWrapper.a(localWSPlayerWrapper));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */