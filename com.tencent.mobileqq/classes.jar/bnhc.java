import cooperation.qzone.share.QZoneShareActivity;
import mqq.app.QQPermissionCallback;

public class bnhc
  implements QQPermissionCallback
{
  public bnhc(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhc
 * JD-Core Version:    0.7.0.1
 */