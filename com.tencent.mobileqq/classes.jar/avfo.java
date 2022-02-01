import java.util.ArrayList;

class avfo
  extends bhow
{
  avfo(avfn paramavfn) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    avfn.a(this.a, (ArrayList)paramObject);
    avfn.a(this.a).a(avfn.a(this.a));
    avfn.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfo
 * JD-Core Version:    0.7.0.1
 */