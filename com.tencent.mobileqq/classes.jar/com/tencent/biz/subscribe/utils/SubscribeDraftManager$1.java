package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

class SubscribeDraftManager$1
  implements Runnable
{
  SubscribeDraftManager$1(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, String paramString3, String paramString4, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Object localObject = SubscribeDraftManager.a(this.this$0, this.a, this.b);
    if (localObject != null)
    {
      int i;
      if ((this.this$0.a((String)((Pair)localObject).first, this.c)) && (this.this$0.a((String)((Pair)localObject).second, this.d))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = this.e;
        if (localObject != null) {
          ((SubscribeDraftManager.SubDraftListener)localObject).a(3, true, this.b, new Object[0]);
        }
      }
      else
      {
        FileUtils.deleteFile((String)((Pair)localObject).first);
        FileUtils.deleteFile((String)((Pair)localObject).second);
        localObject = this.e;
        if (localObject != null) {
          ((SubscribeDraftManager.SubDraftListener)localObject).a(3, false, this.b, new Object[0]);
        }
      }
    }
    else
    {
      localObject = this.e;
      if (localObject != null) {
        ((SubscribeDraftManager.SubDraftListener)localObject).a(3, false, this.b, new Object[0]);
      }
      QLog.d(SubscribeDraftManager.a, 4, "modify new draft failed because cat't new folder");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */