package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import mqq.app.QQPermissionCallback;

class CreateFaceToFaceDiscussionActivity$9
  implements QQPermissionCallback
{
  CreateFaceToFaceDiscussionActivity$9(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.mHandler.obtainMessage(2);
    paramArrayOfString.arg1 = 1;
    paramArrayOfString.arg2 = 2131698973;
    paramArrayOfString.sendToTarget();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CreateFaceToFaceDiscussionActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.9
 * JD-Core Version:    0.7.0.1
 */