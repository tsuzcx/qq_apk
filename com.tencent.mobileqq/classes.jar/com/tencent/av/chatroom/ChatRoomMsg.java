package com.tencent.av.chatroom;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.av.chatroom.chatroom_sso.Msg;

public class ChatRoomMsg
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  private static long e;
  public final long a;
  public ChatRoomInfo a;
  public final String a;
  public final long b;
  public long c;
  public long d;
  public int e;
  private int f;
  
  public ChatRoomMsg(ChatRoomInfo paramChatRoomInfo, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    this.jdField_b_of_type_Long = a();
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo = paramChatRoomInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_d_of_type_Long = paramLong3;
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == jdField_a_of_type_Int)
    {
      paramChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      paramChatRoomInfo.jdField_b_of_type_Int += 1;
    }
    this.f = 0;
  }
  
  private static long a()
  {
    long l = jdField_e_of_type_Long + 1L;
    jdField_e_of_type_Long = l;
    return l;
  }
  
  public void a()
  {
    this.f += 1;
  }
  
  public void a(int paramInt)
  {
    ChatRoomInfo localChatRoomInfo;
    if (paramInt == jdField_c_of_type_Int)
    {
      localChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      localChatRoomInfo.jdField_d_of_type_Int += 1;
    }
    else if (paramInt == jdField_b_of_type_Int)
    {
      localChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      localChatRoomInfo.jdField_c_of_type_Int += 1;
    }
    if ((this.jdField_d_of_type_Long == -9223372036854775808L) || (this.jdField_e_of_type_Int != jdField_d_of_type_Int)) {
      this.jdField_e_of_type_Int = paramInt;
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Long != -9223372036854775808L;
  }
  
  public boolean a(chatroom_sso.Msg paramMsg)
  {
    boolean bool2 = false;
    if (paramMsg == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.jdField_d_of_type_Long == paramMsg.msg_id.get())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Long == paramMsg.uin.get())
      {
        bool1 = bool2;
        if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramMsg.msg.get())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    return (this.jdField_e_of_type_Int == jdField_b_of_type_Int) && (this.f < 3) && (this.jdField_d_of_type_Long == -9223372036854775808L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("ChatRoomMsg{senderUin: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", serverSeq: ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", localSeq: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", state: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMsg
 * JD-Core Version:    0.7.0.1
 */