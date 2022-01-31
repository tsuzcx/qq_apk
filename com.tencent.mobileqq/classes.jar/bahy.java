import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class bahy
  extends bahj
{
  bahy(bahx parambahx) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != bahx.a(this.a).uniseq) {
      return;
    }
    bahx.a(this.a).saveExtInfoToExtStr("errorString", bahx.a(this.a, paramTeamWorkFileImportInfo.f));
    bahx.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    bahx.a(this.a).a().a(bahx.a(this.a).frienduin, bahx.a(this.a).istroop, bahx.a(this.a).uniseq);
    bahx.a(this.a).removeObserver(bahx.a(this.a));
    bahx.a(this.a).a().a(bahx.a(this.a).frienduin, bahx.a(this.a).istroop, bahx.a(this.a).uniseq, "extStr", bahx.a(this.a).extStr);
    bahx.a(this.a).a().a(bahx.a(this.a).frienduin, bahx.a(this.a).istroop, bahx.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, bahx.a(this.a).uniseq + " import file faild");
    bahx.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != bahx.a(this.a).uniseq) {}
    do
    {
      return;
      bahx.a(this.a).removeObserver(bahx.a(this.a));
      bahx.a(this.a).mMsgUrl = paramString;
      bahx.a(this.a).structingMsg.mMsgUrl = paramString;
      bahx.a(this.a).msgData = bahx.a(this.a).getBytes();
      bahx.a(this.a).removeFlag(1);
      bahx.a(this.a).removeFlag(2);
      bahx.a(this.a).a().b(bahx.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + bahx.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahy
 * JD-Core Version:    0.7.0.1
 */