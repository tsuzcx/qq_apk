import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class axyi
  implements biug<oidb_0x8e4.RspBody>
{
  public axyi(GameRoomInviteActivity paramGameRoomInviteActivity, String paramString1, String paramString2) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    GameRoomInviteActivity localGameRoomInviteActivity;
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      localGameRoomInviteActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity;
      if ((paramRspBody.uint64_leader_uin.has()) && (paramRspBody.uint64_leader_uin.get() != this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.app.getLongAccountUin())) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      localGameRoomInviteActivity.a(bool, paramRspBody.string_invite_id.get().toStringUtf8(), this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyi
 * JD-Core Version:    0.7.0.1
 */