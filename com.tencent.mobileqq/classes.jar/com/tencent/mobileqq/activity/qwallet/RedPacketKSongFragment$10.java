package com.tencent.mobileqq.activity.qwallet;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class RedPacketKSongFragment$10
  implements IPreloadService.OnGetPathListener
{
  RedPacketKSongFragment$10(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      RedPacketKSongFragment.SongInfo localSongInfo = new RedPacketKSongFragment.SongInfo();
      localSongInfo.a = (paramPathResult.folderPath + "/" + "original.mp3");
      localSongInfo.b = (paramPathResult.folderPath + "/" + "accompany.mp3");
      localSongInfo.c = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      localSongInfo.d = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.a, localSongInfo);
      if (this.a.c()) {
        return;
      }
      this.a.getActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10
 * JD-Core Version:    0.7.0.1
 */