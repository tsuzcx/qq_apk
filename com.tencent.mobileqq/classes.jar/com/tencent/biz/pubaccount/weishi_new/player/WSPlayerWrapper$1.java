package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import java.util.Properties;
import urq;
import urv;
import urw;
import usk;

public class WSPlayerWrapper$1
  implements Runnable
{
  public WSPlayerWrapper$1(urw paramurw, usk paramusk) {}
  
  public void run()
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.a();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = urv.a((String)localObject);
      if (localObject != null)
      {
        urw.a(this.this$0, Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue());
        localObject = urw.a(this.this$0);
        if (localObject != null) {
          ((urq)localObject).a(this.this$0, urw.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */