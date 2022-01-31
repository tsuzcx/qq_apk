import com.tencent.mobileqq.app.BaseActivity;

class atsq
  extends altm
{
  atsq(atso paramatso) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(atso.a(this.a).a())))
    {
      atso.a(atso.a(this.a), 0, String.valueOf(paramObject));
      if (atso.a(this.a) != null) {
        atso.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsq
 * JD-Core Version:    0.7.0.1
 */