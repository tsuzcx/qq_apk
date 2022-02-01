package com.tencent.avgame.qav;

import com.tencent.qav.channel.VideoChannelSupportCallback;
import com.tencent.qav.log.AVLog;

class AVGameBusinessCtrl$3
  implements VideoChannelSupportCallback
{
  AVGameBusinessCtrl$3(AVGameBusinessCtrl paramAVGameBusinessCtrl) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    int i = paramInt - 32;
    if ((i == 2) || (i == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      AVLog.c("AVGameBusinessCtrl", String.format("isMultiVideoMsgSupport type=0x%X support=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl.3
 * JD-Core Version:    0.7.0.1
 */