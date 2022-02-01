package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
import com.tencent.aelight.camera.ae.view.TabLayout.OnTabSelectedCallback;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AECircleMultiUnit$1
  implements TabLayout.OnTabSelectedCallback
{
  AECircleMultiUnit$1(AECircleMultiUnit paramAECircleMultiUnit) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      AECircleMultiUnit.a(this.a).setCurrentItem(0, true);
      AECircleMultiUnit.a(this.a).f();
      AECircleMultiUnit.a(this.a).J();
      AEBaseDataReporter.a().ah();
    }
    else
    {
      AEReportUtils.a(8, 2);
      AECircleMultiUnit.a(this.a);
      AECircleMultiUnit.b(this.a);
    }
    AECircleMultiUnit localAECircleMultiUnit = this.a;
    AECircleMultiUnit.a(AECircleMultiUnit.a(localAECircleMultiUnit, AECircleMultiUnit.a(localAECircleMultiUnit)), AECircleMultiUnit.a(this.a));
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      if (AECircleMultiUnit.a(this.a)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit.1
 * JD-Core Version:    0.7.0.1
 */