import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

class bgcx
  extends anyz
{
  bgcx(bgcu parambgcu) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    bgbe localbgbe = null;
    if ((bgcu.a(this.a) == null) || (bgcu.a(this.a).app == null) || (bgcu.a(this.a).hasDestory))
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
        Object localObject = bgcu.a(this.a).app.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
        paramList = localbgbe;
        if (localObject != null)
        {
          paramList = localbgbe;
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
        if (!bgcu.a(this.a).equalsIgnoreCase("" + l)) {
          break;
        }
        paramList = ((TroopManager)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_MANAGER)).b(bgcu.a(this.a));
        if (paramList == null) {
          break;
        }
        try
        {
          localObject = (bgbg)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          localbgbe = (bgbe)bgcu.a(this.a).app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
          localObject = ((bgbg)localObject).a(Long.valueOf(bgcu.a(this.a)));
          if (localObject != null)
          {
            ((bgbf)localObject).c(0);
            ((bgbf)localObject).d(0);
            ((bgbf)localObject).a(0L);
            localbgbe.a(bgcu.a(this.a), (int)paramList.dwGroupClassExt, null);
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
 * Qualified Name:     bgcx
 * JD-Core Version:    0.7.0.1
 */