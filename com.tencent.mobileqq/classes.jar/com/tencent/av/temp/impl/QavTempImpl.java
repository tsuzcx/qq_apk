package com.tencent.av.temp.impl;

import com.tencent.av.so.ResMgr;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class QavTempImpl
  implements IQavTemp
{
  public String getAudio3ALicenseFilename()
  {
    return ResMgr.c();
  }
  
  public boolean isVideoChatting(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)paramAppRuntime).isVideoChatting();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.temp.impl.QavTempImpl
 * JD-Core Version:    0.7.0.1
 */