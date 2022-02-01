package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class VideoMsgTools$6
  extends ResultReceiver
{
  VideoMsgTools$6(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    int i = -1;
    AudioHelper.a("addMemberFromC2C", paramBundle);
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    }
    for (;;)
    {
      int j = paramBundle.getInt("result_uintype", 3000);
      ArrayList localArrayList = paramBundle.getParcelableArrayList("result_set");
      long l2 = paramBundle.getLong("roomId");
      long l1 = l2;
      if (j == 1) {
        paramBundle = paramBundle.getString("result_uin");
      }
      try
      {
        l1 = Long.parseLong(paramBundle);
        paramBundle = new StringBuilder().append("addMemberFromC2C onReceiveResult, resultCode[").append(paramInt).append("], chooserList[");
        paramInt = i;
        if (localArrayList != null) {
          paramInt = localArrayList.size();
        }
        QLog.w("double_2_multi", 1, paramInt + "], seq[" + this.a + "], uinType[" + j + "], roomId[" + l1 + "]");
        if ((!bool) || (localArrayList == null) || (l1 == 0L))
        {
          return;
          bool = false;
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          QLog.w("double_2_multi", 1, "addMemberFromC2C", paramBundle);
          l1 = l2;
        }
        VideoMsgTools.a(this.a, BaseApplicationImpl.getApplication(), j, bool, l1, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.6
 * JD-Core Version:    0.7.0.1
 */