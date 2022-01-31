import java.util.ArrayList;

class aqtd
  extends bbqu
{
  aqtd(aqtc paramaqtc) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    aqtc.a(this.a, (ArrayList)paramObject);
    aqtc.a(this.a).a(aqtc.a(this.a));
    aqtc.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtd
 * JD-Core Version:    0.7.0.1
 */