import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class ayfq
  extends ayfb
{
  ayfq(ayfp paramayfp) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != ayfp.a(this.a).uniseq) {
      return;
    }
    ayfp.a(this.a).saveExtInfoToExtStr("errorString", ayfp.a(this.a, paramTeamWorkFileImportInfo.f));
    ayfp.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    ayfp.a(this.a).a().a(ayfp.a(this.a).frienduin, ayfp.a(this.a).istroop, ayfp.a(this.a).uniseq);
    ayfp.a(this.a).removeObserver(ayfp.a(this.a));
    ayfp.a(this.a).a().a(ayfp.a(this.a).frienduin, ayfp.a(this.a).istroop, ayfp.a(this.a).uniseq, "extStr", ayfp.a(this.a).extStr);
    ayfp.a(this.a).a().a(ayfp.a(this.a).frienduin, ayfp.a(this.a).istroop, ayfp.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, ayfp.a(this.a).uniseq + " import file faild");
    ayfp.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != ayfp.a(this.a).uniseq) {}
    do
    {
      return;
      ayfp.a(this.a).removeObserver(ayfp.a(this.a));
      ayfp.a(this.a).mMsgUrl = paramString;
      ayfp.a(this.a).structingMsg.mMsgUrl = paramString;
      ayfp.a(this.a).msgData = ayfp.a(this.a).getBytes();
      ayfp.a(this.a).removeFlag(1);
      ayfp.a(this.a).removeFlag(2);
      ayfp.a(this.a).a().b(ayfp.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + ayfp.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfq
 * JD-Core Version:    0.7.0.1
 */