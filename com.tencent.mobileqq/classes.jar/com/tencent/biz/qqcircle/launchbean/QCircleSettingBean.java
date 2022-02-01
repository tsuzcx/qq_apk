package com.tencent.biz.qqcircle.launchbean;

public class QCircleSettingBean
  extends QCircleInitBean
{
  private boolean canJumpProfile = true;
  private boolean canSyncTroopARK = true;
  
  public boolean canJumpProfile()
  {
    return this.canJumpProfile;
  }
  
  public boolean canSyncTroopARK()
  {
    return this.canSyncTroopARK;
  }
  
  public void setCanJumpProfile(boolean paramBoolean)
  {
    this.canJumpProfile = paramBoolean;
  }
  
  public void setCanSyncTroopARK(boolean paramBoolean)
  {
    this.canSyncTroopARK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launchbean.QCircleSettingBean
 * JD-Core Version:    0.7.0.1
 */