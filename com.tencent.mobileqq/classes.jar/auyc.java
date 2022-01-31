import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.PlayerState;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

public class auyc
  extends bemo
{
  public auyc(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null) || (this.a.isFinishing())) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.a.jdField_d_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
        this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setComplete(new auyd(this));
        this.a.a("load_page", "suc_cnt");
        return;
      }
    } while (paramInt == 4);
    if (this.a.jdField_d_of_type_Int > 3)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.a.setText(alud.a(2131705489));
      this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
      this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
      this.a.jdField_d_of_type_Boolean = false;
      return;
    }
    this.a.jdField_d_of_type_Boolean = true;
    this.a.jdField_a_of_type_Bemq.a();
    GameRoomInviteActivity localGameRoomInviteActivity = this.a;
    localGameRoomInviteActivity.jdField_d_of_type_Int += 1;
  }
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody)
  {
    Object localObject;
    switch (paramMsgBody.uint32_msg_type.get())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("GameRoomInviteActivity", 2, "the 0xdd push type is wrong:" + paramMsgBody.uint32_msg_type.get());
      }
    case 1: 
      do
      {
        return;
        localObject = this.a;
        int i;
        if ((!paramMsgBody.uint64_invite_leader.has()) || (paramMsgBody.uint64_invite_leader.get() == this.a.app.getLongAccountUin()))
        {
          bool = true;
          ((GameRoomInviteActivity)localObject).jdField_a_of_type_Boolean = bool;
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
          i = 0;
          if (i >= paramMsgBody.rpt_msg_player_state.size()) {
            continue;
          }
          localObject = new auyv(this.a);
          submsgtype0xdd.MsgBody.PlayerState localPlayerState = (submsgtype0xdd.MsgBody.PlayerState)paramMsgBody.rpt_msg_player_state.get(i);
          ((auyv)localObject).jdField_a_of_type_JavaLangString = (localPlayerState.uint64_uin.get() + "");
          if (localPlayerState.uint32_state.get() != 1) {
            break label250;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((auyv)localObject).jdField_a_of_type_Boolean = bool;
          this.a.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
          break label135;
          bool = false;
          break;
        }
      } while (this.a.jdField_d_of_type_Boolean);
      this.a.jdField_a_of_type_Auyw.notifyDataSetChanged();
      this.a.a();
      return;
    case 2: 
      paramMsgBody = (submsgtype0xdd.MsgBody.WifiPOIInfo)paramMsgBody.msg_poi_info.get();
      localObject = paramMsgBody.bytes_uid.get().toStringUtf8();
      this.a.a(HotChatInfo.createHotChat(paramMsgBody, false, 0), paramMsgBody.uint32_group_code.get(), (String)localObject, paramMsgBody.bytes_name.get().toStringUtf8());
      auwq.a(this.a.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(ayzl.a()));
      return;
    case 3: 
      label135:
      label250:
      QQToast.a(this.a, alud.a(2131705514), 0).a();
      this.a.finish();
      this.a.jdField_a_of_type_JavaUtilList = null;
      bdne.a(this.a, this.a.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      return;
    }
    this.a.a(null, alud.a(2131705491), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */