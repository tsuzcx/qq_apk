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
  public static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static int a(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if (j == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        return 0;
      }
      j = 0;
      while (i < paramInt)
      {
        j = (int)(j | (paramArrayOfByte[i] & 0xFF) << (paramInt - i - 1) * 8);
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  public static long a(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  public static long a(String paramString)
  {
    String str1;
    String str2;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return 0L;
      }
      str1 = paramString;
      str2 = paramString;
    }
    try
    {
      if (paramString.startsWith("+"))
      {
        str2 = paramString;
        str1 = paramString.substring(1);
      }
      str2 = str1;
      long l = CharacterUtil.a(str1);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString)
    {
      label56:
      break label56;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("uin = ");
      paramString.append(str2);
      paramString.append(" is error");
      QLog.d("VideoPackageUtils", 2, paramString.toString());
    }
    return 0L;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    long l1 = 0L;
    long l2 = l1;
    if (i == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        return 0L;
      }
      paramInt -= 1;
      for (;;)
      {
        l2 = l1;
        if (paramInt < 0) {
          break;
        }
        l1 |= (paramArrayOfByte[paramInt] & 0xFF) << paramInt * 8;
        paramInt -= 1;
      }
    }
    return l2;
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
          if (!((hd_video.VideoHead)localObject).int32_sub_service_type.has()) {
            break label319;
          }
          i = ((hd_video.VideoHead)localObject).int32_sub_service_type.get();
          localVideoPacket.jdField_b_of_type_Int = i;
          localVideoPacket.jdField_c_of_type_Int = ((hd_video.VideoHead)localObject).uint32_seq.get();
          localVideoPacket.jdField_a_of_type_Long = ((hd_video.VideoHead)localObject).uint64_room_id.get();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("nearby.video.multiMsg", 2, " head not exist");
        }
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
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(" --- parse video message ");
        paramArrayOfByte.append(localVideoPacket.toString());
        QLog.d("VideoPackageUtils", 1, paramArrayOfByte.toString());
        return localVideoPacket;
      }
      catch (Exception paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" invalid format:");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.e("VideoPackageUtils", 1, ((StringBuilder)localObject).toString());
        return localVideoPacket;
      }
      label319:
      int i = -1;
    }
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if (j == paramInt)
    {
      if (paramArrayOfByte.length > 2) {
        return 0;
      }
      short s = 0;
      while (i < paramInt)
      {
        s = (short)(int)(s | (paramArrayOfByte[i] & 0xFF) << (paramInt - i - 1) * 8);
        i += 1;
      }
      return s;
    }
    return 0;
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    long l1 = 0L;
    long l2 = l1;
    if (i == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        return 0L;
      }
      i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramInt) {
          break;
        }
        l1 |= (paramArrayOfByte[i] & 0xFF) << (paramInt - i - 1) * 8;
        i += 1;
      }
    }
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoPackageUtils
 * JD-Core Version:    0.7.0.1
 */