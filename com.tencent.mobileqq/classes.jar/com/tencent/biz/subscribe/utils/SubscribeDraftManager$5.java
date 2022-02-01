package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.util.Pair;

class SubscribeDraftManager$5
  implements Runnable
{
  SubscribeDraftManager$5(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Object localObject = SubscribeDraftManager.a(this.this$0, this.a, this.b);
    if (localObject != null)
    {
      localObject = SubscribeDraftManager.a(this.this$0, (String)((Pair)localObject).first);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        SubscribeDraftManager.SubDraftListener localSubDraftListener = this.c;
        if (localSubDraftListener != null) {
          localSubDraftListener.a(6, true, this.b, new Object[] { localObject });
        }
      }
      else
      {
        localObject = this.c;
        if (localObject != null) {
          ((SubscribeDraftManager.SubDraftListener)localObject).a(6, false, this.b, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.5
 * JD-Core Version:    0.7.0.1
 */