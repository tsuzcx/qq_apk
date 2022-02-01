import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class bikw
  implements bila<oidb_0x8ed.RspBody>
{
  bikw(bikt parambikt, bila parambila1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, bila parambila2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.jdField_a_of_type_Bila != null) {
      this.jdField_a_of_type_Bila.a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.jdField_a_of_type_Bikt.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    List localList = paramRspBody.a();
    if (localList != null) {
      localList.remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
    }
    paramRspBody.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    axrb.a().a(this.jdField_a_of_type_Long);
    axqc.a(this.jdField_a_of_type_Bikt.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(bcrg.a()));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals("0"))) {
      this.jdField_a_of_type_Bikt.app.getMessageFacade().clearHistory(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, 1);
    }
    this.jdField_a_of_type_Bikt.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Bila);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikw
 * JD-Core Version:    0.7.0.1
 */