package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;

class GetGeneralSettings$MyRoamSettingObserver
  extends RoamSettingObserver
{
  private GetGeneralSettings$MyRoamSettingObserver(GetGeneralSettings paramGetGeneralSettings) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.a.mAutomator.b = 3;
      this.a.setResult(7);
      return;
    }
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings.MyRoamSettingObserver
 * JD-Core Version:    0.7.0.1
 */