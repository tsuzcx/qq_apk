package com.tencent.av.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import java.lang.ref.WeakReference;

class VideoMsgTools$MygetGroupInfoRunnable
  implements Runnable
{
  long a = 0L;
  WeakReference<QQAppInterface> b = null;
  String c = null;
  
  public VideoMsgTools$MygetGroupInfoRunnable(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.a = paramLong;
    this.b = new WeakReference(paramQQAppInterface);
    this.c = paramString;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGroupMember_");
      localStringBuilder.append(this.a);
      QAVGroupConfig.b(localStringBuilder.toString(), localQQAppInterface, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.MygetGroupInfoRunnable
 * JD-Core Version:    0.7.0.1
 */