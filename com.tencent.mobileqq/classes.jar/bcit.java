import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class bcit
  implements bcix<oidb_0x8ed.RspBody>
{
  bcit(bciq parambciq, bcix parambcix1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, bcix parambcix2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.jdField_a_of_type_Bcix != null) {
      this.jdField_a_of_type_Bcix.a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.jdField_a_of_type_Bciq.app.getManager(60);
    List localList = paramRspBody.a();
    if (localList != null) {
      localList.remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
    }
    paramRspBody.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    atch.a().a(this.jdField_a_of_type_Long);
    atbi.a(this.jdField_a_of_type_Bciq.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(awzy.a()));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals("0"))) {
      this.jdField_a_of_type_Bciq.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, 1);
    }
    this.jdField_a_of_type_Bciq.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Bcix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcit
 * JD-Core Version:    0.7.0.1
 */