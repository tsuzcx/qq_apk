import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class ayfs
  extends ayfd
{
  ayfs(ayfr paramayfr) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != ayfr.a(this.a).uniseq) {
      return;
    }
    ayfr.a(this.a).saveExtInfoToExtStr("errorString", ayfr.a(this.a, paramTeamWorkFileImportInfo.f));
    ayfr.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    ayfr.a(this.a).a().a(ayfr.a(this.a).frienduin, ayfr.a(this.a).istroop, ayfr.a(this.a).uniseq);
    ayfr.a(this.a).removeObserver(ayfr.a(this.a));
    ayfr.a(this.a).a().a(ayfr.a(this.a).frienduin, ayfr.a(this.a).istroop, ayfr.a(this.a).uniseq, "extStr", ayfr.a(this.a).extStr);
    ayfr.a(this.a).a().a(ayfr.a(this.a).frienduin, ayfr.a(this.a).istroop, ayfr.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, ayfr.a(this.a).uniseq + " import file faild");
    ayfr.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != ayfr.a(this.a).uniseq) {}
    do
    {
      return;
      ayfr.a(this.a).removeObserver(ayfr.a(this.a));
      ayfr.a(this.a).mMsgUrl = paramString;
      ayfr.a(this.a).structingMsg.mMsgUrl = paramString;
      ayfr.a(this.a).msgData = ayfr.a(this.a).getBytes();
      ayfr.a(this.a).removeFlag(1);
      ayfr.a(this.a).removeFlag(2);
      ayfr.a(this.a).a().b(ayfr.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + ayfr.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfs
 * JD-Core Version:    0.7.0.1
 */