package com.tencent.av.utils;

import com.tencent.mobileqq.app.QQAppInterface;

final class VideoMsgTools$1
  implements Runnable
{
  VideoMsgTools$1(int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    int j = this.a;
    if ((j != 9) && (j != 62) && (j != 63))
    {
      VideoMsgTools.a(this.b, this.c, j, this.e, this.g, this.f, this.h, this.i);
      return;
    }
    VideoMsgTools.a(this.b, this.c, this.a, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.1
 * JD-Core Version:    0.7.0.1
 */