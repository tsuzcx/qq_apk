package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class GenerateEditPicDoodleSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  public final WeakReference<EditDoodleExport> a;
  public final String b;
  private boolean c;
  
  public GenerateEditPicDoodleSegment(EditDoodleExport paramEditDoodleExport, String paramString)
  {
    this.a = new WeakReference(paramEditDoodleExport);
    this.b = paramString;
    this.c = false;
  }
  
  private Bitmap a(GenerateContext paramGenerateContext, Bitmap paramBitmap)
  {
    try
    {
      paramGenerateContext = paramGenerateContext.a();
      SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", paramGenerateContext);
      if (paramGenerateContext == null)
      {
        SLog.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = paramGenerateContext.getWidth();
      float f4 = paramGenerateContext.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      paramGenerateContext.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramGenerateContext)
    {
      SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", paramGenerateContext);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = this.b;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = PublishFileManager.a(paramGenerateContext.b, paramGenerateContext.p, ".png");
    }
    localObject = (EditDoodleExport)this.a.get();
    if ((localObject != null) && (!((EditDoodleExport)localObject).h()))
    {
      localObject = ((EditDoodleExport)localObject).i();
      if (localObject != null)
      {
        paramGenerateContext.l.d = ((Bitmap)localObject);
        paramGenerateContext.f = true;
        Bitmap localBitmap = a(paramGenerateContext, (Bitmap)localObject);
        if (localBitmap != null)
        {
          SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
        else
        {
          SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
        }
        if (this.c)
        {
          boolean bool = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          paramGenerateContext.f = bool;
          paramGenerateContext.d.doodlePath = paramJobContext;
          if (!bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Save doodle bitmap to ");
            ((StringBuilder)localObject).append(paramJobContext);
            ((StringBuilder)localObject).append(" failed! error code = ");
            ((StringBuilder)localObject).append(bool);
            SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    paramJobContext = new StringBuilder();
    paramJobContext.append("GenerateEditPicDoodleSegment");
    paramJobContext.append(paramGenerateContext.f);
    paramJobContext.append(" cost ");
    paramJobContext.append(SystemClock.uptimeMillis() - l);
    SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", paramJobContext.toString());
    super.notifyResult(paramGenerateContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateEditPicDoodleSegment
 * JD-Core Version:    0.7.0.1
 */