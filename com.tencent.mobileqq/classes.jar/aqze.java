class aqze
  extends ajjh
{
  aqze(aqzc paramaqzc) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if ((paramBoolean) && ((paramObject instanceof Long))) {
      arbp.a(this.a.app, 0, String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqze
 * JD-Core Version:    0.7.0.1
 */