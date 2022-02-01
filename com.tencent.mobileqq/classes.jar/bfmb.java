import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class bfmb
  extends anqd
{
  bfmb(bfly parambfly) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if ((bfly.a(this.a) == null) || (bfly.a(this.a).a == null) || (bfly.a(this.a).M))
    {
      break label36;
      break label36;
      break label36;
      break label36;
    }
    for (;;)
    {
      label36:
      return;
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AppShortcutBarProcessor", 2, "onGetSystemMsgFin.success");
        }
        Object localObject = bfly.a(this.a).a.a().b(anhk.N, 0);
        bfkp localbfkp = null;
        paramList = localbfkp;
        if (localObject != null)
        {
          paramList = localbfkp;
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
        if (!bfly.a(this.a).equalsIgnoreCase("" + l)) {
          break;
        }
        paramList = ((TroopManager)bfly.a(this.a).a.getManager(52)).b(bfly.a(this.a));
        if (paramList == null) {
          break;
        }
        try
        {
          localObject = (bfkr)bfly.a(this.a).a.getManager(355);
          localbfkp = (bfkp)bfly.a(this.a).a.a(171);
          localObject = ((bfkr)localObject).a(Long.valueOf(bfly.a(this.a)));
          if (localObject != null)
          {
            ((bfkq)localObject).c(0);
            ((bfkq)localObject).d(0);
            ((bfkq)localObject).a(0L);
            localbfkp.a(bfly.a(this.a), (int)paramList.dwGroupClassExt);
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
 * Qualified Name:     bfmb
 * JD-Core Version:    0.7.0.1
 */