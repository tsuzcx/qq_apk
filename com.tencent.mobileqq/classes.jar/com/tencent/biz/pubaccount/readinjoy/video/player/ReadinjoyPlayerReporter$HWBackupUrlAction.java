package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$HWBackupUrlAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$HWBackupUrlAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    }
    this.a.a.g = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.HWBackupUrlAction
 * JD-Core Version:    0.7.0.1
 */