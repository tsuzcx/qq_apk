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
  public WeakReference<Activity> a;
  private int b;
  
  public GeneratePicThumbSegment(@NonNull Activity paramActivity, int paramInt)
  {
    this.a = new WeakReference(paramActivity);
    this.b = paramInt;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity == null)
    {
      SLog.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
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
    BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    boolean bool;
    if (this.b == 5) {
      bool = true;
    } else {
      bool = false;
    }
    paramGenerateContext.i = new GenerateThumbArgs(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
    paramGenerateContext.j = paramJobContext;
    super.notifyResult(paramGenerateContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicThumbSegment
 * JD-Core Version:    0.7.0.1
 */