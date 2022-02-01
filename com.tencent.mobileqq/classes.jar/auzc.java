import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class auzc
  extends andd
{
  public auzc(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onPassiveExit troopUin: " + paramString);
    String str = auzn.a(1, paramString);
    if (ListenTogetherManager.a(this.a).equals(str))
    {
      ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).g = 3;
      ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
      auyq.a(ListenTogetherManager.a(this.a), paramString, false);
      this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
      this.a.a(1, paramString, false);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onTroopManagerSuccess result: " + paramInt2 + " troopUin: " + paramString);
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      String str = auzn.a(1, paramString);
      if (ListenTogetherManager.a(this.a).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).g = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
        auyq.a(ListenTogetherManager.a(this.a), paramString, false);
        this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
        this.a.a(1, paramString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzc
 * JD-Core Version:    0.7.0.1
 */