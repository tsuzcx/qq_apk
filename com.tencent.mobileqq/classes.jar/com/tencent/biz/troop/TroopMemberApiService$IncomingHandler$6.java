package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

class TroopMemberApiService$IncomingHandler$6
  implements ShortVideoResourceStatus.ISVConfig
{
  TroopMemberApiService$IncomingHandler$6(TroopMemberApiService.IncomingHandler paramIncomingHandler, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715431));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131715388));
      ShortVideoErrorReport.a(1, paramInt2);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715381));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131715351));
      ShortVideoErrorReport.a(1, paramInt2);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.b = false;
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715342), null);
      ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, (List)localObject, new TroopMemberApiService.IncomingHandler.6.1(this));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131715343));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131715380));
    ShortVideoErrorReport.a(1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.6
 * JD-Core Version:    0.7.0.1
 */