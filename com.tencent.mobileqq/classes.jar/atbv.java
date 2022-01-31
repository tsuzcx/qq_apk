import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeVideo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.VideoChangePushInfo;

public class atbv
  implements balj
{
  private QQAppInterface a;
  
  public atbv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WatchTogetherParser", 2, "insertGrayTips begin uin:" + paramLong1 + " uinType:" + paramInt1 + " grayTips:" + paramString + " sub_type:" + paramInt2 + " msgSeq:" + paramLong2 + " msgTime:" + paramLong3 + " grayId=" + paramInt3);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramLong1 <= 0L)) {}
    Object localObject;
    boolean bool;
    do
    {
      return;
      int i = -5020;
      if ((paramInt2 == 2) || (paramInt2 == 5)) {
        i = -5040;
      }
      localObject = String.valueOf(paramLong1);
      paramString = new aslp((String)localObject, (String)localObject, paramString, paramInt1, i, paramInt3, ayvc.a());
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).hasRead = 0;
      ((MessageForUniteGrayTip)localObject).subType = paramInt2;
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
      ((MessageForUniteGrayTip)localObject).tipParam.d = (paramLong1 + "_" + paramInt1 + "_watch_together_" + paramLong2 + "_" + paramLong3);
      bool = aslq.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("WatchTogetherParser", 2, "insertGrayTips end  res:" + bool + " grayTipKey:" + ((MessageForUniteGrayTip)localObject).tipParam.d);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    balk localbalk = ((baky)this.a.getManager(339)).a(2, 1, paramString);
    if ((localbalk instanceof WatchTogetherSession))
    {
      localbalk.g = 3;
      localbalk.jdField_h_of_type_Int = 3;
      ball.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localbalk, 1007, "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.VideoChangePushInfo)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleBusinessTogetherGroupPush, object is error");
      }
    }
    label56:
    label77:
    label98:
    label119:
    label505:
    do
    {
      int i;
      long l2;
      long l3;
      String str;
      do
      {
        return;
        TroopTips0x857.VideoChangePushInfo localVideoChangePushInfo = (TroopTips0x857.VideoChangePushInfo)paramObject;
        if (localVideoChangePushInfo == null) {
          break label505;
        }
        long l1;
        if (localVideoChangePushInfo.uint64_seq.has())
        {
          l1 = localVideoChangePushInfo.uint64_seq.get();
          if (!localVideoChangePushInfo.uint32_action_type.has()) {
            break label314;
          }
          i = localVideoChangePushInfo.uint32_action_type.get();
          if (!localVideoChangePushInfo.uint64_group_id.has()) {
            break label320;
          }
          l2 = localVideoChangePushInfo.uint64_group_id.get();
          if (!localVideoChangePushInfo.uint64_oper_uin.has()) {
            break label328;
          }
          l3 = localVideoChangePushInfo.uint64_oper_uin.get();
          if (!localVideoChangePushInfo.uint32_join_nums.has()) {
            break label336;
          }
          j = localVideoChangePushInfo.uint32_join_nums.get();
          if (!localVideoChangePushInfo.bytes_gray_tips.has()) {
            break label342;
          }
        }
        for (paramObject = localVideoChangePushInfo.bytes_gray_tips.get().toStringUtf8();; paramObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, seq=" + l1 + ", actionType=" + i + ", groupid=" + l2 + ", uin=" + l3 + ", joinNum=" + j + ", tips=" + paramObject);
          }
          long l4 = ((baky)paramQQAppInterface.getManager(339)).a(2, 1, l2);
          if (l1 >= l4) {
            break label348;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, skip pushinfo, old seq=" + l4);
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
        WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)ball.a(2, 1, String.valueOf(l2));
        if (i == 1)
        {
          if (l3 != -1L) {
            break;
          }
          str = "";
          localWatchTogetherSession.jdField_f_of_type_JavaLangString = str;
        }
        if ((i == 1) || (i == 3) || (i == 4)) {
          localWatchTogetherSession.jdField_f_of_type_Int = j;
        }
        a(paramQQAppInterface, localWatchTogetherSession, i, l3, paramObject, l1, paramLong1, localVideoChangePushInfo);
      } while (((i != 5) && (i != 2)) || (TextUtils.isEmpty(paramObject)) || (l2 == -1L));
      if (i == 5) {}
      for (int j = 131085;; j = 131084)
      {
        a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, j);
        return;
        str = String.valueOf(l3);
        break;
      }
    } while (!QLog.isColorLevel());
    label140:
    label314:
    label320:
    label328:
    label336:
    label342:
    label348:
    QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, pushinfo is null.");
  }
  
  public void a(QQAppInterface paramQQAppInterface, WatchTogetherSession paramWatchTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.VideoChangePushInfo paramVideoChangePushInfo)
  {
    baky localbaky = (baky)paramQQAppInterface.getManager(339);
    localbaky.a(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramLong2);
    WatchTogetherSession localWatchTogetherSession2 = (WatchTogetherSession)localbaky.a(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString);
    WatchTogetherSession localWatchTogetherSession1;
    if (localWatchTogetherSession2 != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        localWatchTogetherSession2.jdField_f_of_type_Int = paramWatchTogetherSession.jdField_f_of_type_Int;
      }
      localWatchTogetherSession1 = localWatchTogetherSession2;
      if (paramInt == 1)
      {
        localWatchTogetherSession1 = localWatchTogetherSession2;
        if (!TextUtils.isEmpty(paramWatchTogetherSession.jdField_f_of_type_JavaLangString))
        {
          localWatchTogetherSession2.jdField_f_of_type_JavaLangString = paramWatchTogetherSession.jdField_f_of_type_JavaLangString;
          localWatchTogetherSession1 = localWatchTogetherSession2;
        }
      }
      if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1)))
      {
        if ((paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
          break label277;
        }
        ball.a(paramQQAppInterface, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, true);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localWatchTogetherSession1.jdField_e_of_type_JavaLangString))
      {
        paramQQAppInterface = localbaky.a(2, 1, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, 1003);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putInt("action_type", paramInt);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putString("tips", paramString);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putLong("seq", paramLong2);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putLong("msgSeq", paramLong3);
        paramQQAppInterface.jdField_a_of_type_JavaLangObject = paramVideoChangePushInfo;
        localbaky.a(2, 1, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, 1003);
      }
      return;
      localbaky.a(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramWatchTogetherSession);
      localWatchTogetherSession1 = paramWatchTogetherSession;
      break;
      label277:
      if (paramInt == 2) {
        ball.a(paramQQAppInterface, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, false);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int k = -1;
    int j;
    String str;
    label35:
    int i;
    if (paramToServiceMsg != null)
    {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label76;
      }
      str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if (paramToServiceMsg == null) {
        break label83;
      }
      i = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
      label50:
      if (paramToServiceMsg != null) {
        break label88;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, req == null || resp == null || data == null");
      }
    }
    label76:
    label83:
    label88:
    while (j == 2)
    {
      return;
      j = -1;
      break;
      str = "";
      break label35;
      i = -1;
      break label50;
    }
    baky localbaky = (baky)this.a.getManager(339);
    paramToServiceMsg = (WatchTogetherSession)localbaky.a(2, 1, str);
    Object localObject = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject = (WatchTogetherSession)ball.a(2, 1, str);
      localbaky.a(2, 1, str, (balk)localObject);
    }
    boolean bool1;
    label470:
    boolean bool2;
    if (((WatchTogetherSession)localObject).a())
    {
      try
      {
        paramToServiceMsg = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        j = k;
        if (paramToServiceMsg != null) {
          j = paramToServiceMsg.uint32_result.get();
        }
        if (j != 0) {}
      }
      catch (Exception paramRspLatestPlayingState)
      {
        for (;;)
        {
          try
          {
            QLog.d("WatchTogetherParser", 1, String.format("handleGetWatchPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(j), paramToServiceMsg }));
            bool1 = false;
          }
          catch (Exception paramRspLatestPlayingState)
          {
            bool1 = false;
            continue;
          }
          paramRspLatestPlayingState = paramRspLatestPlayingState;
          paramToServiceMsg = "";
          bool1 = false;
          QLog.d("WatchTogetherParser", 1, "handleGetWatchPlayingState exception", paramRspLatestPlayingState);
        }
      }
      try
      {
        ((WatchTogetherSession)localObject).g = paramRspLatestPlayingState.enum_aio_state.get();
        ((WatchTogetherSession)localObject).jdField_h_of_type_Int = paramRspLatestPlayingState.enum_user_state.get();
        ((WatchTogetherSession)localObject).jdField_f_of_type_JavaLangString = String.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
        ((WatchTogetherSession)localObject).jdField_f_of_type_Int = paramRspLatestPlayingState.uint32_joined_num.get();
        ((WatchTogetherSession)localObject).jdField_c_of_type_Long = paramToServiceMsg.uint64_svr_time.get();
        ((WatchTogetherSession)localObject).jdField_e_of_type_Long = ((WatchTogetherSession)localObject).jdField_d_of_type_Long;
        ((WatchTogetherSession)localObject).jdField_d_of_type_Long = paramRspLatestPlayingState.uint64_aio_identification.get();
        if (((WatchTogetherSession)localObject).jdField_d_of_type_Long != ((WatchTogetherSession)localObject).jdField_e_of_type_Long) {
          ((WatchTogetherSession)localObject).k = 0;
        }
        if ((((WatchTogetherSession)localObject).jdField_h_of_type_Int == 2) && (((WatchTogetherSession)localObject).g == 1)) {
          ((WatchTogetherSession)localObject).k = 1;
        }
        if (!paramRspLatestPlayingState.msg_room_info.has()) {
          break label678;
        }
        ((WatchTogetherSession)localObject).jdField_a_of_type_Int = paramRspLatestPlayingState.msg_room_info.uint32_type.get();
        ((WatchTogetherSession)localObject).jdField_a_of_type_Long = paramRspLatestPlayingState.msg_room_info.uint64_id.get();
        ((WatchTogetherSession)localObject).b = paramRspLatestPlayingState.msg_room_info.bytes_name.get().toStringUtf8();
        ((WatchTogetherSession)localObject).jdField_a_of_type_JavaLangString = paramRspLatestPlayingState.msg_room_info.bytes_jump.get().toStringUtf8();
        ((WatchTogetherSession)localObject).jdField_c_of_type_JavaLangString = paramRspLatestPlayingState.msg_room_info.bytes_cover.get().toStringUtf8();
        ((WatchTogetherSession)localObject).i = paramRspLatestPlayingState.msg_room_info.enum_video_type.get();
        ((WatchTogetherSession)localObject).j = paramRspLatestPlayingState.msg_room_info.enum_video_jump_type.get();
        ((WatchTogetherSession)localObject).jdField_h_of_type_JavaLangString = paramRspLatestPlayingState.msg_room_info.bytes_video_jump_value.get().toStringUtf8();
        paramToServiceMsg = "";
        bool1 = true;
      }
      catch (Exception paramRspLatestPlayingState)
      {
        paramToServiceMsg = "";
        bool1 = true;
        break label642;
        paramToServiceMsg = "";
        break label601;
        paramToServiceMsg = "";
        bool1 = true;
        break label470;
      }
      paramRspLatestPlayingState = paramToServiceMsg;
      bool2 = bool1;
      if (!TextUtils.isEmpty(((WatchTogetherSession)localObject).jdField_f_of_type_JavaLangString))
      {
        bdbt.h(this.a, ((WatchTogetherSession)localObject).jdField_e_of_type_JavaLangString, ((WatchTogetherSession)localObject).jdField_f_of_type_JavaLangString);
        bool2 = bool1;
        paramRspLatestPlayingState = paramToServiceMsg;
      }
    }
    for (;;)
    {
      a(bool2, (WatchTogetherSession)localObject, i, paramRspLatestPlayingState);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, isSuccess=" + bool2 + ", session= " + localObject + ", by=" + i);
      return;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_errmsg.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      }
      label601:
      paramRspLatestPlayingState = "";
      label642:
      label678:
      bool2 = false;
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString, int paramInt)
  {
    balk localbalk = ((baky)this.a.getManager(339)).a(2, 1, paramString);
    if ((localbalk instanceof WatchTogetherSession))
    {
      localbalk.g = 3;
      localbalk.jdField_h_of_type_Int = 3;
      ball.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localbalk, 1007, "");
    }
  }
  
  public void a(boolean paramBoolean, WatchTogetherSession paramWatchTogetherSession, int paramInt, String paramString)
  {
    baky localbaky = (baky)this.a.getManager(339);
    Object localObject = localbaky.a(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
    if ((paramBoolean) && (paramInt == 1003) && ((((bale)localObject).jdField_a_of_type_JavaLangObject instanceof TroopTips0x857.VideoChangePushInfo)))
    {
      int i = ((bale)localObject).jdField_a_of_type_AndroidOsBundle.getInt("action_type");
      String str = ((bale)localObject).jdField_a_of_type_AndroidOsBundle.getString("tips");
      long l1 = ((bale)localObject).jdField_a_of_type_AndroidOsBundle.getLong("seq");
      long l2 = ((bale)localObject).jdField_a_of_type_AndroidOsBundle.getLong("msgSeq");
      localbaky.a(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((bale)localObject).jdField_a_of_type_JavaLangObject);
      localbaky.b(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((bale)localObject).jdField_a_of_type_JavaLangObject);
    }
    boolean bool1;
    label201:
    boolean bool2;
    if (paramWatchTogetherSession.g == 3)
    {
      ball.a(this.a, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, false);
      if ((paramWatchTogetherSession.g == 1) && (paramWatchTogetherSession.jdField_h_of_type_Int == 2))
      {
        if ((paramWatchTogetherSession.jdField_a_of_type_Int == 1) || (paramWatchTogetherSession.jdField_a_of_type_Int == 0)) {
          break label540;
        }
        bool1 = true;
        if ((TextUtils.isEmpty(paramWatchTogetherSession.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramWatchTogetherSession.jdField_h_of_type_JavaLangString))) {
          break label546;
        }
        bool2 = true;
        label224:
        if ((!bool1) || (!bool2) || (!atbd.b(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramWatchTogetherSession.jdField_e_of_type_Int))) {
          break label561;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "isSameFloatingInfo");
        }
        localObject = new WatchTogetherFloatingData();
        ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.jdField_e_of_type_JavaLangString);
        ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.jdField_e_of_type_Int);
        ((WatchTogetherFloatingData)localObject).setSmallUrl(paramWatchTogetherSession.jdField_a_of_type_JavaLangString);
        ((WatchTogetherFloatingData)localObject).setBigUrl(paramWatchTogetherSession.jdField_h_of_type_JavaLangString);
        if ((!((TroopManager)this.a.getManager(52)).c(paramWatchTogetherSession.jdField_e_of_type_JavaLangString).isAdmin()) && (!paramWatchTogetherSession.jdField_f_of_type_JavaLangString.equals(this.a.c()))) {
          break label552;
        }
        ((WatchTogetherFloatingData)localObject).setIsAdm(true);
        label360:
        atbd.a(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
      }
    }
    for (;;)
    {
      if ((paramWatchTogetherSession.g == 3) || (paramWatchTogetherSession.jdField_h_of_type_Int == 1) || (paramWatchTogetherSession.jdField_h_of_type_Int == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "session.state=" + paramWatchTogetherSession.g + " session.userState=" + paramWatchTogetherSession.jdField_h_of_type_Int + " uin=" + paramWatchTogetherSession.jdField_e_of_type_JavaLangString + " type=" + paramWatchTogetherSession.jdField_e_of_type_Int);
        }
        localObject = new WatchTogetherFloatingData();
        ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.jdField_e_of_type_JavaLangString);
        ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.jdField_e_of_type_Int);
        atbd.a(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
      }
      localbaky.a(paramBoolean, paramWatchTogetherSession, paramInt, paramString);
      localbaky.b(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
      return;
      ball.a(this.a, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, true);
      break;
      label540:
      bool1 = false;
      break label201;
      label546:
      bool2 = false;
      break label224;
      label552:
      ((WatchTogetherFloatingData)localObject).setIsAdm(false);
      break label360;
      label561:
      if (atbd.b(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramWatchTogetherSession.jdField_e_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "isSameFloatingInfo but param error isSupportRoomType=" + bool1 + " isUrlValid=" + bool2);
        }
        atbd.a(false, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramWatchTogetherSession.jdField_e_of_type_Int, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbv
 * JD-Core Version:    0.7.0.1
 */