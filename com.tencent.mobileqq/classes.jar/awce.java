import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.QQPermissionCallback;

public class awce
  implements QQPermissionCallback
{
  public awce(ScanTorchActivity paramScanTorchActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("ScanTorchActivity", 1, String.format("checkSelfPermission deny i=%s strings=%s ints=%s", new Object[] { Integer.valueOf(paramInt), Arrays.toString(paramArrayOfString), Arrays.toString(paramArrayOfInt) }));
    bdgm.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("ScanTorchActivity", 1, String.format("checkSelfPermission grant i=%s strings=%s ints=%s", new Object[] { Integer.valueOf(paramInt), Arrays.toString(paramArrayOfString), Arrays.toString(paramArrayOfInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awce
 * JD-Core Version:    0.7.0.1
 */