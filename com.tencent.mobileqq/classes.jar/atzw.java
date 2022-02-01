import java.util.ArrayList;

class atzw
  extends bggc
{
  atzw(atzv paramatzv) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    atzv.a(this.a, (ArrayList)paramObject);
    atzv.a(this.a).a(atzv.a(this.a));
    atzv.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzw
 * JD-Core Version:    0.7.0.1
 */