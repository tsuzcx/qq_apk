import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeKSing;
import tencent.im.oidb.cmd0x857.TroopTips0x857.SingChangePushInfo;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.KSingRelationInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x127.submsgtype0x127.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x129.submsgtype0x129.MsgBody;

public class aura
  implements bdde
{
  private QQAppInterface a;
  
  public aura(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, long paramLong5)
  {
    SingTogetherSession localSingTogetherSession = (SingTogetherSession)bddg.a(4, 2, String.valueOf(paramLong2));
    if (paramInt2 == 1) {
      if (paramLong1 != 0L) {
        break label111;
      }
    }
    label111:
    for (String str = "";; str = String.valueOf(paramLong1))
    {
      localSingTogetherSession.jdField_f_of_type_JavaLangString = str;
      if ((paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4)) {
        localSingTogetherSession.jdField_a_of_type_Int = paramInt1;
      }
      a(paramQQAppInterface, localSingTogetherSession, paramInt2, paramLong1, paramString, paramLong3, paramLong4, null);
      if (((paramInt2 == 5) || (paramInt2 == 2)) && (!TextUtils.isEmpty(paramString))) {
        ausf.a(paramQQAppInterface, paramLong2, 0, paramString, paramInt2, paramLong4, paramLong5, 131087);
      }
      return;
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    Oidb_0xd50.KSingRelationInfo localKSingRelationInfo = new Oidb_0xd50.KSingRelationInfo();
    try
    {
      localKSingRelationInfo.mergeFrom(paramArrayOfByte);
      int i = localKSingRelationInfo.flag.get();
      return i == 1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    a(paramString, -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.SingChangePushInfo)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, params not right");
      }
    }
    label56:
    label77:
    label98:
    label119:
    label380:
    do
    {
      return;
      TroopTips0x857.SingChangePushInfo localSingChangePushInfo = (TroopTips0x857.SingChangePushInfo)paramObject;
      if (localSingChangePushInfo != null)
      {
        long l1;
        int i;
        long l2;
        long l3;
        int j;
        if (localSingChangePushInfo.uint64_seq.has())
        {
          l1 = localSingChangePushInfo.uint64_seq.get();
          if (!localSingChangePushInfo.uint32_action_type.has()) {
            break label346;
          }
          i = localSingChangePushInfo.uint32_action_type.get();
          if (!localSingChangePushInfo.uint64_group_id.has()) {
            break label352;
          }
          l2 = localSingChangePushInfo.uint64_group_id.get();
          if (!localSingChangePushInfo.uint64_oper_uin.has()) {
            break label360;
          }
          l3 = localSingChangePushInfo.uint64_oper_uin.get();
          if (!localSingChangePushInfo.uint32_join_nums.has()) {
            break label368;
          }
          j = localSingChangePushInfo.uint32_join_nums.get();
          if (!localSingChangePushInfo.bytes_gray_tips.has()) {
            break label374;
          }
        }
        for (paramObject = localSingChangePushInfo.bytes_gray_tips.get().toStringUtf8();; paramObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, seq=" + l1 + ", actionType=" + i + ", groupid=" + l2 + ", uin=" + l3 + ", joinNum=" + j + ", tips=" + paramObject);
          }
          long l4 = ((bdct)paramQQAppInterface.getManager(339)).a(4, 1, l2);
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, oldSeq=" + l4);
          }
          if (l1 >= l4) {
            break label380;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + l4);
          return;
          l1 = -1L;
          break label56;
          i = -1;
          break label77;
          l2 = -1L;
          break label98;
          l3 = -1L;
          break label119;
          j = -1;
          break label140;
        }
        SingTogetherSession localSingTogetherSession = (SingTogetherSession)bddg.a(4, 1, String.valueOf(l2));
        if (i == 1) {
          if (l3 != -1L) {
            break label542;
          }
        }
        for (String str = "";; str = String.valueOf(l3))
        {
          localSingTogetherSession.jdField_f_of_type_JavaLangString = str;
          if ((i == 1) || (i == 3) || (i == 4)) {
            localSingTogetherSession.jdField_f_of_type_Int = j;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, session" + localSingTogetherSession);
          }
          a(paramQQAppInterface, localSingTogetherSession, i, l3, paramObject, l1, paramLong1, localSingChangePushInfo);
          if (((i != 5) && (i != 2)) || (TextUtils.isEmpty(paramObject)) || (l2 == -1L)) {
            break;
          }
          ausf.a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, 131087);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    label140:
    label346:
    label352:
    label360:
    label368:
    label374:
    QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, pushinfo is null.");
    label542:
  }
  
  public void a(QQAppInterface paramQQAppInterface, SingTogetherSession paramSingTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.SingChangePushInfo paramSingChangePushInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherParser", 2, "handleSingTogetherPush");
    }
    bdct localbdct = (bdct)paramQQAppInterface.getManager(339);
    localbdct.a(4, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, paramLong2);
    Object localObject = (SingTogetherSession)localbdct.a(paramSingTogetherSession.jdField_d_of_type_Int, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString);
    if (localObject != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        ((SingTogetherSession)localObject).jdField_f_of_type_Int = paramSingTogetherSession.jdField_f_of_type_Int;
      }
      if ((paramInt == 1) && (!TextUtils.isEmpty(paramSingTogetherSession.jdField_f_of_type_JavaLangString))) {
        ((SingTogetherSession)localObject).jdField_f_of_type_JavaLangString = paramSingTogetherSession.jdField_f_of_type_JavaLangString;
      }
      if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
        break label451;
      }
      ((SingTogetherSession)localObject).jdField_a_of_type_Int = paramSingTogetherSession.jdField_a_of_type_Int;
      paramSingTogetherSession = (SingTogetherSession)localObject;
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        bddg.a(paramQQAppInterface, paramSingTogetherSession.jdField_e_of_type_JavaLangString, true, paramSingTogetherSession.jdField_e_of_type_Int, 16777216);
        label164:
        if (paramSingTogetherSession.jdField_e_of_type_Int != 2) {
          break label306;
        }
        localObject = ((amsw)paramQQAppInterface.getManager(51)).b(paramSingTogetherSession.jdField_e_of_type_JavaLangString);
        if ((localObject != null) && (((Friends)localObject).isFriend())) {
          break label306;
        }
      }
      label306:
      while (TextUtils.isEmpty(paramSingTogetherSession.jdField_e_of_type_JavaLangString))
      {
        return;
        localbdct.a(paramSingTogetherSession.jdField_d_of_type_Int, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, paramSingTogetherSession);
        break;
        if (paramInt == 2)
        {
          paramSingTogetherSession.g = 3;
          paramSingTogetherSession.h = 3;
          bddg.a(paramQQAppInterface, paramSingTogetherSession.jdField_e_of_type_JavaLangString, false, paramSingTogetherSession.jdField_e_of_type_Int, 16777216);
          break label164;
        }
        if ((!paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) || ((paramInt != 3) && (paramInt != 4) && (paramInt != 5))) {
          break label164;
        }
        bddg.a(paramQQAppInterface, paramSingTogetherSession.jdField_e_of_type_JavaLangString, true, paramSingTogetherSession.jdField_e_of_type_Int, 16777216);
        break label164;
      }
      localObject = localbdct.a(4, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, 1003);
      ((bdcz)localObject).jdField_a_of_type_AndroidOsBundle.putInt("action_type", paramInt);
      ((bdcz)localObject).jdField_a_of_type_AndroidOsBundle.putString("tips", paramString);
      ((bdcz)localObject).jdField_a_of_type_AndroidOsBundle.putLong("seq", paramLong2);
      ((bdcz)localObject).jdField_a_of_type_AndroidOsBundle.putLong("msgSeq", paramLong3);
      ((bdcz)localObject).jdField_a_of_type_JavaLangObject = paramSingChangePushInfo;
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) && ((paramInt == 2) || (paramInt == 4) || (paramInt == 3)))
      {
        a(true, paramSingTogetherSession, 1003, "");
        return;
      }
      localbdct.a(4, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, 1003);
      return;
      label451:
      paramSingTogetherSession = (SingTogetherSession)localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127, msgSeq = " + paramLong1 + " msgTime = " + paramLong2 + " selfUin:" + (String)localObject + " isOffline = " + paramBoolean);
    }
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      if (paramBoolean) {}
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject = new submsgtype0x127.MsgBody();
        ((submsgtype0x127.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = ((submsgtype0x127.MsgBody)localObject).join_state.get();
        j = ((submsgtype0x127.MsgBody)localObject).uint32_action_type.get();
        if (!((submsgtype0x127.MsgBody)localObject).uint64_oper_uin.has()) {
          break label680;
        }
        l1 = ((submsgtype0x127.MsgBody)localObject).uint64_oper_uin.get();
        if (!((submsgtype0x127.MsgBody)localObject).uint64_friend_uin.has()) {
          break label686;
        }
        l2 = ((submsgtype0x127.MsgBody)localObject).uint64_friend_uin.get();
        if (!((submsgtype0x127.MsgBody)localObject).uint64_seq.has()) {
          break label692;
        }
        l3 = ((submsgtype0x127.MsgBody)localObject).uint64_seq.get();
        paramArrayOfByte = ((submsgtype0x127.MsgBody)localObject).bytes_gray_tips.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("SingTogetherParser", 2, "decodePush0x210, actionType = " + j + " friend_uin = " + l2 + " oper_uin = " + l1 + " gray_tips = " + paramArrayOfByte + " timeStamp = " + l3 + " c2cJoinState" + i + " isOffLine=" + paramBoolean);
        }
        if (l2 == 0L)
        {
          QLog.d("SingTogetherParser", 1, "filter friendUin: " + l2 + ", operatorUin: " + l1);
          return;
          localObject = new submsgtype0x129.MsgBody();
          ((submsgtype0x129.MsgBody)localObject).mergeFrom(paramArrayOfByte);
          i = ((submsgtype0x129.MsgBody)localObject).join_state.get();
          j = ((submsgtype0x129.MsgBody)localObject).uint32_action_type.get();
          if (!((submsgtype0x129.MsgBody)localObject).uint64_oper_uin.has()) {
            break label698;
          }
          l1 = ((submsgtype0x129.MsgBody)localObject).uint64_oper_uin.get();
          if (!((submsgtype0x129.MsgBody)localObject).uint64_friend_uin.has()) {
            break label704;
          }
          l2 = ((submsgtype0x129.MsgBody)localObject).uint64_friend_uin.get();
          if (!((submsgtype0x129.MsgBody)localObject).uint64_seq.has()) {
            break label710;
          }
          l3 = ((submsgtype0x129.MsgBody)localObject).uint64_seq.get();
          paramArrayOfByte = ((submsgtype0x129.MsgBody)localObject).bytes_gray_tips.get().toStringUtf8();
          continue;
        }
        if (!paramBoolean) {
          break label584;
        }
        if ((j == 1) || (j == 2)) {
          break label520;
        }
        QLog.d("SingTogetherParser", 1, "filter offline msg, msgType:" + j);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label679;
        }
      }
      QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127f decode error, e=", paramQQAppInterface);
      return;
      label520:
      long l4 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
      if (l3 / 1000L < l4)
      {
        QLog.d("SingTogetherParser", 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", new Object[] { Long.valueOf(l3 / 1000L), Long.valueOf(l4) }));
        return;
      }
      label584:
      l4 = ((bdct)paramQQAppInterface.getManager(339)).a(4, 2, l2);
      if (l3 < l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + l4);
        }
      }
      else
      {
        a(paramQQAppInterface, i, j, l1, l2, l3, paramArrayOfByte, paramLong1, paramLong2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127 pbData = null");
        }
      }
      label679:
      return;
      label680:
      long l1 = 0L;
      continue;
      label686:
      long l2 = 0L;
      continue;
      label692:
      long l3 = 0L;
      continue;
      label698:
      l1 = 0L;
      continue;
      label704:
      l2 = 0L;
      continue;
      label710:
      l3 = 0L;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int j;
    Object localObject2;
    label32:
    int i;
    if (paramToServiceMsg != null)
    {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label73;
      }
      localObject2 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if (paramToServiceMsg == null) {
        break label80;
      }
      i = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
      label47:
      if (paramToServiceMsg != null) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, req == null || resp == null || data == null");
      }
    }
    label73:
    label80:
    label85:
    do
    {
      return;
      j = -1;
      break;
      localObject2 = "";
      break label32;
      i = -1;
      break label47;
      if ((j == 2) || (j == 1)) {
        break label131;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SingTogetherParser", 2, "sessionType not right =" + j);
    return;
    label131:
    boolean bool2 = false;
    Object localObject3 = (bdct)this.a.getManager(339);
    paramToServiceMsg = (SingTogetherSession)((bdct)localObject3).a(4, j, (String)localObject2);
    Object localObject1 = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject1 = (SingTogetherSession)bddg.a(4, j, (String)localObject2);
      ((bdct)localObject3).a(4, j, (String)localObject2, (bddf)localObject1);
    }
    boolean bool1;
    if (((SingTogetherSession)localObject1).a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      int k;
      try
      {
        localObject2 = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        if (localObject2 != null)
        {
          bool1 = bool2;
          k = ((aio_media.ResultInfo)localObject2).uint32_result.get();
          if (k != 0) {
            break label985;
          }
          bool1 = bool2;
          localObject3 = new StringBuilder("handleGetPlayingState seesion=");
          bool2 = true;
          bool1 = bool2;
          ((SingTogetherSession)localObject1).g = paramRspLatestPlayingState.enum_aio_state.get();
          bool1 = bool2;
          ((SingTogetherSession)localObject1).h = paramRspLatestPlayingState.enum_user_state.get();
          bool1 = bool2;
          if (!paramRspLatestPlayingState.uint64_create_uin.has()) {
            continue;
          }
          bool1 = bool2;
          paramToServiceMsg = Long.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
          bool1 = bool2;
          ((SingTogetherSession)localObject1).jdField_f_of_type_JavaLangString = String.valueOf(paramToServiceMsg);
          bool1 = bool2;
          ((SingTogetherSession)localObject1).jdField_c_of_type_Long = ((aio_media.ResultInfo)localObject2).uint64_svr_time.get();
          bool1 = bool2;
          ((SingTogetherSession)localObject1).jdField_d_of_type_Long = paramRspLatestPlayingState.uint64_aio_identification.get();
          bool1 = bool2;
          ((StringBuilder)localObject3).append(" status=").append(((SingTogetherSession)localObject1).g).append(" userState=").append(((SingTogetherSession)localObject1).h).append(" creator=").append(((SingTogetherSession)localObject1).jdField_f_of_type_JavaLangString).append(" timeStamp=").append(((SingTogetherSession)localObject1).jdField_c_of_type_Long);
          bool1 = bool2;
          if (paramRspLatestPlayingState.msg_ksing_info.has())
          {
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_b_of_type_Int = paramRspLatestPlayingState.msg_ksing_info.uint32_type.get();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_a_of_type_Long = paramRspLatestPlayingState.msg_ksing_info.uint64_id.get();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_a_of_type_JavaLangString = paramRspLatestPlayingState.msg_ksing_info.bytes_name.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_b_of_type_JavaLangString = paramRspLatestPlayingState.msg_ksing_info.bytes_jump.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_c_of_type_JavaLangString = paramRspLatestPlayingState.msg_ksing_info.bytes_cover.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_d_of_type_JavaLangString = paramRspLatestPlayingState.msg_ksing_info.bytes_song.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jdField_b_of_type_Long = paramRspLatestPlayingState.msg_ksing_info.uint64_singer.get();
            bool1 = bool2;
            ((StringBuilder)localObject3).append(" roomType=").append(((SingTogetherSession)localObject1).jdField_b_of_type_Int).append(" roomId=").append(((SingTogetherSession)localObject1).jdField_a_of_type_Long).append(" roomName=").append(((SingTogetherSession)localObject1).jdField_a_of_type_JavaLangString).append(" jumpUrl=").append(((SingTogetherSession)localObject1).jdField_b_of_type_JavaLangString).append(" roomCover=").append(((SingTogetherSession)localObject1).jdField_c_of_type_JavaLangString).append(" songName=").append(((SingTogetherSession)localObject1).jdField_d_of_type_JavaLangString).append(" singerUin=").append(((SingTogetherSession)localObject1).jdField_b_of_type_Long);
          }
          if (j != 1) {
            continue;
          }
          bool1 = bool2;
          ((SingTogetherSession)localObject1).jdField_f_of_type_Int = paramRspLatestPlayingState.uint32_joined_num.get();
          bool1 = bool2;
          ((StringBuilder)localObject3).append(" joinNum=").append(((SingTogetherSession)localObject1).jdField_f_of_type_Int);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            bool1 = bool2;
            QLog.d("SingTogetherParser", 2, ((StringBuilder)localObject3).toString());
          }
          paramToServiceMsg = "";
          bool1 = true;
          paramRspLatestPlayingState = paramToServiceMsg;
          bool2 = bool1;
          if (!TextUtils.isEmpty(((SingTogetherSession)localObject1).jdField_f_of_type_JavaLangString))
          {
            if (((SingTogetherSession)localObject1).jdField_e_of_type_Int != 2) {
              break label1055;
            }
            ContactUtils.getFriendNameCheckFriends(this.a, ((SingTogetherSession)localObject1).jdField_f_of_type_JavaLangString);
            bool2 = bool1;
            paramRspLatestPlayingState = paramToServiceMsg;
          }
          label815:
          a(bool2, (SingTogetherSession)localObject1, i, paramRspLatestPlayingState);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, isSuccess=" + bool2 + ", session= " + localObject1 + ", by=" + i);
          return;
        }
        k = -1;
        continue;
        paramToServiceMsg = "";
        continue;
        bool1 = bool2;
        if (!paramRspLatestPlayingState.enum_c2c_join_state.has()) {
          break label971;
        }
        bool1 = bool2;
        j = paramRspLatestPlayingState.enum_c2c_join_state.get();
        bool1 = bool2;
        ((SingTogetherSession)localObject1).jdField_a_of_type_Int = j;
        bool1 = bool2;
        ((StringBuilder)localObject3).append(" c2cStatus=").append(((SingTogetherSession)localObject1).jdField_a_of_type_Int);
        continue;
        QLog.d("SingTogetherParser", 1, "handleGetSingPlayingState exception", paramRspLatestPlayingState);
      }
      catch (Exception paramRspLatestPlayingState)
      {
        paramToServiceMsg = "";
      }
      label958:
      continue;
      label971:
      bool1 = bool2;
      j = ((SingTogetherSession)localObject1).jdField_a_of_type_Int;
      continue;
      label985:
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (((aio_media.ResultInfo)localObject2).bytes_errmsg.get() != null) {
          bool1 = bool2;
        }
      }
      for (paramToServiceMsg = ((aio_media.ResultInfo)localObject2).bytes_errmsg.get().toStringUtf8();; paramToServiceMsg = "")
      {
        try
        {
          QLog.d("SingTogetherParser", 1, String.format("handleGetSingPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(k), paramToServiceMsg }));
          bool1 = false;
        }
        catch (Exception paramRspLatestPlayingState)
        {
          label1055:
          bool1 = false;
        }
        ContactUtils.getTroopMemberName(this.a, ((SingTogetherSession)localObject1).jdField_e_of_type_JavaLangString, ((SingTogetherSession)localObject1).jdField_f_of_type_JavaLangString);
        paramRspLatestPlayingState = paramToServiceMsg;
        bool2 = bool1;
        break label815;
        break label958;
      }
      paramRspLatestPlayingState = "";
      bool2 = false;
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = ((bdct)this.a.getManager(339)).a(4, 2, String.valueOf(paramObject));
    } while (!(paramObject instanceof SingTogetherSession));
    paramObject.g = 3;
    paramObject.h = 3;
    bddg.a(this.a, paramObject.jdField_e_of_type_JavaLangString, false, paramObject.jdField_e_of_type_Int, 16777216);
    a(true, (SingTogetherSession)paramObject, 1007, "");
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = ((bdct)this.a.getManager(339)).a(4, 1, paramString);
    if ((paramString instanceof SingTogetherSession))
    {
      paramString.g = 3;
      paramString.h = 3;
      bddg.a(this.a, paramString.jdField_e_of_type_JavaLangString, false, paramString.jdField_e_of_type_Int, 16777216);
      a(true, (SingTogetherSession)paramString, 1007, "");
    }
  }
  
  public void a(boolean paramBoolean, SingTogetherSession paramSingTogetherSession, int paramInt, String paramString)
  {
    bdct localbdct = (bdct)this.a.getManager(339);
    bdcz localbdcz = localbdct.a(4, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
    if ((paramBoolean) && (paramInt == 1003))
    {
      int i = localbdcz.jdField_a_of_type_AndroidOsBundle.getInt("action_type");
      String str = localbdcz.jdField_a_of_type_AndroidOsBundle.getString("tips");
      long l1 = localbdcz.jdField_a_of_type_AndroidOsBundle.getLong("seq");
      long l2 = localbdcz.jdField_a_of_type_AndroidOsBundle.getLong("msgSeq");
      localbdct.a(paramSingTogetherSession, i, str, l1, l2, localbdcz.jdField_a_of_type_JavaLangObject);
      localbdct.b(paramSingTogetherSession, i, str, l1, l2, localbdcz.jdField_a_of_type_JavaLangObject);
    }
    if (paramSingTogetherSession.g == 3) {
      bddg.a(this.a, paramSingTogetherSession.jdField_e_of_type_JavaLangString, false, paramSingTogetherSession.jdField_e_of_type_Int, 16777216);
    }
    for (;;)
    {
      localbdct.a(paramBoolean, paramSingTogetherSession, paramInt, paramString);
      localbdct.b(4, paramSingTogetherSession.jdField_e_of_type_Int, paramSingTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
      return;
      bddg.a(this.a, paramSingTogetherSession.jdField_e_of_type_JavaLangString, true, paramSingTogetherSession.jdField_e_of_type_Int, 16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aura
 * JD-Core Version:    0.7.0.1
 */