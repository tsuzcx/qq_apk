import java.util.ArrayList;

class apzb
  extends baox
{
  apzb(apza paramapza) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    apza.a(this.a, (ArrayList)paramObject);
    apza.a(this.a).a(apza.a(this.a));
    apza.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzb
 * JD-Core Version:    0.7.0.1
 */