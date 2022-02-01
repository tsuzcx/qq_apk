package com.tencent.biz.qcircleshadow.lib;

import bmoj;
import org.jetbrains.annotations.Nullable;

final class QCircleHostLauncher$1
  implements bmoj
{
  QCircleHostLauncher$1(QCircleHostLauncher.InnerVasRewardAdCallback paramInnerVasRewardAdCallback) {}
  
  public void onReward(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    this.val$rewardCallback.onReward(paramInt, paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher.1
 * JD-Core Version:    0.7.0.1
 */