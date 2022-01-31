import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import mqq.app.QQPermissionCallback;

public class avtc
  implements QQPermissionCallback
{
  public avtc(ScanOcrActivity paramScanOcrActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtc
 * JD-Core Version:    0.7.0.1
 */