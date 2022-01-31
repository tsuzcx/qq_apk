import java.util.ArrayList;

class aqtf
  extends bbri
{
  aqtf(aqte paramaqte) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    aqte.a(this.a, (ArrayList)paramObject);
    aqte.a(this.a).a(aqte.a(this.a));
    aqte.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtf
 * JD-Core Version:    0.7.0.1
 */