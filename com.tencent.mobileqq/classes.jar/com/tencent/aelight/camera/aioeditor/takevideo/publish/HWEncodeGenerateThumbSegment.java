package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateThumbSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private String a;
  private final WeakReference<EditVideoPlayerExport> b;
  private final int c;
  
  public HWEncodeGenerateThumbSegment(String paramString, EditVideoPlayerExport paramEditVideoPlayerExport, int paramInt)
  {
    this.a = paramString;
    this.b = new WeakReference(paramEditVideoPlayerExport);
    this.c = paramInt;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    SLog.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.c));
    GenerateThumbArgs localGenerateThumbArgs = paramGenerateContext.i;
    int i = localGenerateThumbArgs.g;
    paramJobContext = this.b;
    if (paramJobContext != null) {
      paramJobContext = (EditVideoPlayerExport)paramJobContext.get();
    } else {
      paramJobContext = null;
    }
    if (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.a(this.c);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.a;
          String str1 = str2;
          if (str2 == null) {
            str1 = PublishFileManager.a(paramGenerateContext.b, paramGenerateContext.p, ".jpg");
          }
          int j = localGenerateThumbArgs.b;
          int k = localGenerateThumbArgs.c;
          float f = localGenerateThumbArgs.e;
          double d1 = localGenerateThumbArgs.h;
          double d2 = localGenerateThumbArgs.i;
          int m = paramGenerateContext.b;
          try
          {
            i = new GenerateThumbTask(localBitmap, str1, j, k, i, f, d1, d2, m).a(new Void[0]).intValue();
            paramJobContext.a(localBitmap);
            if (i == 0)
            {
              paramGenerateContext.j = str1;
              paramGenerateContext.d.thumbPath = str1;
              SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.c) });
              super.notifyResult(paramGenerateContext);
              return;
            }
            SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.c) });
            paramJobContext = new StringBuilder();
            paramJobContext.append(HardCodeUtil.a(2131903655));
            paramJobContext.append(this.c);
            super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
            return;
          }
          finally {}
          paramJobContext.a(localBitmap);
        }
        finally {}
        throw paramGenerateContext;
      }
      SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.c) });
      paramJobContext = new StringBuilder();
      paramJobContext.append(HardCodeUtil.a(2131903656));
      paramJobContext.append(this.c);
      super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
      return;
    }
    SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.c) });
    paramJobContext = new StringBuilder();
    paramJobContext.append(HardCodeUtil.a(2131903652));
    paramJobContext.append(this.c);
    super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeGenerateThumbSegment
 * JD-Core Version:    0.7.0.1
 */