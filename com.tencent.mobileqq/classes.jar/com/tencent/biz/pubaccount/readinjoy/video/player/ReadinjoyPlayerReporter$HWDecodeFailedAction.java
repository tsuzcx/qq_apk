package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$HWDecodeFailedAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$HWDecodeFailedAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
    }
    this.a.a.jdField_f_of_type_Boolean = true;
    if ((paramObject instanceof String)) {
      this.a.a.jdField_f_of_type_JavaLangString = ((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.HWDecodeFailedAction
 * JD-Core Version:    0.7.0.1
 */