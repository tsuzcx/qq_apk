package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

public class ResizeBitmapSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    System.currentTimeMillis();
    int i = UIUtils.b(BaseApplication.getContext());
    int j = UIUtils.e(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = paramGenerateContext.l.a;
    paramJobContext = (JobContext)localObject;
    if (!paramGenerateContext.l.h)
    {
      paramJobContext = (JobContext)localObject;
      if (paramGenerateContext.l.g) {
        paramJobContext = paramGenerateContext.l.b;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    try
    {
      ImageUtil.a(paramJobContext, (BitmapFactory.Options)localObject);
      if ((!(paramGenerateContext.c instanceof EditLocalPhotoSource)) && (((BitmapFactory.Options)localObject).outWidth <= 720) && (((BitmapFactory.Options)localObject).outHeight <= i) && (((BitmapFactory.Options)localObject).outWidth % 2 == 0) && (((BitmapFactory.Options)localObject).outHeight % 2 == 0))
      {
        SLog.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(720), Integer.valueOf(i));
        super.notifyResult(paramGenerateContext);
        return;
      }
      paramJobContext = paramGenerateContext.l.c;
      if (paramJobContext == null)
      {
        SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
        return;
      }
      SLog.a("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(paramJobContext.getWidth()), Integer.valueOf(paramJobContext.getHeight()));
      localObject = BitmapUtils.b(paramJobContext, 720, i, false, false);
      if (localObject == null)
      {
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
        return;
      }
      paramGenerateContext.l.h = false;
      paramGenerateContext.l.g = true;
      String str = PublishFileManager.a(paramGenerateContext.b, paramGenerateContext.p, ".jpg");
      BitmapUtils.a((Bitmap)localObject, str);
      if (paramJobContext != localObject)
      {
        ((Bitmap)localObject).recycle();
        SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
      }
      else
      {
        SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
      }
      paramGenerateContext.l.b = str;
      super.notifyResult(paramGenerateContext);
      return;
    }
    catch (OutOfMemoryError paramJobContext)
    {
      SLog.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.ResizeBitmapSegment
 * JD-Core Version:    0.7.0.1
 */