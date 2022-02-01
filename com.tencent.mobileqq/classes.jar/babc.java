import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class babc
  extends aslz
{
  babc(baax parambaax) {}
  
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
      if (baax.a(this.a) != null) {
        baax.a(this.a).removeCallbacks(baax.a(this.a));
      }
      if (baax.a(this.a) != null)
      {
        baax.a(this.a).dismiss();
        baax.a(this.a, null);
      }
      if (!baax.d(this.a))
      {
        baax.b(this.a, true);
        baax.b(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babc
 * JD-Core Version:    0.7.0.1
 */