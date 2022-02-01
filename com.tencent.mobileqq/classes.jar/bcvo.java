import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class bcvo
  extends bcuz
{
  bcvo(bcvn parambcvn) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != bcvn.a(this.a).uniseq) {
      return;
    }
    bcvn.a(this.a).saveExtInfoToExtStr("errorString", bcvn.a(this.a, paramTeamWorkFileImportInfo.f));
    bcvn.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    bcvn.a(this.a).getMsgCache().a(bcvn.a(this.a).frienduin, bcvn.a(this.a).istroop, bcvn.a(this.a).uniseq);
    bcvn.a(this.a).removeObserver(bcvn.a(this.a));
    bcvn.a(this.a).getMessageFacade().updateMsgFieldByUniseq(bcvn.a(this.a).frienduin, bcvn.a(this.a).istroop, bcvn.a(this.a).uniseq, "extStr", bcvn.a(this.a).extStr);
    bcvn.a(this.a).getMessageFacade().updateMsgExtraFlagByUniseq(bcvn.a(this.a).frienduin, bcvn.a(this.a).istroop, bcvn.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, bcvn.a(this.a).uniseq + " import file faild");
    bcvn.a(this.a).getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != bcvn.a(this.a).uniseq) {}
    do
    {
      return;
      bcvn.a(this.a).removeObserver(bcvn.a(this.a));
      bcvn.a(this.a).mMsgUrl = paramString;
      bcvn.a(this.a).structingMsg.mMsgUrl = paramString;
      bcvn.a(this.a).msgData = bcvn.a(this.a).getBytes();
      bcvn.a(this.a).removeFlag(1);
      bcvn.a(this.a).removeFlag(2);
      bcvn.a(this.a).getMessageFacade().sendMessage(bcvn.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + bcvn.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvo
 * JD-Core Version:    0.7.0.1
 */