import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bgjg
  extends aojs
{
  bgjg(bgjf parambgjf) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onUpdateTroopGetMemberList troopUin=" + paramString + " isSuccess=" + paramBoolean + " reqType=" + paramInt1 + " type" + paramInt2 + " reqTimestamp=" + paramLong);
    }
    if (paramInt1 != 2) {}
    do
    {
      return;
      if ((paramString != null) && (paramString.equals(bgjf.a(this.a).a))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList troopUin =" + paramString + " mSession.troopUin=" + bgjf.a(this.a).a);
    return;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append(" onUpdateTroopGetMemberList troopMemberInfoList =");
        if (paramList != null) {
          break label224;
        }
      }
      label224:
      for (paramInt1 = 0;; paramInt1 = paramList.size())
      {
        QLog.d("AtPanel", 2, paramInt1);
        if (bgjf.a(this.a) != null) {
          break label235;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        return;
      }
      label235:
      bgjf.a(this.a).a(0, 2131689833);
      return;
    }
    bgjf.a(this.a).a(paramList);
    bgjf.a(this.a).a(bgjf.a(this.a), bgjf.a(this.a), bgjf.a(this.a).G());
  }
  
  protected void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onTroopMemberUpdate: invoked. ");
    }
    bgjf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjg
 * JD-Core Version:    0.7.0.1
 */