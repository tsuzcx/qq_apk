package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class VideoMsgTools$7
  extends ResultReceiver
{
  VideoMsgTools$7(Handler paramHandler, boolean paramBoolean, WeakReference paramWeakReference, int paramInt, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AudioHelper.a("selectMemberToStartGAudioChat", paramBundle);
    paramBundle = paramBundle.getParcelableArrayList("result_set");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectMemberToStartGAudioChat onReceiveResult, bVideo[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], resultCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], chooserList[");
    int i;
    if (paramBundle != null) {
      i = paramBundle.size();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w("VideoMsgTools", 1, localStringBuilder.toString());
    if (paramBundle != null) {
      i = paramBundle.size();
    } else {
      i = 0;
    }
    QAVGroupConfig.Report.a(i, this.a);
    if (paramBundle == null) {
      return;
    }
    if (paramInt == -1)
    {
      paramBundle = new VideoMsgTools.7.1(this, paramBundle);
      new Handler(Looper.getMainLooper()).post(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.7
 * JD-Core Version:    0.7.0.1
 */