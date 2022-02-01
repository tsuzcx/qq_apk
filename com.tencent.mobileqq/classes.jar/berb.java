import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class berb
  extends beqy
{
  public berb(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  @Nullable
  public bera a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    bdyo localbdyo = bdyo.a(paramInt1, paramLong1, paramInt2);
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    Object localObject;
    if (!bfwk.a(paramList))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 17)
      {
        paramInt1 = 2131693998;
        if (paramList.size() <= 99) {
          break label366;
        }
        paramObject = "99+";
        label73:
        paramObject = ((Context)localObject).getString(paramInt1, new Object[] { paramObject });
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject == null) {
          break label492;
        }
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        if ((localObject == null) || (!((TroopInfo)localObject).hasOrgs())) {
          break label380;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label138:
      label184:
      label187:
      label235:
      boolean bool1;
      if (paramInt1 != 0)
      {
        if (paramList.size() == 1) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        }
      }
      else
      {
        paramList = paramObject;
        if (!MessageForQQWalletMsg.isRedPacketMsg(localMessageRecord)) {
          break label471;
        }
        paramList = (MessageForQQWalletMsg)localMessageRecord;
        if ((paramList.messageType != 7) && (paramList.messageType != 8)) {
          break label455;
        }
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718134);
        localbdyo.b = true;
        if ((localMessageRecord == null) || (!a(localMessageRecord, paramLong2, paramLong3))) {
          break label482;
        }
        paramObject = localMessageRecord.senderuin;
        bool1 = true;
      }
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_JavaLangString + ".troop.special_msg.special_attention";
          localStringBuilder = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
          if (localMessageRecord == null) {
            break label474;
          }
        }
        label455:
        label471:
        label474:
        for (boolean bool2 = true;; bool2 = false)
        {
          QLog.d((String)localObject, 2, bool2 + ", isShow = " + bool1);
          if (!bool1) {
            break label480;
          }
          return new bera(true, paramList, localbdyo, paramObject);
          paramInt1 = 2131698721;
          break;
          label366:
          paramObject = Integer.valueOf(paramList.size());
          break label73;
          label380:
          paramInt1 = 0;
          break label138;
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramList.size() + "", "", "");
          break label184;
          paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718566);
          break label187;
          paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718118);
          localbdyo.a = true;
          break label235;
        }
        label480:
        return null;
        label482:
        bool1 = false;
        paramObject = "";
      }
      label492:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berb
 * JD-Core Version:    0.7.0.1
 */