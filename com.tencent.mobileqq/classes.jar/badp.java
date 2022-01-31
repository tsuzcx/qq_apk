import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class badp
  extends bada
{
  badp(bado parambado) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != bado.a(this.a).uniseq) {
      return;
    }
    bado.a(this.a).saveExtInfoToExtStr("errorString", bado.a(this.a, paramTeamWorkFileImportInfo.f));
    bado.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    bado.a(this.a).a().a(bado.a(this.a).frienduin, bado.a(this.a).istroop, bado.a(this.a).uniseq);
    bado.a(this.a).removeObserver(bado.a(this.a));
    bado.a(this.a).a().a(bado.a(this.a).frienduin, bado.a(this.a).istroop, bado.a(this.a).uniseq, "extStr", bado.a(this.a).extStr);
    bado.a(this.a).a().a(bado.a(this.a).frienduin, bado.a(this.a).istroop, bado.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, bado.a(this.a).uniseq + " import file faild");
    bado.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != bado.a(this.a).uniseq) {}
    do
    {
      return;
      bado.a(this.a).removeObserver(bado.a(this.a));
      bado.a(this.a).mMsgUrl = paramString;
      bado.a(this.a).structingMsg.mMsgUrl = paramString;
      bado.a(this.a).msgData = bado.a(this.a).getBytes();
      bado.a(this.a).removeFlag(1);
      bado.a(this.a).removeFlag(2);
      bado.a(this.a).a().b(bado.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + bado.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badp
 * JD-Core Version:    0.7.0.1
 */