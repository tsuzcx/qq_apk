package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

public class MakeStoryPicSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    int i = UIUtils.b(BaseApplication.getContext());
    int j = UIUtils.c(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.a;
    paramJobContext = (JobContext)localObject;
    if (!paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.c)
    {
      paramJobContext = (JobContext)localObject;
      if (paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) {
        paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      }
    }
    try
    {
      localObject = ImageUtil.a(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        SLog.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
      if ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e == ((Bitmap)localObject).getHeight()) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d == ((Bitmap)localObject).getWidth())) {
        j = 0;
      } else {
        j = 1;
      }
      if (((Bitmap)localObject).getWidth() <= 720)
      {
        paramJobContext = (JobContext)localObject;
        if (((Bitmap)localObject).getHeight() <= i) {}
      }
      else
      {
        float f = Math.min(720 / ((Bitmap)localObject).getWidth(), i / ((Bitmap)localObject).getHeight());
        localObject = BitmapUtils.a((Bitmap)localObject, f, true);
        SLog.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
        paramJobContext = (JobContext)localObject;
        if (localObject == null)
        {
          notifyError(new BitmapError("resizeBitmapByScale failed", -1));
          return;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current bitmap size ");
      ((StringBuilder)localObject).append(paramJobContext.getWidth());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramJobContext.getHeight());
      ((StringBuilder)localObject).append("destWidth: ");
      ((StringBuilder)localObject).append(720);
      ((StringBuilder)localObject).append(" destHeight: ");
      ((StringBuilder)localObject).append(i);
      SLog.b("Q.qqstory.publish.edit.MakeStoryPicSegment", ((StringBuilder)localObject).toString());
      localObject = paramJobContext;
      if (j != 0) {
        localObject = BitmapUtils.c(paramJobContext, 720, i, false, true);
      }
      if (localObject == null)
      {
        notifyError(new BitmapError("fillBitmapEdge failed", -1));
        return;
      }
      if (((Bitmap)localObject).getHeight() % 2 == 0)
      {
        paramJobContext = (JobContext)localObject;
        if (((Bitmap)localObject).getWidth() % 2 == 0) {}
      }
      else
      {
        paramJobContext = Bitmap.createScaledBitmap((Bitmap)localObject, ((Bitmap)localObject).getWidth() >> 1 << 1, ((Bitmap)localObject).getHeight() >> 1 << 1, false);
      }
      localObject = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.jdField_b_of_type_JavaLangString, ".jpg");
      BitmapUtils.a(paramJobContext, (String)localObject);
      paramJobContext.recycle();
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath = ((String)localObject);
      super.notifyResult(paramGenerateContext);
      return;
    }
    catch (OutOfMemoryError paramJobContext)
    {
      SLog.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.MakeStoryPicSegment
 * JD-Core Version:    0.7.0.1
 */