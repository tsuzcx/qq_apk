package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

class UidToVidListPuller$1
  implements BatchHandlerListPuller.IPullResultCallback
{
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this.a.a != null)
    {
      this.a.a.a(paramBoolean);
      localStringBuilder = new StringBuilder().append("Finish !");
      if (!paramBoolean) {
        break label57;
      }
    }
    label57:
    for (String str = "Every task success";; str = "Some task error")
    {
      SLog.d("Q.qqstory.net:UidToVidListPuller", str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UidToVidListPuller.1
 * JD-Core Version:    0.7.0.1
 */