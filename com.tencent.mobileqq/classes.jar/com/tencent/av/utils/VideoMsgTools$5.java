package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class VideoMsgTools$5
  extends ResultReceiver
{
  VideoMsgTools$5(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AudioHelper.a("addDiscussMember", paramBundle);
    ArrayList localArrayList = paramBundle.getParcelableArrayList("result_set");
    StringBuilder localStringBuilder = new StringBuilder().append("addDiscussMember onReceiveResult, resultCode[").append(paramInt).append("], chooserList[");
    int i;
    if (localArrayList != null)
    {
      i = localArrayList.size();
      QLog.w("VideoMsgTools", 1, i + "]");
      if (paramInt != -1) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (localArrayList != null)) {
        break label98;
      }
      return;
      i = -1;
      break;
    }
    label98:
    long l = paramBundle.getLong("roomId");
    VideoMsgTools.a(BaseApplicationImpl.getApplication(), bool, l, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.5
 * JD-Core Version:    0.7.0.1
 */