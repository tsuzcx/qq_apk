import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.2.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class bckf
  extends bcoc
{
  bckf(bcka parambcka, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState = paramRspBody.uint32_play_state.get();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "checkInteract interactId: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId + ", interactState: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState == 2) && (paramRspBody.msg_finish_info.has()))
      {
        paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactText = paramRspBody.bytes_text.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.participateNum = paramRspBody.uint32_participate_num.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstUin = paramRspBody.uint64_first_uin.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
        this.jdField_a_of_type_Bcka.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcka.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.2.1(this));
      return;
      List localList = (List)this.jdField_a_of_type_Bcka.c.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
      paramRspBody = localList;
      if (localList == null)
      {
        paramRspBody = new ArrayList();
        this.jdField_a_of_type_Bcka.c.put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, paramRspBody);
      }
      try
      {
        if (!paramRspBody.contains(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips))
        {
          paramRspBody.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          if (paramRspBody.size() > 5) {
            paramRspBody.remove(0);
          }
        }
        paramRspBody = (List)this.jdField_a_of_type_Bcka.b.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
        if (paramRspBody == null) {}
      }
      finally
      {
        try
        {
          paramRspBody.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          bcka.b(this.jdField_a_of_type_Bcka);
          this.jdField_a_of_type_Bcka.notifyObservers(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          break;
        }
        finally {}
        localObject1 = finally;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AIOAnimationControlManager", 2, "checkInteract errorCode: " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckf
 * JD-Core Version:    0.7.0.1
 */