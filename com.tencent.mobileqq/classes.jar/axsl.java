import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.QQPermissionCallback;

public class axsl
  implements QQPermissionCallback
{
  public axsl(GameRoomTransActivity paramGameRoomTransActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQToast.a(this.a, anvx.a(2131704538), 0).a();
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsl
 * JD-Core Version:    0.7.0.1
 */