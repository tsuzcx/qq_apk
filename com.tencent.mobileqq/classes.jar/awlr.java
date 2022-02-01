import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class awlr
  implements bhai<oidb_0x8e4.RspBody>
{
  public awlr(GameRoomInviteActivity paramGameRoomInviteActivity, awmf paramawmf) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.jdField_a_of_type_Awmf;
      if (!this.jdField_a_of_type_Awmf.a)
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a(paramInt, paramRspBody, amtj.a(2131704260));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlr
 * JD-Core Version:    0.7.0.1
 */