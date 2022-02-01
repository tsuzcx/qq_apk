package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

class UidToVidListPuller$1
  implements BatchHandlerListPuller.IPullResultCallback
{
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      this.a.a.a(paramBoolean);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Finish !");
      String str;
      if (paramBoolean) {
        str = "Every task success";
      } else {
        str = "Some task error";
      }
      localStringBuilder.append(str);
      SLog.d("Q.qqstory.net:UidToVidListPuller", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UidToVidListPuller.1
 * JD-Core Version:    0.7.0.1
 */