package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class GeneratePicThumbSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private int a;
  public WeakReference<Activity> a;
  
  public GeneratePicThumbSegment(@NonNull Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      SLog.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (!paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.c)
    {
      paramJobContext = (JobContext)localObject;
      if (paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) {
        paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    boolean bool;
    if (this.jdField_a_of_type_Int == 5) {
      bool = true;
    } else {
      bool = false;
    }
    paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
    paramGenerateContext.jdField_a_of_type_JavaLangString = paramJobContext;
    super.notifyResult(paramGenerateContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicThumbSegment
 * JD-Core Version:    0.7.0.1
 */