import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class auyh
  implements bemh<oidb_0x8e4.RspBody>
{
  public auyh(GameRoomInviteActivity paramGameRoomInviteActivity, auyv paramauyv) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.jdField_a_of_type_Auyv;
      if (!this.jdField_a_of_type_Auyv.a)
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a(paramInt, paramRspBody, alud.a(2131705528));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auyh
 * JD-Core Version:    0.7.0.1
 */