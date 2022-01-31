import java.util.ArrayList;

class asoa
  extends bdul
{
  asoa(asnz paramasnz) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    asnz.a(this.a, (ArrayList)paramObject);
    asnz.a(this.a).a(asnz.a(this.a));
    asnz.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoa
 * JD-Core Version:    0.7.0.1
 */