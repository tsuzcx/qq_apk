import cooperation.qzone.share.QZoneShareActivity;
import mqq.app.QQPermissionCallback;

public class bhlh
  implements QQPermissionCallback
{
  public bhlh(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbcv.b(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhlh
 * JD-Core Version:    0.7.0.1
 */