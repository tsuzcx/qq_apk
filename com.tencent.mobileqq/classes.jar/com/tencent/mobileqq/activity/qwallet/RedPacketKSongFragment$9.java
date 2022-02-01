package com.tencent.mobileqq.activity.qwallet;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

class RedPacketKSongFragment$9
  implements IPreloadService.OnGetPathListener
{
  RedPacketKSongFragment$9(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((!this.a.c()) && (paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      paramPathResult = AnimationView.AnimationInfo.loadFromFolder(paramPathResult.folderPath);
      this.a.a.post(new RedPacketKSongFragment.9.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.9
 * JD-Core Version:    0.7.0.1
 */