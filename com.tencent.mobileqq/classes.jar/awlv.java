import com.tencent.mobileqq.app.BaseActivity;

class awlv
  extends anvi
{
  awlv(awlt paramawlt) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(awlt.a(this.a).a())))
    {
      awlt.a(awlt.a(this.a), 0, String.valueOf(paramObject));
      if (awlt.a(this.a) != null) {
        awlt.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlv
 * JD-Core Version:    0.7.0.1
 */