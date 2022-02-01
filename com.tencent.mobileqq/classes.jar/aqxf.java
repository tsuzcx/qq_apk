import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity.2;
import mqq.app.QQPermissionCallback;

public class aqxf
  implements QQPermissionCallback
{
  public aqxf(LocationSelectActivity.2 param2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationSelectActivity.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxf
 * JD-Core Version:    0.7.0.1
 */