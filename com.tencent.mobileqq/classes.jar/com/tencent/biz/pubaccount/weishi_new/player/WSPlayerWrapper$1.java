package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import ukv;
import ulb;
import ulc;

public class WSPlayerWrapper$1
  implements Runnable
{
  public WSPlayerWrapper$1(ulc paramulc, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.getStreamDumpInfo();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ulb.a((String)localObject);
      if (localObject != null)
      {
        ulc.a(this.this$0, Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue());
        localObject = ulc.a(this.this$0);
        if (localObject != null) {
          ((ukv)localObject).a(this.this$0, ulc.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */