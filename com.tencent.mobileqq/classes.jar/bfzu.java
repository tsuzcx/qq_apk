import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bfzu
  extends aofu
{
  bfzu(bfzt parambfzt) {}
  
  protected void onTroopMemberUpdate()
  {
    super.onTroopMemberUpdate();
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onTroopMemberUpdate: invoked. ");
    }
    bfzt.a(this.a, true);
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onUpdateTroopGetMemberList troopUin=" + paramString + " isSuccess=" + paramBoolean + " reqType=" + paramInt1 + " type" + paramInt2 + " reqTimestamp=" + paramLong);
    }
    if (paramInt1 != 2) {}
    do
    {
      return;
      if ((paramString != null) && (paramString.equals(bfzt.a(this.a).curFriendUin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList troopUin =" + paramString + " mSession.troopUin=" + bfzt.a(this.a).curFriendUin);
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
        if (bfzt.a(this.a) != null) {
          break label235;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        return;
      }
      label235:
      bfzt.a(this.a).a(0, 2131689874);
      return;
    }
    bfzt.a(this.a).a(paramList);
    bfzt.a(this.a).a(bfzt.a(this.a), bfzt.a(this.a), bfzt.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzu
 * JD-Core Version:    0.7.0.1
 */