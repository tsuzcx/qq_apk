import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bchl
  extends aofu
{
  bchl(bchk parambchk) {}
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((bchk.a(this.a) == null) || (!bchk.a(this.a).b.equals(paramString))) {
      bchk.a(this.a).removeObserver(bchk.a(this.a));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean + "highRiskTroop" + paramInt);
      }
      bchk.a(this.a).removeObserver(bchk.a(this.a));
    } while (bchk.a(this.a) == null);
    if ((paramBoolean) && (paramInt != 0))
    {
      ajgr.a(bchk.a(this.a).getContext(), bchk.a(this.a), new Object[] { bchk.a(this.a), bchk.a(this.a) });
      return;
    }
    bchk.a(this.a, bchk.a(this.a).getContext(), bchk.a(this.a));
    bchk.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchl
 * JD-Core Version:    0.7.0.1
 */