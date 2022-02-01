import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class azoa
  extends asgf
{
  azoa(aznv paramaznv) {}
  
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
      if (aznv.a(this.a) != null) {
        aznv.a(this.a).removeCallbacks(aznv.a(this.a));
      }
      if (aznv.a(this.a) != null)
      {
        aznv.a(this.a).dismiss();
        aznv.a(this.a, null);
      }
      if (!aznv.d(this.a))
      {
        aznv.b(this.a, true);
        aznv.b(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoa
 * JD-Core Version:    0.7.0.1
 */