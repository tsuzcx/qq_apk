package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.utils.AudioHelper;
import khq;
import khr;

public class VideoMsgTools$5$1
  extends ResultReceiver
{
  public VideoMsgTools$5$1(khq paramkhq, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AudioHelper.a("addGroupMember_" + this.a.jdField_a_of_type_Long, paramBundle);
    if (paramInt == -1)
    {
      paramBundle = new khr(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).postDelayed(paramBundle, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.5.1
 * JD-Core Version:    0.7.0.1
 */