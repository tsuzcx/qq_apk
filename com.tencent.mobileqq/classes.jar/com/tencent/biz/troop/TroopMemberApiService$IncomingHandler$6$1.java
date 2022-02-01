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
        localStringBuilder.append(HardCodeUtil.a(2131715333));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("TroopMemberApiService", localStringBuilder.toString(), null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131715387));
        ShortVideoErrorReport.a(2, paramInt);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
      }
      else
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", -2);
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
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(93, this.a.jdField_a_of_type_AndroidOsBundle);
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
  }
  
  public void onNetWorkNone()
  {
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.6.1
 * JD-Core Version:    0.7.0.1
 */