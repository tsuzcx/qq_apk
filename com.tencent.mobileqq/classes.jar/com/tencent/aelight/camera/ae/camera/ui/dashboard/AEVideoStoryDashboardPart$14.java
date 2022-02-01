package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$14
  implements Observer<AEDashboardUtil.NetInfo>
{
  AEVideoStoryDashboardPart$14(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void a(@Nullable AEDashboardUtil.NetInfo paramNetInfo)
  {
    Object localObject = AEDashboardUtil.a(paramNetInfo);
    paramNetInfo = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AEDashboardUtil.NetInfo localNetInfo = (AEDashboardUtil.NetInfo)((Iterator)localObject).next();
      AEVideoStoryDashboardPart.DashboardInfo localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
      localDashboardInfo.a = AEVideoStoryDashboardPart.MessageRenderUtil.a(localNetInfo);
      paramNetInfo.add(localDashboardInfo);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.14.1(this, paramNetInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.14
 * JD-Core Version:    0.7.0.1
 */