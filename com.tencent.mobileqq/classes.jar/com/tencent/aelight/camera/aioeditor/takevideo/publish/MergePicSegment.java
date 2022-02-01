package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

public class MergePicSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  public final String a;
  private boolean b;
  private Bitmap c;
  
  public MergePicSegment(String paramString)
  {
    this(true, paramString);
  }
  
  public MergePicSegment(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    this(paramBoolean, paramString);
    this.c = paramBitmap;
  }
  
  public MergePicSegment(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public MergePicSegment(boolean paramBoolean, String paramString)
  {
    this.b = paramBoolean;
    this.a = paramString;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = UIUtils.b(BaseApplication.getContext());
    int j = UIUtils.e(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    return BitmapUtils.b(paramBitmap, 720, i, false, false);
  }
  
  private static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap2 == null) {
      return paramBitmap1;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
      localCanvas.drawBitmap(paramBitmap2, 20.0F, paramBitmap1.getHeight() - 20 - paramBitmap2.getHeight(), null);
      return localBitmap;
    }
    catch (Exception paramBitmap2)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
        return paramBitmap1;
      }
    }
    catch (OutOfMemoryError paramBitmap2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
      }
    }
    return paramBitmap1;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    Object localObject = this.a;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = PublishFileManager.a(paramGenerateContext.b, paramGenerateContext.p, ".jpg");
    }
    int j = ImageUtil.h(paramGenerateContext.l.a);
    boolean bool = this.b;
    int i = 0;
    if ((bool) && (paramGenerateContext.f))
    {
      SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
      try
      {
        Bitmap localBitmap1 = paramGenerateContext.l.c;
        Bitmap localBitmap3 = paramGenerateContext.l.d;
        localObject = localBitmap1;
        if (paramGenerateContext.b != 2)
        {
          localObject = localBitmap1;
          if (paramGenerateContext.b != 5)
          {
            localObject = localBitmap1;
            if (paramGenerateContext.b != 6)
            {
              float f1 = localBitmap1.getHeight() * 1.0F / localBitmap1.getWidth();
              float f2 = localBitmap3.getHeight() * 1.0F / localBitmap3.getWidth();
              if ((localBitmap1.getWidth() <= localBitmap1.getHeight()) || (localBitmap3.getWidth() >= localBitmap3.getHeight()))
              {
                localObject = localBitmap1;
                if (Math.abs(f1 - f2) <= 0.1D) {}
              }
              else
              {
                Bitmap localBitmap2 = a(localBitmap1);
                localObject = localBitmap1;
                if (localBitmap2 != null) {
                  localObject = localBitmap2;
                }
              }
            }
          }
        }
        localObject = a(BitmapUtils.c((Bitmap)localObject, localBitmap3), this.c);
        if (localObject != null) {
          bool = BitmapUtils.a((Bitmap)localObject, paramJobContext);
        }
      }
      catch (Throwable paramJobContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("merge err: ");
        ((StringBuilder)localObject).append(paramJobContext);
        ((StringBuilder)localObject).append(paramJobContext.getStackTrace());
        SLog.e("Q.qqstory.publish.edit.MergePicSegment", ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      for (;;)
      {
        paramJobContext = null;
        bool = false;
        break label493;
        if (paramGenerateContext.l.f <= 0) {
          break;
        }
        SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        localObject = a(paramGenerateContext.l.c, this.c);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          bool = BitmapUtils.a((Bitmap)localObject, paramJobContext);
          break label493;
        }
        if (localObject == null) {
          SLog.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
        } else if (((Bitmap)localObject).isRecycled()) {
          SLog.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
        }
      }
      if (paramGenerateContext.l.e)
      {
        bool = BitmapUtils.a(paramGenerateContext.l.c, paramJobContext);
      }
      else if ((j != 0) && (j % 90 == 0))
      {
        SLog.b("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
        bool = BitmapUtils.a(paramGenerateContext.l.c, paramJobContext);
      }
      else
      {
        SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramGenerateContext.l.a;
        VideoEditReport.b("0X80075C9");
        paramGenerateContext.l.h = true;
        bool = false;
        i = 1;
      }
    }
    label493:
    if ((i == 0) && (!bool))
    {
      SLog.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
      super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131904442)));
      return;
    }
    paramGenerateContext.l.b = paramJobContext;
    paramGenerateContext.l.g = bool;
    super.notifyResult(paramGenerateContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment
 * JD-Core Version:    0.7.0.1
 */