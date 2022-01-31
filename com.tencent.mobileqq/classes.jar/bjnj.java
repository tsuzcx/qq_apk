import cooperation.qzone.share.QZoneShareActivity;
import mqq.app.QQPermissionCallback;

public class bjnj
  implements QQPermissionCallback
{
  public bjnj(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjnj
 * JD-Core Version:    0.7.0.1
 */