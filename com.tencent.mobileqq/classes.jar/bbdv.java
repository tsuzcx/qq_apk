import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class bbdv
  implements bfuf
{
  public bbdv(RobotChatPanelLayout paramRobotChatPanelLayout, long paramLong, int paramInt, String paramString, bfwg parambfwg) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0)
    {
      if (RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout) == null) {
        if (QLog.isColorLevel()) {
          QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
        }
      }
      do
      {
        return;
        if (paramRspBody.robot_uin.get() == this.jdField_a_of_type_Long) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("RobotChatPanelLayout", 2, "data not match :" + this.jdField_a_of_type_Long);
      return;
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("RobotChatPanelLayout", 2, "initData->reqPanelList oldVer:" + this.jdField_a_of_type_Int + " newVer:" + paramInt);
      }
      if (this.jdField_a_of_type_Int != paramInt)
      {
        RobotChatPanelLayout.b(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout).a("1", this.jdField_a_of_type_JavaLangString, paramRspBody);
        paramRspBody = RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(false);
          this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(paramRspBody, true);
          paramRspBody = this.jdField_a_of_type_Bfwg;
          if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() <= 0) {
            break label297;
          }
        }
      }
      for (;;)
      {
        paramRspBody.a(bool1, this.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(true);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RobotChatPanelLayout", 2, "listDatas is null in new version");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RobotChatPanelLayout", 2, "item count == 0");
          }
          RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_JavaLangString);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.c();
        break;
        label297:
        bool1 = false;
      }
    }
    RobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.b() > 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Bfwg.a(bool1, this.jdField_a_of_type_JavaLangString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "initData->reqPanelList: errorCode = " + paramInt + " hasdata:" + bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdv
 * JD-Core Version:    0.7.0.1
 */