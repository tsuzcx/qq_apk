package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.avatar.IAvatar2DAIDataListener;

class VideoController$44
  implements IAvatar2DAIDataListener
{
  VideoController$44(VideoController paramVideoController) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a.b(paramArrayOfByte);
    if (VideoController.f(this.a))
    {
      if (this.a.k() != null) {
        paramArrayOfByte = this.a.k().s;
      } else {
        paramArrayOfByte = "";
      }
      this.a.b(paramArrayOfByte);
      VideoController.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.44
 * JD-Core Version:    0.7.0.1
 */