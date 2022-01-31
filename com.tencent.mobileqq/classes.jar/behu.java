import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class behu
  implements behy<oidb_0x8ed.RspBody>
{
  behu(behr parambehr, behy parambehy1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, behy parambehy2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.jdField_a_of_type_Behy != null) {
      this.jdField_a_of_type_Behy.a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.jdField_a_of_type_Behr.app.getManager(60);
    List localList = paramRspBody.a();
    if (localList != null) {
      localList.remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
    }
    paramRspBody.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    autg.a().a(this.jdField_a_of_type_Long);
    aush.a(this.jdField_a_of_type_Behr.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(ayvc.a()));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals("0"))) {
      this.jdField_a_of_type_Behr.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, 1);
    }
    this.jdField_a_of_type_Behr.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Behy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behu
 * JD-Core Version:    0.7.0.1
 */