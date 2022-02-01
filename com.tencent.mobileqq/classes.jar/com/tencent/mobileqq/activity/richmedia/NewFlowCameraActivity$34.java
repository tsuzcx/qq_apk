package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;

class NewFlowCameraActivity$34
  implements DialogInterface.OnClickListener
{
  NewFlowCameraActivity$34(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("video_shoot", "down_now", 0, 0, new String[0]);
    DynamicNowManager.d(null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.34
 * JD-Core Version:    0.7.0.1
 */