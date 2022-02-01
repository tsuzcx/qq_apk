package com.tencent.aelight.camera.aeeditor.module.music;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import java.util.ArrayList;

final class AEEditorMusicHelper$1
  implements FrameVideoHelper.GetFrameByteArrayListener
{
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[extractFrameForSmartMusic], onResult(), isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", dataArray=");
    localStringBuilder.append(paramArrayList);
    localStringBuilder.append(", frameSize=");
    localStringBuilder.append(paramLong);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[extractFrameForSmartMusic], executeTime=");
      localStringBuilder.append(this.a.b());
      localStringBuilder.append(", frameCount=");
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(", size=");
      localStringBuilder.append(this.a.c());
      localStringBuilder.append("KB");
      AEQLog.a("AEEditorMusicHelper", localStringBuilder.toString());
    }
    if (this.b != null)
    {
      if (paramArrayList == null) {
        paramArrayList = null;
      } else {
        paramArrayList = new ArrayList(paramArrayList);
      }
      this.b.a(paramBoolean, paramArrayList, paramLong);
    }
    paramArrayList = this.a;
    if (paramArrayList != null) {
      paramArrayList.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.1
 * JD-Core Version:    0.7.0.1
 */