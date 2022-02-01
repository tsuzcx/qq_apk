package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport;
import com.tencent.aelight.camera.aioeditor.takevideo.EditFilterExport;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class GenerateDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport)
  {
    this(paramEditDoodleExport, null, 0);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
  {
    if (paramEditDoodleExport != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
      this.b = new WeakReference(paramEditFilterExport);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    throw new NullPointerException("doodleLayout should not be null");
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l1 = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        localObject = new Matrix();
        ((Matrix)localObject).reset();
        ((Matrix)localObject).postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateOrientation end, cost:");
        long l2 = System.currentTimeMillis();
        double d = l2 - l1;
        Double.isNaN(d);
        d /= 1000.0D;
        ((StringBuilder)localObject).append(d);
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", ((StringBuilder)localObject).toString());
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("rotate exception:");
          ((StringBuilder)localObject).append(paramBitmap);
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    EditFilterExport localEditFilterExport = (EditFilterExport)this.b.get();
    Object localObject1;
    Object localObject2;
    BitmapFactory.Options localOptions;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localEditFilterExport != null) && (localEditFilterExport.a(this.jdField_a_of_type_Int)))))
    {
      localObject1 = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (localObject1 != null)
      {
        localObject2 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");
        try
        {
          BitmapUtils.a((Bitmap)localObject1, (String)localObject2, null);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mosaicPath = ((String)localObject2);
          SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject2);
        }
        catch (IOException paramJobContext)
        {
          SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
    }
    for (;;)
    {
      try
      {
        ImageUtil.a(paramJobContext, localOptions);
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        paramJobContext = localEditDoodleExport.a().a();
        if (paramJobContext != null)
        {
          paramJobContext = paramJobContext.a(i, j, true);
          if (paramJobContext != null) {
            paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("dynamic_Sticker_data", paramJobContext);
          }
        }
        localObject2 = localEditDoodleExport.a(this.jdField_a_of_type_Int, false);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject1;
        if (localObject1 == null) {
          paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
        }
        if (localObject2 != null)
        {
          if (localEditFilterExport == null) {
            break label826;
          }
          try
          {
            if (!localEditFilterExport.a(this.jdField_a_of_type_Int)) {
              break label826;
            }
            localEditFilterExport.a(this.jdField_a_of_type_Int, new Canvas((Bitmap)localObject2), ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
            if ((!(paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)) || (!paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))) {
              break label829;
            }
            i = localOptions.outHeight;
            j = localOptions.outWidth;
            int k = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs.c;
            int m = paramGenerateContext.jdField_a_of_type_Int;
            if ((m != 2) && (m != 3) && (m != 5) && (m != 6)) {
              break label832;
            }
            if ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("resizedBitmap orientation=");
              ((StringBuilder)localObject1).append(0);
              SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", ((StringBuilder)localObject1).toString());
              k = 0;
            }
            localObject1 = a((Bitmap)localObject2, k);
            if (localObject1 == null) {
              break label832;
            }
            localObject1 = BitmapUtils.c((Bitmap)localObject1, i, j, true, false);
            boolean bool;
            if (localObject1 != null) {
              bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            } else {
              bool = false;
            }
            localEditDoodleExport.a((Bitmap)localObject2);
            if (localObject1 != localObject2) {
              BitmapUtils.a((Bitmap)localObject1);
            }
            if ((localObject1 != null) && (bool))
            {
              SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
              long l2 = SystemClock.uptimeMillis();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(l2 - l1);
              StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { ((StringBuilder)localObject1).toString() });
              StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
              paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = paramJobContext;
              super.notifyResult(paramGenerateContext);
              return;
            }
            SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
            StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
            paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
            super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
            return;
          }
          finally
          {
            localEditDoodleExport.a((Bitmap)localObject2);
          }
        }
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
        return;
      }
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramGenerateContext);
      return;
      label826:
      continue;
      label829:
      continue;
      label832:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */