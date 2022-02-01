package com.tencent.av.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ShareChat$1
  implements ShareChat.SharePanel.IHandle
{
  ShareChat$1(ShareChat paramShareChat, long paramLong) {}
  
  public int a()
  {
    return 99;
  }
  
  public Bitmap a(long paramLong)
  {
    if (this.b.c == null) {
      return null;
    }
    return this.b.c.getTroopFaceBitmap(this.b.a, (byte)3, false, false);
  }
  
  public String a(int paramInt)
  {
    return null;
  }
  
  public String a(long paramLong, int paramInt)
  {
    if (this.b.b == null) {
      return null;
    }
    String str = ShareChat.a(this.b, paramInt);
    if (TextUtils.isEmpty(str))
    {
      ShareChat localShareChat = this.b;
      localShareChat.a(paramLong, localShareChat.d, this.b.e);
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinish, choosedChannel[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], choosedLinkType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], result[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    ShareChatReport.b(paramInt1, paramInt2);
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, 99, null);
    }
  }
  
  public long b()
  {
    return this.b.d;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQRForward, choosedChannel[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], choosedLinkType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], result[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, 99, null);
    }
  }
  
  public int c()
  {
    return this.b.e;
  }
  
  public String d()
  {
    return ShareChat.b(this.b.c, this.b.a);
  }
  
  public String e()
  {
    return ShareChat.a(this.b.a);
  }
  
  public TroopInfoData f()
  {
    return this.b.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.1
 * JD-Core Version:    0.7.0.1
 */