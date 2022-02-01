import com.tencent.mobileqq.app.BaseActivity;

class avzu
  extends anmu
{
  avzu(avzs paramavzs) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(avzs.a(this.a).a())))
    {
      avzs.a(avzs.a(this.a), 0, String.valueOf(paramObject));
      if (avzs.a(this.a) != null) {
        avzs.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzu
 * JD-Core Version:    0.7.0.1
 */