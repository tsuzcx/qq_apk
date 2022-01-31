import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class axfn
  extends axey
{
  axfn(axfm paramaxfm) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != axfm.a(this.a).uniseq) {
      return;
    }
    axfm.a(this.a).saveExtInfoToExtStr("errorString", axfm.a(this.a, paramTeamWorkFileImportInfo.f));
    axfm.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    axfm.a(this.a).a().a(axfm.a(this.a).frienduin, axfm.a(this.a).istroop, axfm.a(this.a).uniseq);
    axfm.a(this.a).removeObserver(axfm.a(this.a));
    axfm.a(this.a).a().a(axfm.a(this.a).frienduin, axfm.a(this.a).istroop, axfm.a(this.a).uniseq, "extStr", axfm.a(this.a).extStr);
    axfm.a(this.a).a().a(axfm.a(this.a).frienduin, axfm.a(this.a).istroop, axfm.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, axfm.a(this.a).uniseq + " import file faild");
    axfm.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != axfm.a(this.a).uniseq) {}
    do
    {
      return;
      axfm.a(this.a).removeObserver(axfm.a(this.a));
      axfm.a(this.a).mMsgUrl = paramString;
      axfm.a(this.a).structingMsg.mMsgUrl = paramString;
      axfm.a(this.a).msgData = axfm.a(this.a).getBytes();
      axfm.a(this.a).removeFlag(1);
      axfm.a(this.a).removeFlag(2);
      axfm.a(this.a).a().b(axfm.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + axfm.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axfn
 * JD-Core Version:    0.7.0.1
 */