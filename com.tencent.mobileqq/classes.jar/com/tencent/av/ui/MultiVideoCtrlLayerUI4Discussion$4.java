package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class MultiVideoCtrlLayerUI4Discussion$4
  implements QavInOutAnimation.QavOutAnimationListener
{
  MultiVideoCtrlLayerUI4Discussion$4(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void a()
  {
    MultiVideoCtrlLayerUI4Discussion localMultiVideoCtrlLayerUI4Discussion = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion;
    localMultiVideoCtrlLayerUI4Discussion.j = true;
    localMultiVideoCtrlLayerUI4Discussion.O();
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a();
    if (localSessionInfo != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TYPE_NOTIFY_CAMERA_CLOSE 2: ");
      localStringBuilder.append(localSessionInfo.j);
      localStringBuilder.append("|");
      localStringBuilder.append(localSessionInfo.d);
      AVLog.printAllUserLog(str, localStringBuilder.toString());
      if (localSessionInfo.j) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.e(true);
    ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
    if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a == 1)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    } else if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.4
 * JD-Core Version:    0.7.0.1
 */