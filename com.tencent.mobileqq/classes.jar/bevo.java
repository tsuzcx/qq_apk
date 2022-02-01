import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class bevo
  extends amwl
{
  bevo(bevl parambevl) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    bety localbety = null;
    if ((bevl.a(this.a) == null) || (bevl.a(this.a).app == null) || (bevl.a(this.a).hasDestory))
    {
      break label39;
      break label39;
      break label39;
      break label39;
    }
    for (;;)
    {
      label39:
      return;
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AppShortcutBarProcessor", 2, "onGetSystemMsgFin.success");
        }
        Object localObject = bevl.a(this.a).app.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
        paramList = localbety;
        if (localObject != null)
        {
          paramList = localbety;
          if (((List)localObject).size() - 1 >= 0) {
            paramList = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
          }
        }
        if ((paramList == null) || (!(paramList instanceof MessageForSystemMsg))) {
          break;
        }
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList.msg_type.get() != 2) || (paramList.msg.get() == null)) {
          break;
        }
        int i = paramList.msg.group_msg_type.get();
        if ((i != 3) && (i != 15)) {
          break;
        }
        long l = paramList.msg.group_code.get();
        if (!bevl.a(this.a).equalsIgnoreCase("" + l)) {
          break;
        }
        paramList = ((TroopManager)bevl.a(this.a).app.getManager(52)).b(bevl.a(this.a));
        if (paramList == null) {
          break;
        }
        try
        {
          localObject = (beua)bevl.a(this.a).app.getManager(355);
          localbety = (bety)bevl.a(this.a).app.getBusinessHandler(171);
          localObject = ((beua)localObject).a(Long.valueOf(bevl.a(this.a)));
          if (localObject != null)
          {
            ((betz)localObject).c(0);
            ((betz)localObject).d(0);
            ((betz)localObject).a(0L);
            localbety.a(bevl.a(this.a), (int)paramList.dwGroupClassExt, null);
            return;
          }
        }
        catch (Exception paramList)
        {
          QLog.e("AppShortcutBarProcessor", 1, paramList.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bevo
 * JD-Core Version:    0.7.0.1
 */