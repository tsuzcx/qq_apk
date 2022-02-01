import java.util.ArrayList;

class auux
  extends bgzm
{
  auux(auuw paramauuw) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    auuw.a(this.a, (ArrayList)paramObject);
    auuw.a(this.a).a(auuw.a(this.a));
    auuw.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auux
 * JD-Core Version:    0.7.0.1
 */