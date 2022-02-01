package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class NormalVideoDeliverController$4
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  NormalVideoDeliverController$4(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label95;
      }
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707595) + paramInt + "]", null);
      ShortVideoErrorReport.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label95:
      NormalVideoDeliverController.a(this.a, true);
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707594) + paramInt + "]", null);
    }
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707592), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController.4
 * JD-Core Version:    0.7.0.1
 */