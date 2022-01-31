import java.util.ArrayList;

class asjr
  extends bdqc
{
  asjr(asjq paramasjq) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    asjq.a(this.a, (ArrayList)paramObject);
    asjq.a(this.a).a(asjq.a(this.a));
    asjq.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjr
 * JD-Core Version:    0.7.0.1
 */