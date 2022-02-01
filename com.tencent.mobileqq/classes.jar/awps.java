class awps
  extends anyu
{
  awps(awpq paramawpq) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if ((paramBoolean) && ((paramObject instanceof Long))) {
      awsk.a(this.a.app, 0, String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awps
 * JD-Core Version:    0.7.0.1
 */