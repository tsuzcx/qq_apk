import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeVideo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.VideoChangePushInfo;

public class aqqn
  implements axne
{
  private QQAppInterface a;
  
  public aqqn(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WatchTogetherParser", 0, "insertGrayTips begin uin:" + paramLong1 + " uinType:" + paramInt1 + " grayTips:" + paramString + " sub_type:" + paramInt2 + " msgSeq:" + paramLong2 + " msgTime:" + paramLong3 + " grayId=" + paramInt3);
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
      paramString = new aqax((String)localObject, (String)localObject, paramString, paramInt1, i, paramInt3, awao.a());
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).hasRead = 0;
      ((MessageForUniteGrayTip)localObject).subType = paramInt2;
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
      ((MessageForUniteGrayTip)localObject).tipParam.d = (paramLong1 + "_" + paramInt1 + "_watch_together_" + paramLong2 + "_" + paramLong3);
      bool = aqay.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("WatchTogetherParser", 0, "insertGrayTips end  res:" + bool + " grayTipKey:" + ((MessageForUniteGrayTip)localObject).tipParam.d);
  }
  
  private void a(QQAppInterface paramQQAppInterface, WatchTogetherSession paramWatchTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.VideoChangePushInfo paramVideoChangePushInfo)
  {
    axmt localaxmt = (axmt)paramQQAppInterface.getManager(339);
    localaxmt.a(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramLong2);
    WatchTogetherSession localWatchTogetherSession2 = (WatchTogetherSession)localaxmt.a(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString);
    WatchTogetherSession localWatchTogetherSession1;
    if (localWatchTogetherSession2 != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        localWatchTogetherSession2.jdField_f_of_type_Int = paramWatchTogetherSession.jdField_f_of_type_Int;
      }
      if ((paramInt != 1) && (paramInt != 2))
      {
        localWatchTogetherSession1 = localWatchTogetherSession2;
        if (paramInt != 5) {}
      }
      else
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
          break label283;
        }
        axng.a(paramQQAppInterface, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, true);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localWatchTogetherSession1.jdField_e_of_type_JavaLangString))
      {
        paramQQAppInterface = localaxmt.a(2, 1, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, 1003);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putInt("action_type", paramInt);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putString("tips", paramString);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putLong("seq", paramLong2);
        paramQQAppInterface.jdField_a_of_type_AndroidOsBundle.putLong("msgSeq", paramLong3);
        paramQQAppInterface.jdField_a_of_type_JavaLangObject = paramVideoChangePushInfo;
        localaxmt.a(2, 1, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, 1003);
      }
      return;
      localaxmt.a(paramWatchTogetherSession.jdField_d_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_Int, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramWatchTogetherSession);
      localWatchTogetherSession1 = paramWatchTogetherSession;
      break;
      label283:
      if (paramInt == 2) {
        axng.a(paramQQAppInterface, localWatchTogetherSession1.jdField_e_of_type_JavaLangString, false);
      }
    }
  }
  
  private void a(boolean paramBoolean, WatchTogetherSession paramWatchTogetherSession, int paramInt, String paramString)
  {
    axmt localaxmt = (axmt)this.a.getManager(339);
    axmz localaxmz = localaxmt.a(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
    if ((paramBoolean) && (paramInt == 1003) && ((localaxmz.jdField_a_of_type_JavaLangObject instanceof TroopTips0x857.VideoChangePushInfo)))
    {
      int i = localaxmz.jdField_a_of_type_AndroidOsBundle.getInt("action_type");
      String str = localaxmz.jdField_a_of_type_AndroidOsBundle.getString("tips");
      long l1 = localaxmz.jdField_a_of_type_AndroidOsBundle.getLong("seq");
      long l2 = localaxmz.jdField_a_of_type_AndroidOsBundle.getLong("msgSeq");
      localaxmt.a(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)localaxmz.jdField_a_of_type_JavaLangObject);
      localaxmt.b(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)localaxmz.jdField_a_of_type_JavaLangObject);
    }
    if (paramWatchTogetherSession.g == 3) {
      axng.a(this.a, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, false);
    }
    for (;;)
    {
      localaxmt.a(paramBoolean, paramWatchTogetherSession, paramInt, paramString);
      localaxmt.b(2, 1, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
      return;
      axng.a(this.a, paramWatchTogetherSession.jdField_e_of_type_JavaLangString, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    axnf localaxnf = ((axmt)this.a.getManager(339)).a(2, 1, paramString);
    if ((localaxnf instanceof WatchTogetherSession))
    {
      localaxnf.g = 3;
      localaxnf.jdField_h_of_type_Int = 3;
      axng.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localaxnf, 1007, "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.VideoChangePushInfo)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 0, "handleBusinessTogetherGroupPush, object is error");
      }
    }
    label56:
    label77:
    label98:
    label119:
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
          break label526;
        }
        long l1;
        if (localVideoChangePushInfo.uint64_seq.has())
        {
          l1 = localVideoChangePushInfo.uint64_seq.get();
          if (!localVideoChangePushInfo.uint32_action_type.has()) {
            break label321;
          }
          i = localVideoChangePushInfo.uint32_action_type.get();
          if (!localVideoChangePushInfo.uint64_group_id.has()) {
            break label327;
          }
          l2 = localVideoChangePushInfo.uint64_group_id.get();
          if (!localVideoChangePushInfo.uint64_oper_uin.has()) {
            break label335;
          }
          l3 = localVideoChangePushInfo.uint64_oper_uin.get();
          if (!localVideoChangePushInfo.uint32_join_nums.has()) {
            break label343;
          }
          j = localVideoChangePushInfo.uint32_join_nums.get();
          if (!localVideoChangePushInfo.bytes_gray_tips.has()) {
            break label349;
          }
        }
        for (paramObject = localVideoChangePushInfo.bytes_gray_tips.get().toStringUtf8();; paramObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 0, "handleWatchTogetherGroupPush, seq=" + l1 + ", actionType=" + i + ", groupid=" + l2 + ", uin=" + l3 + ", joinNum=" + j + ", tips=" + paramObject);
          }
          long l4 = ((axmt)paramQQAppInterface.getManager(339)).a(2, 1, l2);
          if (l1 >= l4) {
            break label355;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WatchTogetherParser", 0, "handleWatchTogetherGroupPush, skip pushinfo, old seq=" + l4);
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
        WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)axng.a(2, 1, String.valueOf(l2));
        if ((i == 1) || (i == 2) || (i == 5))
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
    label321:
    label327:
    label335:
    label343:
    label349:
    label355:
    QLog.d("WatchTogetherParser", 0, "handleWatchTogetherGroupPush, pushinfo is null.");
    label526:
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
        QLog.d("WatchTogetherParser", 0, "handleGetWatchPlayingState, req == null || resp == null || data == null");
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
    axmt localaxmt = (axmt)this.a.getManager(339);
    paramToServiceMsg = (WatchTogetherSession)localaxmt.a(2, 1, str);
    Object localObject = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject = (WatchTogetherSession)axng.a(2, 1, str);
      localaxmt.a(2, 1, str, (axnf)localObject);
    }
    boolean bool1;
    label416:
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
        ((WatchTogetherSession)localObject).jdField_d_of_type_Long = paramRspLatestPlayingState.uint64_aio_identification.get();
        if (!paramRspLatestPlayingState.msg_room_info.has()) {
          break label624;
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
        break label588;
        paramToServiceMsg = "";
        break label547;
        paramToServiceMsg = "";
        bool1 = true;
        break label416;
      }
      paramRspLatestPlayingState = paramToServiceMsg;
      bool2 = bool1;
      if (!TextUtils.isEmpty(((WatchTogetherSession)localObject).jdField_f_of_type_JavaLangString))
      {
        babh.h(this.a, ((WatchTogetherSession)localObject).jdField_e_of_type_JavaLangString, ((WatchTogetherSession)localObject).jdField_f_of_type_JavaLangString);
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
      QLog.d("WatchTogetherParser", 0, "handleGetWatchPlayingState, isSuccess=" + bool2 + ", session= " + localObject + ", by=" + i);
      return;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_errmsg.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      }
      label547:
      label588:
      label624:
      paramRspLatestPlayingState = "";
      bool2 = false;
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString, int paramInt)
  {
    axnf localaxnf = ((axmt)this.a.getManager(339)).a(2, 1, paramString);
    if ((localaxnf instanceof WatchTogetherSession))
    {
      localaxnf.g = 3;
      localaxnf.jdField_h_of_type_Int = 3;
      axng.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localaxnf, 1007, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqn
 * JD-Core Version:    0.7.0.1
 */