package com.tencent.av;

import com.tencent.avcore.util.AVCoreLog;

public class AVLog
  extends AVCoreLog
{
  static
  {
    if (!isInit()) {
      init(new AVLogImpl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVLog
 * JD-Core Version:    0.7.0.1
 */