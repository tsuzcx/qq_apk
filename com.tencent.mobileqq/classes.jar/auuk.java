import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class auuk
  implements behy<oidb_0x8e4.RspBody>
{
  auuk(auuj paramauuj) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.poi_info;
      String str = paramRspBody.bytes_uid.get().toStringUtf8();
      this.a.a.a(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), str, paramRspBody.bytes_name.get().toStringUtf8());
    }
    do
    {
      return;
      this.a.a.a(paramInt, paramRspBody, alpo.a(2131705445));
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomInviteActivity", 2, "start game failed! code = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auuk
 * JD-Core Version:    0.7.0.1
 */