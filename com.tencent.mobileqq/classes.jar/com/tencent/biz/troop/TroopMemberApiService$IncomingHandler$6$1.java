package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class TroopMemberApiService$IncomingHandler$6$1
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  TroopMemberApiService$IncomingHandler$6$1(TroopMemberApiService.IncomingHandler.6 param6) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131912813));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("TroopMemberApiService", localStringBuilder.toString(), null);
        ShortVideoResourceManager.b(HardCodeUtil.a(2131912866));
        ShortVideoErrorReport.a(2, paramInt);
        this.a.b.putInt("result", 0);
      }
      else
      {
        this.a.b.putInt("result", -2);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("TroopMemberApiService", localStringBuilder.toString(), null);
    this.a.c.a.a(93, this.a.b);
    this.a.c.a.r = false;
  }
  
  public void onNetWorkNone()
  {
    this.a.c.a.r = false;
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.6.1
 * JD-Core Version:    0.7.0.1
 */