package com.tencent.mobileqq.activity.aio.tips;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.studyroom.StudyRoomManager.TroopStudyMemberChangeObserver;
import mqq.os.MqqHandler;

class StudyRoomTipBarHelper$2
  implements StudyRoomManager.TroopStudyMemberChangeObserver
{
  StudyRoomTipBarHelper$2(StudyRoomTipBarHelper paramStudyRoomTipBarHelper) {}
  
  @UiThread
  private void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.a.c();
      return;
    }
    this.a.b();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, StudyRoomTipBarHelper.a(this.a).a.a)) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      StudyRoomTipBarHelper.a(this.a).post(new StudyRoomTipBarHelper.2.1(this, paramInt));
      return;
    }
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper.2
 * JD-Core Version:    0.7.0.1
 */