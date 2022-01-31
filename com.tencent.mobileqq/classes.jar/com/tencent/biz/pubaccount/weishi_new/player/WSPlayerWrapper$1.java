package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import thh;
import thn;
import tho;

public class WSPlayerWrapper$1
  implements Runnable
{
  public WSPlayerWrapper$1(tho paramtho, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.getStreamDumpInfo();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = thn.a((String)localObject);
      if (localObject != null)
      {
        tho.a(this.this$0, Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue());
        localObject = tho.a(this.this$0);
        if (localObject != null) {
          ((thh)localObject).a(this.this$0, tho.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */