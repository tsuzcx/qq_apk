import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import mqq.app.QQPermissionCallback;

public class aytn
  implements QQPermissionCallback
{
  public aytn(ScanOcrActivity paramScanOcrActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytn
 * JD-Core Version:    0.7.0.1
 */