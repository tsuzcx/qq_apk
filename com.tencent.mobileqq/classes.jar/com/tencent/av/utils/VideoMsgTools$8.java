package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mtq;

final class VideoMsgTools$8
  extends ResultReceiver
{
  VideoMsgTools$8(Handler paramHandler, long paramLong, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool3 = true;
    AudioHelper.a("addGroupMember_" + this.jdField_a_of_type_Long, paramBundle);
    ArrayList localArrayList2 = paramBundle.getParcelableArrayList("result_set");
    Object localObject = new StringBuilder().append("addGroupMember onReceiveResult, resultCode[").append(paramInt).append("], chooserList[");
    int i;
    boolean bool1;
    label99:
    boolean bool2;
    if (localArrayList2 != null)
    {
      i = localArrayList2.size();
      QLog.w("VideoMsgTools", 1, i + "]");
      if (paramInt != -1) {
        break label241;
      }
      bool1 = true;
      if ((bool1) && (localArrayList2 != null))
      {
        ArrayList localArrayList1 = paramBundle.getParcelableArrayList("result_set_for_out_Member ");
        localObject = localArrayList1;
        if (localArrayList1 == null) {
          localObject = new ArrayList();
        }
        if (localArrayList2.size() <= ((ArrayList)localObject).size()) {
          break label247;
        }
        bool2 = true;
        label151:
        if (((ArrayList)localObject).size() <= 0) {
          break label253;
        }
      }
    }
    for (;;)
    {
      mtq.d(bool2, bool3);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new VideoMsgTools.MygetGroupInfoRunnable(this.jdField_a_of_type_Long, (QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).postDelayed((Runnable)localObject, 1000L);
      long l = paramBundle.getLong("roomId");
      VideoMsgTools.a(BaseApplicationImpl.getApplication(), bool1, l, localArrayList2);
      return;
      i = -1;
      break;
      label241:
      bool1 = false;
      break label99;
      label247:
      bool2 = false;
      break label151;
      label253:
      bool3 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.8
 * JD-Core Version:    0.7.0.1
 */