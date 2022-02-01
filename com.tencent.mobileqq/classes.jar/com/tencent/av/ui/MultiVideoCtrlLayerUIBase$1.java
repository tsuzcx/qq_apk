package com.tencent.av.ui;

import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiVideoCtrlLayerUIBase$1
  extends InviteMemberObserver
{
  MultiVideoCtrlLayerUIBase$1(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new MultiVideoCtrlLayerUIBase.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.1
 * JD-Core Version:    0.7.0.1
 */