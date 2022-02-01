import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class axyj
  implements biug<oidb_0x8e4.RspBody>
{
  public axyj(GameRoomInviteActivity paramGameRoomInviteActivity, axyx paramaxyx) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.jdField_a_of_type_Axyx;
      if (!this.jdField_a_of_type_Axyx.a)
      {
        bool = true;
        paramRspBody.a = bool;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a.notifyDataSetChanged();
      }
    }
    while (paramRspBody == null) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a(paramInt, paramRspBody, anzj.a(2131704031));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyj
 * JD-Core Version:    0.7.0.1
 */