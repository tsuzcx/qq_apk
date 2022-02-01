import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class becn
  extends beby
{
  becn(becm parambecm) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != becm.a(this.a).uniseq) {
      return;
    }
    becm.a(this.a).saveExtInfoToExtStr("errorString", becm.a(this.a, paramTeamWorkFileImportInfo.f));
    becm.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    becm.a(this.a).getMsgCache().a(becm.a(this.a).frienduin, becm.a(this.a).istroop, becm.a(this.a).uniseq);
    becm.a(this.a).removeObserver(becm.a(this.a));
    becm.a(this.a).getMessageFacade().updateMsgFieldByUniseq(becm.a(this.a).frienduin, becm.a(this.a).istroop, becm.a(this.a).uniseq, "extStr", becm.a(this.a).extStr);
    becm.a(this.a).getMessageFacade().updateMsgExtraFlagByUniseq(becm.a(this.a).frienduin, becm.a(this.a).istroop, becm.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, becm.a(this.a).uniseq + " import file faild");
    becm.a(this.a).getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != becm.a(this.a).uniseq) {}
    do
    {
      return;
      becm.a(this.a).removeObserver(becm.a(this.a));
      becm.a(this.a).mMsgUrl = paramString;
      becm.a(this.a).structingMsg.mMsgUrl = paramString;
      becm.a(this.a).msgData = becm.a(this.a).getBytes();
      becm.a(this.a).removeFlag(1);
      becm.a(this.a).removeFlag(2);
      becm.a(this.a).getMessageFacade().sendMessage(becm.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + becm.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becn
 * JD-Core Version:    0.7.0.1
 */