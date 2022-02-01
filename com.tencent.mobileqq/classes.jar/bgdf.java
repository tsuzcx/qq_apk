import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class bgdf
  extends aofu
{
  public bgdf(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onQueryJoinTroopCanNoVerify(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (!paramString1.equals(this.a.a.troopUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean);
      }
    } while (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt2));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify noVerify:" + paramInt1);
      }
      this.a.b = paramInt1;
      this.a.c = paramInt2;
      if ((this.a.b == 1) && (paramInt2 == 0))
      {
        if (this.a.a.isHomeworkTroop())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify isHomeworkTroop true");
          }
          this.a.b(1);
          return;
        }
        this.a.e();
        return;
      }
      VisitorTroopCardFragment.b(this.a);
      return;
    }
    VisitorTroopCardFragment.b(this.a);
  }
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.a.troopUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean + "highRiskTroop" + paramInt);
      }
    } while (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt));
    if (paramBoolean) {}
    for (this.a.c = paramInt;; this.a.c = 0)
    {
      VisitorTroopCardFragment.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdf
 * JD-Core Version:    0.7.0.1
 */