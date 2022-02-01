import com.dataline.activities.LiteActivity;
import mqq.app.QQPermissionCallback;

public class bi
  implements QQPermissionCallback
{
  public bi(LiteActivity paramLiteActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */