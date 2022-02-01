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
    paramArrayOfString = this.b.mHandler.obtainMessage(2);
    paramArrayOfString.arg1 = 1;
    paramArrayOfString.arg2 = 2131896965;
    paramArrayOfString.sendToTarget();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CreateFaceToFaceDiscussionActivity.access$700(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.9
 * JD-Core Version:    0.7.0.1
 */