package com.tencent.av.ui.chatroom;

import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class VideoChatMessage
{
  public static final Object a = new Object();
  private static VideoChatMessage l = null;
  private static int m = 0;
  private int b;
  private QQText c;
  private String d;
  private int e;
  private String f;
  private String g;
  private String h;
  private long i;
  private String j;
  private VideoChatMessage k = null;
  
  public static void a(List<VideoChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int n = paramList.size() - 1;
      while (n >= 0)
      {
        VideoChatMessage localVideoChatMessage = (VideoChatMessage)paramList.remove(n);
        if (localVideoChatMessage != null) {
          localVideoChatMessage.d();
        }
        n -= 1;
      }
    }
  }
  
  public static VideoChatMessage e()
  {
    synchronized (a)
    {
      if (l != null)
      {
        VideoChatMessage localVideoChatMessage = l;
        l = localVideoChatMessage.k;
        localVideoChatMessage.k = null;
        m -= 1;
        return localVideoChatMessage;
      }
      return new VideoChatMessage();
    }
  }
  
  public CharSequence a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = ChatRoomUtil.a(paramString, 16);
  }
  
  public String b()
  {
    return this.g;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public String c()
  {
    return this.j;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public void d()
  {
    this.b = 0;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.g = null;
    this.h = null;
    this.i = 0L;
    this.f = null;
    this.j = null;
    synchronized (a)
    {
      if (m < 200)
      {
        this.k = l;
        l = this;
        m += 1;
      }
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoChatMessage{type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filepath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sendState=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", time='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", header='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", voiceTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", msgId='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatMessage
 * JD-Core Version:    0.7.0.1
 */