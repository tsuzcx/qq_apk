import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.qphone.base.util.QLog;

public class ates
  extends balg
{
  public ates(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    akbj.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      bcql.a(TroopGiftPanelForNearby.a(this.a), ajya.a(2131715433), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
    }
    for (;;)
    {
      akbj.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      bcql.a(TroopGiftPanelForNearby.b(this.a), ajya.a(2131715430), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ates
 * JD-Core Version:    0.7.0.1
 */