import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1;

public class auvu
  extends autc
{
  public auvu(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.a.app.a(this.a.app.getCurrentAccountUin(), 200);
      long l = ((Long)aush.a(this.a.app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l != 0L) {
        this.a.app.a(String.valueOf(l), 202);
      }
    }
    this.a.runOnUiThread(new NearbyGuideActivity.2.1(this, paramBoolean1, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvu
 * JD-Core Version:    0.7.0.1
 */