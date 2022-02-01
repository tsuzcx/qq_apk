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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131912909));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131912867));
      ShortVideoErrorReport.a(1, paramInt2);
      this.c.a.r = false;
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131912860));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
      ShortVideoResourceManager.b(HardCodeUtil.a(2131912830));
      ShortVideoErrorReport.a(1, paramInt2);
      this.c.a.r = false;
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.a, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131912822), null);
      ShortVideoResourceManager.a((QQAppInterface)this.a, (List)localObject, new TroopMemberApiService.IncomingHandler.6.1(this));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131912823));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject).toString(), null);
    ShortVideoResourceManager.b(HardCodeUtil.a(2131912859));
    ShortVideoErrorReport.a(1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.6
 * JD-Core Version:    0.7.0.1
 */