package com.tencent.av.ui;

import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class GAudioMembersCtrlActivity$2
  extends InviteMemberObserver
{
  GAudioMembersCtrlActivity$2(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new GAudioMembersCtrlActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.2
 * JD-Core Version:    0.7.0.1
 */