import com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop;
import com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop.MyTroopObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class amfy
  extends aojs
{
  public amfy(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.c();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.c();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.c();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TroopDiscussionTroop.a(this.a) != null) {
      TroopDiscussionTroop.a(this.a).a();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new TroopDiscussionTroop.MyTroopObserver.1(this), 500L);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfy
 * JD-Core Version:    0.7.0.1
 */