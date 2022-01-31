class atpy
  extends altm
{
  atpy(atpw paramatpw) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    if ((paramBoolean) && ((paramObject instanceof Long))) {
      atso.a(this.a.app, 0, String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpy
 * JD-Core Version:    0.7.0.1
 */