import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import mqq.app.QQPermissionCallback;

public class atdr
  implements QQPermissionCallback
{
  public atdr(GameRoomTransActivity paramGameRoomTransActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bcql.a(this.a, ajya.a(2131705071), 0).a();
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdr
 * JD-Core Version:    0.7.0.1
 */