import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class bfga
  implements bfdu
{
  public bfga(TroopAIORobotLayout paramTroopAIORobotLayout, int paramInt, String paramString1, String paramString2, String paramString3, bfft parambfft) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      bfdm localbfdm = RobotPanelLayoutBase.a();
      if (localbfdm == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList oldVer:" + this.jdField_a_of_type_Int + " newVer:" + paramInt);
      }
      if ((this.jdField_a_of_type_Int != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c = this.b;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b = this.c;
        localbfdm.a(this.b, this.jdField_a_of_type_JavaLangString, paramRspBody);
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() > 0) {
            TroopAIORobotLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b, localbfdm, true);
          }
          paramRspBody = this.jdField_a_of_type_Bfft;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() <= 0) {
            break label468;
          }
        }
      }
      for (;;)
      {
        paramRspBody.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopAIORobotLayout", 2, "listDatas is null in new version");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAIORobotLayout", 2, "item count == 0");
          }
          byte[] arrayOfByte = localbfdm.a(this.b, this.jdField_a_of_type_JavaLangString);
          if (arrayOfByte != null) {
            for (;;)
            {
              try
              {
                paramRspBody.mergeFrom(arrayOfByte);
                paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody);
                if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
                  break label424;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(false);
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(paramRspBody, true);
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c = this.b;
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.b = this.c;
              }
              catch (InvalidProtocolBufferMicroException paramRspBody) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopAIORobotLayout", 2, paramRspBody.getMessage());
              break;
              label424:
              if (QLog.isColorLevel()) {
                QLog.d("TroopAIORobotLayout", 2, "listDatas is null");
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopAIORobotLayout", 2, "data is null");
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.c();
        break;
        label468:
        bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList: errorCode = " + paramInt);
    }
    this.jdField_a_of_type_Bfft.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfga
 * JD-Core Version:    0.7.0.1
 */