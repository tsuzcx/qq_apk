package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import java.util.Properties;
import vfy;
import vgd;
import vgh;
import vgv;

public class WSPlayerWrapper$1
  implements Runnable
{
  public WSPlayerWrapper$1(vgh paramvgh, vgv paramvgv) {}
  
  public void run()
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.a();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = vgd.a((String)localObject);
      if (localObject != null)
      {
        vgh.a(this.this$0, Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue());
        localObject = vgh.a(this.this$0);
        if (localObject != null) {
          ((vfy)localObject).a(this.this$0, vgh.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */