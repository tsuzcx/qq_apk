package com.tencent.mobileqq.activity.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.utils.NetworkUtil;

class CreateFaceToFaceDiscussionActivity$1
  extends BroadcastReceiver
{
  CreateFaceToFaceDiscussionActivity$1(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((NetworkUtil.isNetSupport(this.a.mContext)) && (this.a.isEnteredHall) && (this.a.isResume()))
    {
      if (this.a.mHandler.hasMessages(0)) {
        this.a.mHandler.removeMessages(0);
      }
      this.a.mHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.1
 * JD-Core Version:    0.7.0.1
 */