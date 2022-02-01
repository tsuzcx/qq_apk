import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class bagq
  extends asvt
{
  bagq(bagl parambagl) {}
  
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
      if (bagl.a(this.a) != null) {
        bagl.a(this.a).removeCallbacks(bagl.a(this.a));
      }
      if (bagl.a(this.a) != null)
      {
        bagl.a(this.a).dismiss();
        bagl.a(this.a, null);
      }
      if (!bagl.d(this.a))
      {
        bagl.b(this.a, true);
        bagl.b(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagq
 * JD-Core Version:    0.7.0.1
 */