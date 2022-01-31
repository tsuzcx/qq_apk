import com.tencent.mobileqq.app.BaseActivity;

class arbr
  extends ajjh
{
  arbr(arbp paramarbp) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(arbp.a(this.a).a())))
    {
      arbp.a(arbp.a(this.a), 0, String.valueOf(paramObject));
      if (arbp.a(this.a) != null) {
        arbp.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbr
 * JD-Core Version:    0.7.0.1
 */