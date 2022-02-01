package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import mqq.os.MqqHandler;

class RedPacketEmojiFragment$3
  implements IPreloadService.OnGetPathListener
{
  RedPacketEmojiFragment$3(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    ThreadManager.getUIHandler().post(new RedPacketEmojiFragment.3.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3
 * JD-Core Version:    0.7.0.1
 */