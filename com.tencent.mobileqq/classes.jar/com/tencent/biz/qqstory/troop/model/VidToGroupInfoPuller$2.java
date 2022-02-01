package com.tencent.biz.qqstory.troop.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

class VidToGroupInfoPuller$2
  implements BatchHandlerListPuller.IPullResultCallback
{
  VidToGroupInfoPuller$2(VidToGroupInfoPuller paramVidToGroupInfoPuller) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("StoryId list to group info list finish !");
    if (paramBoolean) {}
    for (String str = "Every task success";; str = "Some task error")
    {
      SLog.d("Q.qqstory.net:VidToGroupInfoPuller", str);
      this.a.a(this.a.jdField_a_of_type_JavaUtilList, new ErrorMessage(), true, paramBoolean);
      this.a.jdField_a_of_type_Int = 2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.VidToGroupInfoPuller.2
 * JD-Core Version:    0.7.0.1
 */