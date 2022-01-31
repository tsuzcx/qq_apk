import com.tencent.mobileqq.app.BaseActivity;

class arxl
  extends ajxj
{
  arxl(arxj paramarxj) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(arxj.a(this.a).a())))
    {
      arxj.a(arxj.a(this.a), 0, String.valueOf(paramObject));
      if (arxj.a(this.a) != null) {
        arxj.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxl
 * JD-Core Version:    0.7.0.1
 */