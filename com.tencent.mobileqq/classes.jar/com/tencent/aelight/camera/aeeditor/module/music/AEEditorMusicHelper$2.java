package com.tencent.aelight.camera.aeeditor.module.music;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AEEditorMusicHelper$2
  implements Runnable
{
  AEEditorMusicHelper$2(TAVCutVideoSession paramTAVCutVideoSession, List paramList, long paramLong1, long paramLong2, long paramLong3, FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    long l3 = 0L;
    long l2;
    try
    {
      if (this.a == null) {
        return;
      }
      Object localObject2 = this.a.getMultiVideoFrame(this.b, (int)this.c);
      Object localObject1 = new ByteArrayOutputStream();
      localObject2 = ((List)localObject2).iterator();
      long l1 = 0L;
      for (;;)
      {
        l2 = l1;
        try
        {
          if (((Iterator)localObject2).hasNext())
          {
            l2 = l1;
            Object localObject3 = (Bitmap)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            l2 = l1;
            ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, (int)this.d, (OutputStream)localObject1);
            l2 = l1;
            localObject3 = ((ByteArrayOutputStream)localObject1).toByteArray();
            l2 = l1;
            l3 += localObject3.length;
            l2 = l1;
            if (l3 >= this.e)
            {
              l2 = l1;
              localObject1 = new StringBuilder();
              l2 = l1;
              ((StringBuilder)localObject1).append("[extractMultiCutFrameForSmartMusic] out of limit readBytes:");
              l2 = l1;
              ((StringBuilder)localObject1).append(l3);
              l2 = l1;
              ((StringBuilder)localObject1).append(", frameCount:");
              l2 = l1;
              ((StringBuilder)localObject1).append(localArrayList.size());
              l2 = l1;
              AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject1).toString());
            }
            else
            {
              l2 = l1;
              l1 += localObject3.length;
              l2 = l1;
              localArrayList.add(new FrameVideoHelper.FrameBuffer((byte[])localObject3));
              l2 = l1;
              ((ByteArrayOutputStream)localObject1).reset();
              continue;
            }
          }
          l2 = l1;
          if (this.f == null) {
            return;
          }
          l2 = l1;
          this.f.a(true, localArrayList, l1);
          return;
        }
        catch (Throwable localThrowable1) {}
      }
      AEQLog.a("AEEditorMusicHelper", "FrameVideoHelper.start(), error=", localThrowable2);
    }
    catch (Throwable localThrowable2)
    {
      l2 = 0L;
    }
    FrameVideoHelper.GetFrameByteArrayListener localGetFrameByteArrayListener = this.f;
    if (localGetFrameByteArrayListener != null) {
      localGetFrameByteArrayListener.a(false, localArrayList, l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.2
 * JD-Core Version:    0.7.0.1
 */