import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class bfyh
  extends bfye
{
  public bfyh(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  @Nullable
  public bfyg a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    bffr localbffr = bffr.a(paramInt1, paramLong1, paramInt2);
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    Object localObject;
    if (!bhfc.a(paramList))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 17)
      {
        paramInt1 = 2131694189;
        if (paramList.size() <= 99) {
          break label367;
        }
        paramObject = "99+";
        label73:
        paramObject = ((Context)localObject).getString(paramInt1, new Object[] { paramObject });
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break label493;
        }
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        if ((localObject == null) || (!((TroopInfo)localObject).hasOrgs())) {
          break label381;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label139:
      label185:
      label188:
      label236:
      boolean bool1;
      if (paramInt1 != 0)
      {
        if (paramList.size() == 1) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        }
      }
      else
      {
        paramList = paramObject;
        if (!MessageForQQWalletMsg.isRedPacketMsg(localMessageRecord)) {
          break label472;
        }
        paramList = (MessageForQQWalletMsg)localMessageRecord;
        if ((paramList.messageType != 7) && (paramList.messageType != 8)) {
          break label456;
        }
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718519);
        localbffr.b = true;
        if ((localMessageRecord == null) || (!a(localMessageRecord, paramLong2, paramLong3))) {
          break label483;
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
            break label475;
          }
        }
        label456:
        label472:
        label475:
        for (boolean bool2 = true;; bool2 = false)
        {
          QLog.d((String)localObject, 2, bool2 + ", isShow = " + bool1);
          if (!bool1) {
            break label481;
          }
          return new bfyg(true, paramList, localbffr, paramObject);
          paramInt1 = 2131699043;
          break;
          label367:
          paramObject = Integer.valueOf(paramList.size());
          break label73;
          label381:
          paramInt1 = 0;
          break label139;
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramList.size() + "", "", "");
          break label185;
          paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718955);
          break label188;
          paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718503);
          localbffr.a = true;
          break label236;
        }
        label481:
        return null;
        label483:
        bool1 = false;
        paramObject = "";
      }
      label493:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyh
 * JD-Core Version:    0.7.0.1
 */