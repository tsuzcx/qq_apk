import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ayac
  extends bgst
{
  public ayac(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    aocz.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      QQToast.a(TroopGiftPanelForNearby.a(this.a), anzj.a(2131714207), 0).b(this.a.getResources().getDimensionPixelSize(2131299011));
    }
    for (;;)
    {
      aocz.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      QQToast.a(TroopGiftPanelForNearby.b(this.a), anzj.a(2131714204), 0).b(this.a.getResources().getDimensionPixelSize(2131299011));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayac
 * JD-Core Version:    0.7.0.1
 */