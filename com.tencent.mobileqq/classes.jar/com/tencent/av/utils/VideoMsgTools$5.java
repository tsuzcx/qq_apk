package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addDiscussMember onReceiveResult, resultCode[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], chooserList[");
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = -1;
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.w("VideoMsgTools", 1, (String)localObject);
    if (paramInt != -1) {
      bool = false;
    }
    if (bool)
    {
      if (localArrayList == null) {
        return;
      }
      long l = paramBundle.getLong("roomId");
      VideoMsgTools.a(BaseApplicationImpl.getApplication(), bool, l, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.5
 * JD-Core Version:    0.7.0.1
 */