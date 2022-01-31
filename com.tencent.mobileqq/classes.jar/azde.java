import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class azde
  extends ajuc
{
  azde(azdd paramazdd) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onUpdateTroopGetMemberList troopUin=" + paramString + " isSuccess=" + paramBoolean + " reqType=" + paramInt1 + " type" + paramInt2 + " reqTimestamp=" + paramLong);
    }
    if (paramInt1 != 2) {}
    do
    {
      return;
      if ((paramString != null) && (paramString.equals(azdd.a(this.a).a))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList troopUin =" + paramString + " mSession.troopUin=" + azdd.a(this.a).a);
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
        if (azdd.a(this.a) != null) {
          break label235;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        return;
      }
      label235:
      azdd.a(this.a).a(0, 2131624332);
      return;
    }
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      paramString.add(azdj.a(azdd.a(this.a), localTroopMemberInfo));
    }
    azdd.a(this.a).a(paramString);
    azdd.a(this.a).a(azdd.a(this.a), azdd.a(this.a), azdd.a(this.a).F());
  }
  
  protected void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onTroopMemberUpdate: invoked. ");
    }
    azdd.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azde
 * JD-Core Version:    0.7.0.1
 */