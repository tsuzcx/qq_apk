import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class bewl
  extends andd
{
  public bewl(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onQueryJoinTroopCanNoVerify(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify noVerify:" + paramInt);
      }
      this.a.b = paramInt;
      if (this.a.b == 1)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bewl
 * JD-Core Version:    0.7.0.1
 */