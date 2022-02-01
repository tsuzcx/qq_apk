import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import mqq.app.QQPermissionCallback;

class bezn
  implements QQPermissionCallback
{
  bezn(bezm parambezm) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TroopBarReplyActivity.a(this.a.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezn
 * JD-Core Version:    0.7.0.1
 */