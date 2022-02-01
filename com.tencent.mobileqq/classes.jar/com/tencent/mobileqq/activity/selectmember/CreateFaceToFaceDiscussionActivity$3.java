package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

class CreateFaceToFaceDiscussionActivity$3
  implements Runnable
{
  CreateFaceToFaceDiscussionActivity$3(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.app != null)) {
      this.this$0.a.str_nick.set(this.this$0.app.getCurrentNickname());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.3
 * JD-Core Version:    0.7.0.1
 */