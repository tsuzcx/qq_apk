import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity.2;
import mqq.app.QQPermissionCallback;

public class amml
  implements QQPermissionCallback
{
  public amml(LocationSelectActivity.2 param2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationSelectActivity.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amml
 * JD-Core Version:    0.7.0.1
 */