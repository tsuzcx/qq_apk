package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class MultiVideoCtrlLayerUI4NewGroupChat$2
  implements QavInOutAnimation.QavOutAnimationListener
{
  MultiVideoCtrlLayerUI4NewGroupChat$2(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat, long paramLong) {}
  
  public void a()
  {
    MultiVideoCtrlLayerUI4NewGroupChat localMultiVideoCtrlLayerUI4NewGroupChat = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat;
    localMultiVideoCtrlLayerUI4NewGroupChat.j = true;
    localMultiVideoCtrlLayerUI4NewGroupChat.O();
  }
  
  public void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
    if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.a.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.a.a().c.get(0)).a == 1)) {
      ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
    } else if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.a.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.a.a().c.get(0)).a == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.a.a();
    if (localSessionInfo != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TYPE_NOTIFY_CAMERA_CLOSE: ");
      localStringBuilder.append(localSessionInfo.j);
      localStringBuilder.append("|");
      localStringBuilder.append(localSessionInfo.d);
      AVLog.printAllUserLog(str, localStringBuilder.toString());
      if (localSessionInfo.j) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.b.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      }
    }
    MultiVideoCtrlLayerUI4NewGroupChat.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat, this.jdField_a_of_type_Long);
    MultiVideoCtrlLayerUI4NewGroupChat.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat, true);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4NewGroupChat.j = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.2
 * JD-Core Version:    0.7.0.1
 */