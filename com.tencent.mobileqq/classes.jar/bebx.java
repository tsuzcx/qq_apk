import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class bebx
  extends bebi
{
  bebx(bebw parambebw) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != bebw.a(this.a).uniseq) {
      return;
    }
    bebw.a(this.a).saveExtInfoToExtStr("errorString", bebw.a(this.a, paramTeamWorkFileImportInfo.f));
    bebw.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    bebw.a(this.a).a().a(bebw.a(this.a).frienduin, bebw.a(this.a).istroop, bebw.a(this.a).uniseq);
    bebw.a(this.a).removeObserver(bebw.a(this.a));
    bebw.a(this.a).a().a(bebw.a(this.a).frienduin, bebw.a(this.a).istroop, bebw.a(this.a).uniseq, "extStr", bebw.a(this.a).extStr);
    bebw.a(this.a).a().a(bebw.a(this.a).frienduin, bebw.a(this.a).istroop, bebw.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, bebw.a(this.a).uniseq + " import file faild");
    bebw.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != bebw.a(this.a).uniseq) {}
    do
    {
      return;
      bebw.a(this.a).removeObserver(bebw.a(this.a));
      bebw.a(this.a).mMsgUrl = paramString;
      bebw.a(this.a).structingMsg.mMsgUrl = paramString;
      bebw.a(this.a).msgData = bebw.a(this.a).getBytes();
      bebw.a(this.a).removeFlag(1);
      bebw.a(this.a).removeFlag(2);
      bebw.a(this.a).a().b(bebw.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + bebw.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebx
 * JD-Core Version:    0.7.0.1
 */