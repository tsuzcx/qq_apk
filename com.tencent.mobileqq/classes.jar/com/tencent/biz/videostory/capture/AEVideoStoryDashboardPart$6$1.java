package com.tencent.biz.videostory.capture;

import android.os.Bundle;
import android.widget.TextView;
import eipc.EIPCResult;
import wsj;
import wsp;

public class AEVideoStoryDashboardPart$6$1
  implements Runnable
{
  public AEVideoStoryDashboardPart$6$1(wsp paramwsp, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    wsj.a(this.jdField_a_of_type_Wsp.a).setText(this.jdField_a_of_type_EipcEIPCResult.data.getString("KEY_ENV_INFO"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEVideoStoryDashboardPart.6.1
 * JD-Core Version:    0.7.0.1
 */