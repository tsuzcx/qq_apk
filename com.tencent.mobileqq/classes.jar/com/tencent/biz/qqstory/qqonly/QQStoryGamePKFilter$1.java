package com.tencent.biz.qqstory.qqonly;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;

class QQStoryGamePKFilter$1
  extends Handler
{
  QQStoryGamePKFilter$1(QQStoryGamePKFilter paramQQStoryGamePKFilter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle game filter msg, what = ");
    ((StringBuilder)localObject).append(paramMessage.what);
    SLog.i("QQStoryGamePKFilter", ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if ((QQStoryGamePKFilter.access$000(this.this$0) != null) && (QQStoryGamePKFilter.access$000(this.this$0).getCurrentState() == 1))
      {
        SLog.i("QQStoryGamePKFilter", "DecodePlayer is preparing");
        return;
      }
      localObject = (Object[])paramMessage.obj;
      QQStoryGamePKFilter.access$102(this.this$0, (String)localObject[0]);
      paramMessage = (String)localObject[1];
      boolean bool = ((Boolean)localObject[2]).booleanValue();
      localObject = (HWDecodeListener)localObject[5];
      if (QQStoryGamePKFilter.access$000(this.this$0) == null)
      {
        QQStoryGamePKFilter.access$002(this.this$0, new DecodePlayer());
        QQStoryGamePKFilter.access$202(this.this$0, GlUtil.createTexture(36197));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSurfaceCreate. rivalTextureId=");
        localStringBuilder.append(QQStoryGamePKFilter.access$200(this.this$0));
        Log.v("wyx", localStringBuilder.toString());
      }
      if (QQStoryGamePKFilter.access$300(this.this$0) != null) {
        QQStoryGamePKFilter.access$300(this.this$0).disable();
      }
      if (FileUtil.fileExistsAndNotEmpty(QQStoryGamePKFilter.access$100(this.this$0)))
      {
        QQStoryGamePKFilter.access$000(this.this$0).setFilePath(QQStoryGamePKFilter.access$100(this.this$0), paramMessage);
        QQStoryGamePKFilter.access$000(this.this$0).setRepeat(bool);
        QQStoryGamePKFilter.access$000(this.this$0).setDecodeListener((HWDecodeListener)localObject);
        paramMessage = this.this$0;
        QQStoryGamePKFilter.access$302(paramMessage, new QQStoryGamePKFilter.OnFrameAvailableListener(paramMessage));
        QQStoryGamePKFilter.access$000(this.this$0).startPlay(QQStoryGamePKFilter.access$200(this.this$0), QQStoryGamePKFilter.access$300(this.this$0));
        QQStoryGamePKFilter.access$402(this.this$0, null);
        QQStoryGamePKFilter.access$000(this.this$0).setSpeedType(0);
        return;
      }
      QQStoryGamePKFilter.access$500(this.this$0);
      QQStoryGamePKFilter.access$000(this.this$0).setFilePath("", "");
      return;
    }
    QQStoryGamePKFilter.access$500(this.this$0);
    if (QQStoryGamePKFilter.access$000(this.this$0) != null) {
      QQStoryGamePKFilter.access$000(this.this$0).setFilePath("", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.qqonly.QQStoryGamePKFilter.1
 * JD-Core Version:    0.7.0.1
 */