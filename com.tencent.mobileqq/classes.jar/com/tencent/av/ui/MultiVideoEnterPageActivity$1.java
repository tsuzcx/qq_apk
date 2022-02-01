package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$1
  implements MultiVideoMembersClickListener
{
  MultiVideoEnterPageActivity$1(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  private void b()
  {
    boolean bool;
    if ((!this.a.u.k().bg) && (!this.a.u.k().bh)) {
      bool = false;
    } else {
      bool = true;
    }
    MultiVideoEnterPageActivity localMultiVideoEnterPageActivity = this.a;
    VideoMsgTools.a(localMultiVideoEnterPageActivity, String.valueOf(localMultiVideoEnterPageActivity.u.k().aN), bool, false);
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MultiVideoMembersClickListener , Uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , videoScr = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , isNeedRequest ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" , positon = ");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.1
 * JD-Core Version:    0.7.0.1
 */