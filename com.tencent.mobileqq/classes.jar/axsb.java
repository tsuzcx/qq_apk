import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class axsb
  implements bila<oidb_0x8e4.RspBody>
{
  public axsb(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      this.a.b = paramRspBody.string_invite_id.get().toStringUtf8();
      GameRoomInviteActivity.a = this.a.b;
    }
    for (;;)
    {
      this.a.a(true);
      return;
      paramRspBody = this.a;
      GameRoomInviteActivity.a = null;
      paramRspBody.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsb
 * JD-Core Version:    0.7.0.1
 */