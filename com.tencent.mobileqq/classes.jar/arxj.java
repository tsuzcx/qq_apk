import com.tencent.mobileqq.app.BaseActivity;

class arxj
  extends ajxl
{
  arxj(arxh paramarxh) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(arxh.a(this.a).a())))
    {
      arxh.a(arxh.a(this.a), 0, String.valueOf(paramObject));
      if (arxh.a(this.a) != null) {
        arxh.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxj
 * JD-Core Version:    0.7.0.1
 */