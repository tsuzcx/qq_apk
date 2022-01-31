import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.fragment.TroopRobotFragment.1.1;
import com.tencent.qphone.base.util.QLog;

public class ashv
  extends ameq
{
  public ashv(TroopRobotFragment paramTroopRobotFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(TroopRobotFragment.a(this.a))))
    {
      TroopRobotFragment.a(this.a, paramLong1);
      return;
    }
    QLog.i("TroopRobotFragment", 2, "onAddRobot  net troopuin" + paramLong1 + " cur " + TroopRobotFragment.a(this.a));
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, bcpe parambcpe)
  {
    String str = String.valueOf(paramLong);
    if ((str != null) && (str.equals(TroopRobotFragment.a(this.a))))
    {
      if ((paramBoolean) && (parambcpe != null) && (this.a.getActivity() != null))
      {
        QLog.d("TroopRobotFragment", 2, "onGetAllRobots");
        this.a.getActivity().runOnUiThread(new TroopRobotFragment.1.1(this, parambcpe));
        return;
      }
      QLog.e("TroopRobotFragment", 2, "onGetAllRobots err " + paramInt + " :" + paramLong);
      TroopRobotFragment.a(this.a, paramLong);
      return;
    }
    QLog.i("TroopRobotFragment", 2, "onGetAllRobots  net troopuin" + paramLong + " cur " + TroopRobotFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashv
 * JD-Core Version:    0.7.0.1
 */