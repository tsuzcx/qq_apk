import cooperation.qzone.share.QZoneShareActivity;
import mqq.app.QQPermissionCallback;

public class bhly
  implements QQPermissionCallback
{
  public bhly(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.b(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhly
 * JD-Core Version:    0.7.0.1
 */