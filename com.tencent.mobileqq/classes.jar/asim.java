import android.content.res.Resources;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.qphone.base.util.QLog;

public class asim
  extends azjp
{
  public asim(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    ajnb.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      bbmy.a(TroopGiftPanelForNearby.a(this.a), ajjy.a(2131649632), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
    }
    for (;;)
    {
      ajnb.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      bbmy.a(TroopGiftPanelForNearby.b(this.a), ajjy.a(2131649629), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asim
 * JD-Core Version:    0.7.0.1
 */