import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class aywh
  extends arht
{
  aywh(aywc paramaywc) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      if (paramCard == null) {
        break label124;
      }
    }
    label124:
    for (paramCard = paramCard.declaration;; paramCard = null)
    {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetExtendFriendInfo success=%s declaration=%s", new Object[] { Boolean.valueOf(paramBoolean), paramCard }));
      if (aywc.a(this.a) != null) {
        aywc.a(this.a).removeCallbacks(aywc.a(this.a));
      }
      if (aywc.a(this.a) != null)
      {
        aywc.a(this.a).dismiss();
        aywc.a(this.a, null);
      }
      if (!aywc.d(this.a))
      {
        aywc.b(this.a, true);
        aywc.b(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywh
 * JD-Core Version:    0.7.0.1
 */