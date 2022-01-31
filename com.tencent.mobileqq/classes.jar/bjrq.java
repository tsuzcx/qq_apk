import cooperation.qzone.share.QZoneShareActivity;
import mqq.app.QQPermissionCallback;

public class bjrq
  implements QQPermissionCallback
{
  public bjrq(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.b(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrq
 * JD-Core Version:    0.7.0.1
 */