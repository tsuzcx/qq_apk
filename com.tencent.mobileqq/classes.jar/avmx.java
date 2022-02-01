import java.util.ArrayList;

class avmx
  extends bhzs
{
  avmx(avmw paramavmw) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    avmw.a(this.a, (ArrayList)paramObject);
    avmw.a(this.a).a(avmw.a(this.a));
    avmw.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmx
 * JD-Core Version:    0.7.0.1
 */