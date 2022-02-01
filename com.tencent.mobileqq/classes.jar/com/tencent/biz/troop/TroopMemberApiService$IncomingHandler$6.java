package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class TroopMemberApiService$IncomingHandler$6
  implements ShortVideoResourceStatus.ISVConfig
{
  TroopMemberApiService$IncomingHandler$6(TroopMemberApiService.IncomingHandler paramIncomingHandler, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715459) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131715429));
        ShortVideoErrorReport.a(1, paramInt2);
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715420), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new TroopMemberApiService.IncomingHandler.6.1(this));
        return;
      }
      VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715421) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131715458));
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715509) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131715466));
    ShortVideoErrorReport.a(1, paramInt2);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.6
 * JD-Core Version:    0.7.0.1
 */