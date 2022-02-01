package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class VidToVideoInfoPuller$5
  implements BatchHandlerListPuller.IPullResultCallback
{
  VidToVideoInfoPuller$5(VidToVideoInfoPuller paramVidToVideoInfoPuller, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Vid list to video info list finish !");
    String str;
    if (paramBoolean) {
      str = "Every task success";
    } else {
      str = "Some task error";
    }
    localStringBuilder.append(str);
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", localStringBuilder.toString());
    this.b.a(this.a, new ErrorMessage(), true, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.5
 * JD-Core Version:    0.7.0.1
 */