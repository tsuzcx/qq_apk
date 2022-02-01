import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class ayul
  extends CardObserver
{
  ayul(ayuk paramayuk) {}
  
  public void onPraiseLifeAchievement(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAchievementComponent", 2, String.format("onPraiseLifeAchievement isSuccess=%s actionType=%s achievementId=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    ayuk.a(this.a, paramBoolean, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayul
 * JD-Core Version:    0.7.0.1
 */