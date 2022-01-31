import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.qphone.base.util.QLog;

public class ateq
  extends baks
{
  public ateq(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    akbk.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      bcpw.a(TroopGiftPanelForNearby.a(this.a), ajyc.a(2131715422), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
    }
    for (;;)
    {
      akbk.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      bcpw.a(TroopGiftPanelForNearby.b(this.a), ajyc.a(2131715419), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ateq
 * JD-Core Version:    0.7.0.1
 */