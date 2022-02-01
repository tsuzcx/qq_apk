import com.tencent.qphone.base.util.QLog;

class bafw
  extends anuw
{
  bafw(bafv parambafv) {}
  
  protected void onPraiseLifeAchievement(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAchievementComponent", 2, String.format("onPraiseLifeAchievement isSuccess=%s actionType=%s achievementId=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    bafv.a(this.a, paramBoolean, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafw
 * JD-Core Version:    0.7.0.1
 */