import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import mqq.app.QQPermissionCallback;

public class ashl
  implements QQPermissionCallback
{
  public ashl(GameRoomTransActivity paramGameRoomTransActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbmy.a(this.a, ajjy.a(2131639275), 0).a();
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ashl
 * JD-Core Version:    0.7.0.1
 */