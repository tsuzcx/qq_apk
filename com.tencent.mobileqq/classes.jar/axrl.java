import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class axrl
  implements bila<oidb_0x8e4.RspBody>
{
  public axrl(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      GameRoomInviteActivity localGameRoomInviteActivity = this.a;
      String str = paramRspBody.string_invite_id.get().toStringUtf8();
      localGameRoomInviteActivity.jdField_b_of_type_JavaLangString = str;
      GameRoomInviteActivity.jdField_a_of_type_JavaLangString = str;
      this.a.jdField_b_of_type_Long = paramRspBody.uint64_leader_uin.get();
      this.a.e();
      bhhr.a(this.a, this.a.app.getCurrentAccountUin(), true, System.currentTimeMillis());
      if ((this.a.jdField_a_of_type_Long > 0L) && (this.a.jdField_b_of_type_Boolean)) {
        GameRoomInviteActivity.a(this.a, "" + this.a.jdField_a_of_type_Long, 1);
      }
      return;
    }
    this.a.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrl
 * JD-Core Version:    0.7.0.1
 */