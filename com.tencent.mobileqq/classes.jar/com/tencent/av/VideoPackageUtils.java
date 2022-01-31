package com.tencent.av;

import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.longconn.hd_video.CmdS2CInviteReqBody;
import tencent.im.cs.longconn.hd_video.InviteTempSessionData;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.VideoHead;

public class VideoPackageUtils
{
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        j = k;
      }
    }
    else {
      return j;
    }
    k = 0;
    for (;;)
    {
      j = i;
      if (k >= paramInt) {
        break;
      }
      i = (int)(i | (paramArrayOfByte[k] & 0xFF) << (paramInt - k - 1) * 8);
      k += 1;
    }
  }
  
  public static long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str2;
    do
    {
      for (;;)
      {
        return 0L;
        String str1 = paramString;
        str2 = paramString;
        try
        {
          if (paramString.startsWith("+"))
          {
            str2 = paramString;
            str1 = paramString.substring(1);
          }
          str2 = str1;
          long l = CharacterUtil.a(str1);
          if (l >= 10000L) {
            return l;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoPackageUtils", 2, "uin = " + str2 + " is error");
    return 0L;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j;
    for (int i = 0;; i = j)
    {
      l2 = l1;
      if (i >= paramInt) {
        break;
      }
      l2 = paramArrayOfByte[i];
      j = i + 1;
      l1 = (l2 & 0xFF) << (paramInt - i - 1) * 8 | l1;
    }
  }
  
  public static VideoPackageUtils.VideoPacket a(byte[] paramArrayOfByte)
  {
    VideoPackageUtils.VideoPacket localVideoPacket = new VideoPackageUtils.VideoPacket();
    Object localObject = new hd_video.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (hd_video.MsgBody)((hd_video.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.msg_video_head.has())
        {
          localObject = (hd_video.VideoHead)paramArrayOfByte.msg_video_head.get();
          localVideoPacket.jdField_a_of_type_JavaLangString = ((hd_video.VideoHead)localObject).str_from_mobile.get();
          localVideoPacket.jdField_b_of_type_JavaLangString = ((hd_video.VideoHead)localObject).str_from_nation.get();
          localVideoPacket.jdField_a_of_type_Int = ((hd_video.VideoHead)localObject).enum_body_type.get();
          localVideoPacket.jdField_b_of_type_Long = ((hd_video.VideoHead)localObject).uint64_uin.get();
          if (((hd_video.VideoHead)localObject).int32_sub_service_type.has())
          {
            i = ((hd_video.VideoHead)localObject).int32_sub_service_type.get();
            localVideoPacket.jdField_b_of_type_Int = i;
            localVideoPacket.jdField_c_of_type_Int = ((hd_video.VideoHead)localObject).uint32_seq.get();
            localVideoPacket.jdField_a_of_type_Long = ((hd_video.VideoHead)localObject).uint64_room_id.get();
            if (paramArrayOfByte.msg_invite_body.has())
            {
              paramArrayOfByte = (hd_video.CmdS2CInviteReqBody)paramArrayOfByte.msg_invite_body.get();
              localVideoPacket.jdField_c_of_type_Long = paramArrayOfByte.uint64_from_uin.get();
              localVideoPacket.jdField_d_of_type_Int = paramArrayOfByte.uint32_new_business_flag.get();
              localVideoPacket.jdField_a_of_type_Boolean = paramArrayOfByte.bool_terminal_switch_flag.get();
              if (paramArrayOfByte.msg_temp_session.has())
              {
                paramArrayOfByte = paramArrayOfByte.msg_temp_session;
                localVideoPacket.jdField_d_of_type_Long = paramArrayOfByte.uint64_group_uin.get();
                localVideoPacket.e = paramArrayOfByte.uint32_relationship_type.get();
              }
            }
            QLog.d("VideoPackageUtils", 1, " --- parse video message " + localVideoPacket.toString());
            return localVideoPacket;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("nearby.video.multiMsg", 2, " head not exist");
          continue;
        }
        int i = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VideoPackageUtils", 1, " invalid format:" + paramArrayOfByte.toString());
        return localVideoPacket;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.VideoPackageUtils
 * JD-Core Version:    0.7.0.1
 */