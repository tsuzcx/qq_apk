import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class bdjc
  extends bdin
{
  bdjc(bdjb parambdjb) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.e != bdjb.a(this.a).uniseq) {
      return;
    }
    bdjb.a(this.a).saveExtInfoToExtStr("errorString", bdjb.a(this.a, paramTeamWorkFileImportInfo.f));
    bdjb.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.f));
    bdjb.a(this.a).a().a(bdjb.a(this.a).frienduin, bdjb.a(this.a).istroop, bdjb.a(this.a).uniseq);
    bdjb.a(this.a).removeObserver(bdjb.a(this.a));
    bdjb.a(this.a).a().a(bdjb.a(this.a).frienduin, bdjb.a(this.a).istroop, bdjb.a(this.a).uniseq, "extStr", bdjb.a(this.a).extStr);
    bdjb.a(this.a).a().a(bdjb.a(this.a).frienduin, bdjb.a(this.a).istroop, bdjb.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, bdjb.a(this.a).uniseq + " import file faild");
    bdjb.a(this.a).a().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.e != bdjb.a(this.a).uniseq) {}
    do
    {
      return;
      bdjb.a(this.a).removeObserver(bdjb.a(this.a));
      bdjb.a(this.a).mMsgUrl = paramString;
      bdjb.a(this.a).structingMsg.mMsgUrl = paramString;
      bdjb.a(this.a).msgData = bdjb.a(this.a).getBytes();
      bdjb.a(this.a).removeFlag(1);
      bdjb.a(this.a).removeFlag(2);
      bdjb.a(this.a).a().b(bdjb.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + bdjb.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjc
 * JD-Core Version:    0.7.0.1
 */