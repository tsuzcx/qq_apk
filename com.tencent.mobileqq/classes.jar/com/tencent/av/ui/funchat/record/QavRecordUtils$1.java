package com.tencent.av.ui.funchat.record;

import com.tencent.qphone.base.util.QLog;

final class QavRecordUtils$1
  implements AudioFileDecoder.Callback
{
  public void a(int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onError " + paramInt);
    QavRecordReporter.a(false, paramInt);
  }
  
  public void a(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onStart " + paramString);
  }
  
  public void b(String paramString)
  {
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm onFinish " + paramString);
    QavRecordReporter.a(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordUtils.1
 * JD-Core Version:    0.7.0.1
 */