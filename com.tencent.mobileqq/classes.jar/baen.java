import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class baen
  extends akil
{
  baen(baem parambaem) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onUpdateTroopGetMemberList troopUin=" + paramString + " isSuccess=" + paramBoolean + " reqType=" + paramInt1 + " type" + paramInt2 + " reqTimestamp=" + paramLong);
    }
    if (paramInt1 != 2) {}
    do
    {
      return;
      if ((paramString != null) && (paramString.equals(baem.a(this.a).a))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList troopUin =" + paramString + " mSession.troopUin=" + baem.a(this.a).a);
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
        if (baem.a(this.a) != null) {
          break label235;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        return;
      }
      label235:
      baem.a(this.a).a(0, 2131689877);
      return;
    }
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      paramString.add(baes.a(baem.a(this.a), localTroopMemberInfo));
    }
    baem.a(this.a).a(paramString);
    baem.a(this.a).a(baem.a(this.a), baem.a(this.a), baem.a(this.a).F());
  }
  
  protected void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onTroopMemberUpdate: invoked. ");
    }
    baem.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baen
 * JD-Core Version:    0.7.0.1
 */