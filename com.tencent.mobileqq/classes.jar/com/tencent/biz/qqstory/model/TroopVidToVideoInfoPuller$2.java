package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class TroopVidToVideoInfoPuller$2
  implements BatchHandlerListPuller.IPullResultCallback
{
  TroopVidToVideoInfoPuller$2(TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller, List paramList) {}
  
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
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a(this.jdField_a_of_type_JavaUtilList, new ErrorMessage(), true, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller.2
 * JD-Core Version:    0.7.0.1
 */