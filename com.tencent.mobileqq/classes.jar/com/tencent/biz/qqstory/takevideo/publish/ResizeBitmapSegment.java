package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

public class ResizeBitmapSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    System.currentTimeMillis();
    int i = UIUtils.a(BaseApplication.getContext());
    i = UIUtils.d(BaseApplication.getContext()) * 720 / i;
    if (i % 2 != 0) {
      i += 1;
    }
    for (;;)
    {
      Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (!paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean)
      {
        paramJobContext = (JobContext)localObject;
        if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean) {
          paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
        }
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      for (;;)
      {
        try
        {
          ImageUtil.a(paramJobContext, (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outWidth * 720 == ((BitmapFactory.Options)localObject).outHeight * i)
          {
            j = 1;
            if ((!(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && ((paramGenerateContext.jdField_a_of_type_Int != 1) || (j != 0)) && (((BitmapFactory.Options)localObject).outWidth <= 720) && (((BitmapFactory.Options)localObject).outHeight <= i) && (((BitmapFactory.Options)localObject).outWidth % 2 == 0) && (((BitmapFactory.Options)localObject).outHeight % 2 == 0)) {
              break label384;
            }
            paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_AndroidGraphicsBitmap;
            if (paramJobContext != null) {
              break;
            }
            SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
            return;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          SLog.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
          return;
        }
        int j = 0;
      }
      SLog.a("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(paramJobContext.getWidth()), Integer.valueOf(paramJobContext.getHeight()));
      localObject = BitmapUtils.b(paramJobContext, 720, i, false, false);
      if (localObject == null)
      {
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
        return;
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean = false;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean = true;
      String str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.jdField_b_of_type_JavaLangString, ".jpg");
      BitmapUtils.a((Bitmap)localObject, str);
      if (paramJobContext != localObject)
      {
        ((Bitmap)localObject).recycle();
        SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
      }
      for (;;)
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString = str;
        super.notifyResult(paramGenerateContext);
        return;
        SLog.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
      }
      label384:
      SLog.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(720), Integer.valueOf(i));
      super.notifyResult(paramGenerateContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.ResizeBitmapSegment
 * JD-Core Version:    0.7.0.1
 */