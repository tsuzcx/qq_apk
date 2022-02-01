import android.content.Context;
import android.os.Bundle;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto.GetGameStatusByGroupCodeRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;

public final class ayfz
  implements aunq
{
  public ayfz(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, HashMap paramHashMap) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 1;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("login: errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle == null) {}
      for (paramBundle = "null";; paramBundle = paramBundle.toString())
      {
        QLog.i("GroupVideoChatAppInfo", 2, paramBundle + " data=" + Arrays.toString(paramArrayOfByte));
        GroupVideoChatAppInfo.access$000(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        return;
      }
    }
    paramBundle = new GroupRoomManageProto.GetGameStatusByGroupCodeRsp();
    try
    {
      paramArrayOfByte = (GroupRoomManageProto.GetGameStatusByGroupCodeRsp)paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, new Object[] { "MSF.C.NetConnTag", " room_id=" + paramArrayOfByte.room_id.get() + " app_type=" + paramArrayOfByte.app_type.get() + " game_id=" + paramArrayOfByte.game_id.get() + " is_group_member=" + paramArrayOfByte.is_group_member.get() });
      }
      if ((paramArrayOfByte.app_type.get() <= 0) || (paramArrayOfByte.is_group_member.get() != 0))
      {
        bool = true;
        if (!"Panel".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from"))) {
          break label338;
        }
        paramInt = 1;
        paramBundle = new axkn().a("QQ_chatroom_surface").b("click_entrance").a(paramInt).d(String.valueOf(bool));
        if (paramArrayOfByte.app_type.get() != 2) {
          break label382;
        }
        paramInt = i;
        paramBundle.b(paramInt).a();
        if (bool) {
          break label387;
        }
        GroupVideoChatAppInfo.access$100(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label387:
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = paramBundle;
        continue;
        boolean bool = false;
        continue;
        label338:
        if ("tipBar".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from")))
        {
          paramInt = 2;
        }
        else if ("itemBuilder".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from")))
        {
          paramInt = 3;
          continue;
          label382:
          paramInt = 0;
          continue;
          if (paramArrayOfByte.app_type.get() == 2)
          {
            GroupVideoChatAppInfo.access$200(this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), paramArrayOfByte.room_id.get(), paramArrayOfByte.game_id.get());
            return;
          }
          GroupVideoChatAppInfo.access$000(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfz
 * JD-Core Version:    0.7.0.1
 */