package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import java.util.Comparator;

final class AEDashboardUtil$4
  implements Comparator<AEDashboardUtil.BinaryInfo>
{
  public int a(AEDashboardUtil.BinaryInfo paramBinaryInfo1, AEDashboardUtil.BinaryInfo paramBinaryInfo2)
  {
    if (paramBinaryInfo1.b) {
      return 1;
    }
    if (paramBinaryInfo2.b) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.4
 * JD-Core Version:    0.7.0.1
 */