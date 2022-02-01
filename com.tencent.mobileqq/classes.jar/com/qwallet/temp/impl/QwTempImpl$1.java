package com.qwallet.temp.impl;

import com.tencent.av.ui.funchat.record.AudioFileDecoder.Callback;
import com.tencent.qphone.base.util.QLog;

class QwTempImpl$1
  implements AudioFileDecoder.Callback
{
  QwTempImpl$1(QwTempImpl paramQwTempImpl) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertMp3ToPcm onError ");
      localStringBuilder.append(paramInt);
      QLog.i("QwTempImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertMp3ToPcm onStart ");
      localStringBuilder.append(paramString);
      QLog.i("QwTempImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertMp3ToPcm onFinish ");
      localStringBuilder.append(paramString);
      QLog.i("QwTempImpl", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QwTempImpl.1
 * JD-Core Version:    0.7.0.1
 */