package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class NormalVideoDeliverController$3
  implements ShortVideoResourceStatus.ISVConfig
{
  NormalVideoDeliverController$3(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707599) + paramInt2 + "]", null);
        ShortVideoErrorReport.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(NormalVideoDeliverController.a(this.a), localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707596), null);
        ShortVideoResourceManager.a(NormalVideoDeliverController.a(this.a), localArrayList, this.a.a);
        return;
      }
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707597) + paramInt1 + "]", null);
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707590) + paramInt2 + "]", null);
    ShortVideoErrorReport.a(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController.3
 * JD-Core Version:    0.7.0.1
 */