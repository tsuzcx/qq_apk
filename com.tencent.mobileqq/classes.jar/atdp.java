import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import mqq.app.QQPermissionCallback;

public class atdp
  implements QQPermissionCallback
{
  public atdp(GameRoomTransActivity paramGameRoomTransActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bcpw.a(this.a, ajyc.a(2131705060), 0).a();
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdp
 * JD-Core Version:    0.7.0.1
 */