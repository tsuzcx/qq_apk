import com.tencent.mobileqq.app.BaseActivity;

class awsm
  extends anyu
{
  awsm(awsk paramawsk) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(awsk.a(this.a).a())))
    {
      awsk.a(awsk.a(this.a), 0, String.valueOf(paramObject));
      if (awsk.a(this.a) != null) {
        awsk.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsm
 * JD-Core Version:    0.7.0.1
 */