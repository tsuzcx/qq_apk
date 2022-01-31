import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class auvr
  extends bcjt
{
  public auvr(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    alsy.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      QQToast.a(TroopGiftPanelForNearby.a(this.a), alpo.a(2131715805), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
    }
    for (;;)
    {
      alsy.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      QQToast.a(TroopGiftPanelForNearby.b(this.a), alpo.a(2131715802), 0).b(this.a.getResources().getDimensionPixelSize(2131298914));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvr
 * JD-Core Version:    0.7.0.1
 */