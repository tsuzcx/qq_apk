import com.dataline.activities.LiteActivity;
import mqq.app.QQPermissionCallback;

public class bd
  implements QQPermissionCallback
{
  public bd(LiteActivity paramLiteActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */