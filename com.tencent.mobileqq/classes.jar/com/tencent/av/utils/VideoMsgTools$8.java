package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class VideoMsgTools$8
  extends ResultReceiver
{
  VideoMsgTools$8(Handler paramHandler, long paramLong, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addGroupMember_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    AudioHelper.a(((StringBuilder)localObject).toString(), paramBundle);
    ArrayList localArrayList2 = paramBundle.getParcelableArrayList("result_set");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addGroupMember onReceiveResult, resultCode[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], chooserList[");
    int i;
    if (localArrayList2 != null) {
      i = localArrayList2.size();
    } else {
      i = -1;
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    boolean bool3 = false;
    boolean bool1;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool1) && (localArrayList2 != null))
    {
      ArrayList localArrayList1 = paramBundle.getParcelableArrayList("result_set_for_out_Member ");
      localObject = localArrayList1;
      if (localArrayList1 == null) {
        localObject = new ArrayList();
      }
      boolean bool2;
      if (localArrayList2.size() > ((ArrayList)localObject).size()) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (((ArrayList)localObject).size() > 0) {
        bool3 = true;
      }
      DataReport.d(bool2, bool3);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new VideoMsgTools.MygetGroupInfoRunnable(this.jdField_a_of_type_Long, (QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).postDelayed((Runnable)localObject, 1000L);
      long l = paramBundle.getLong("roomId");
      VideoMsgTools.a(BaseApplicationImpl.getApplication(), bool1, l, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.8
 * JD-Core Version:    0.7.0.1
 */