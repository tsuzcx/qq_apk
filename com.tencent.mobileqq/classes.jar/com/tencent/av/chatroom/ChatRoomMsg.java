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
  private static long l;
  public ChatRoomInfo e;
  public final long f;
  public final String g;
  public final long h = d();
  public long i;
  public int j;
  public long k;
  private int m;
  
  public ChatRoomMsg(ChatRoomInfo paramChatRoomInfo, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    this.f = paramLong1;
    this.e = paramChatRoomInfo;
    this.g = paramString;
    this.i = paramLong2;
    this.k = paramLong3;
    this.j = paramInt;
    if (this.j == a)
    {
      paramChatRoomInfo = this.e;
      paramChatRoomInfo.e += 1;
    }
    this.m = 0;
  }
  
  private static long d()
  {
    long l1 = l + 1L;
    l = l1;
    return l1;
  }
  
  public void a(int paramInt)
  {
    ChatRoomInfo localChatRoomInfo;
    if (paramInt == c)
    {
      localChatRoomInfo = this.e;
      localChatRoomInfo.g += 1;
    }
    else if (paramInt == b)
    {
      localChatRoomInfo = this.e;
      localChatRoomInfo.f += 1;
    }
    if ((this.k == -9223372036854775808L) || (this.j != d)) {
      this.j = paramInt;
    }
  }
  
  public boolean a()
  {
    return this.k != -9223372036854775808L;
  }
  
  public boolean a(chatroom_sso.Msg paramMsg)
  {
    boolean bool2 = false;
    if (paramMsg == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.k == paramMsg.msg_id.get())
    {
      bool1 = bool2;
      if (this.f == paramMsg.uin.get())
      {
        bool1 = bool2;
        if (TextUtils.equals(this.g, paramMsg.msg.get())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.m += 1;
  }
  
  public boolean c()
  {
    return (this.j == b) && (this.m < 3) && (this.k == -9223372036854775808L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("ChatRoomMsg{senderUin: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", serverSeq: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", localSeq: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", state: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMsg
 * JD-Core Version:    0.7.0.1
 */