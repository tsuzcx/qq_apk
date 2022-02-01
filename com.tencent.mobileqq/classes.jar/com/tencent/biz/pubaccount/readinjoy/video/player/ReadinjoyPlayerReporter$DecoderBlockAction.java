package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$DecoderBlockAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$DecoderBlockAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    paramObject = this.a.a;
    paramObject.p += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.DecoderBlockAction
 * JD-Core Version:    0.7.0.1
 */