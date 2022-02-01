package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport)
  {
    this(paramEditDoodleExport, null, 0);
  }
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public HWEncodeGenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
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
  
  public static int a(GenerateContext paramGenerateContext)
  {
    int i = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs.c;
    if ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      if ((!paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("local_import", false)) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))) {
        return 270;
      }
      return 0;
    }
    return i;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject1 = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramJobContext = (EditFilterExport)this.b.get();
    Bitmap localBitmap1;
    Object localObject2;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((paramJobContext != null) && (paramJobContext.a(this.jdField_a_of_type_Int)))))
    {
      localBitmap1 = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (localBitmap1 != null)
      {
        localObject2 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");
        try
        {
          BitmapUtils.a(localBitmap1, (String)localObject2, null);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mosaicPath = ((String)localObject2);
          SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject2);
        }
        catch (UnsupportedOperationException paramJobContext)
        {
          SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "updateExif failed."));
          return;
        }
        catch (IOException paramJobContext)
        {
          SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    }
    label890:
    for (;;)
    {
      try
      {
        ImageUtil.a((String)localObject1, (BitmapFactory.Options)localObject2);
        k = ((BitmapFactory.Options)localObject2).outWidth;
        m = ((BitmapFactory.Options)localObject2).outHeight;
        if (((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d()) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a() < paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b())) || (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 14)) {
          bool = true;
        } else {
          bool = false;
        }
        localObject1 = localEditDoodleExport.a().a();
        if (localObject1 != null)
        {
          localObject1 = ((DynamicFaceLayer)localObject1).a(k, m, bool);
          if (localObject1 != null) {
            paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("dynamic_Sticker_data", localObject1);
          }
        }
        localBitmap2 = localEditDoodleExport.a(this.jdField_a_of_type_Int, false);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        if (localObject1 == null) {
          localObject1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
        }
        if (localBitmap2 != null) {
          if (paramJobContext == null) {
            break label890;
          }
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        int k;
        int m;
        boolean bool;
        Bitmap localBitmap2;
        int j;
        int i;
        SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
        return;
      }
      try
      {
        if (!paramJobContext.a(this.jdField_a_of_type_Int)) {
          break label890;
        }
        paramJobContext.a(this.jdField_a_of_type_Int, new Canvas(localBitmap2), localBitmap2.getWidth(), localBitmap2.getHeight());
        j = k;
        i = m;
        if (k > m)
        {
          j = k;
          i = m;
          if (bool)
          {
            j = ((BitmapFactory.Options)localObject2).outHeight;
            i = ((BitmapFactory.Options)localObject2).outWidth;
          }
        }
        localBitmap1 = BitmapUtils.c(localBitmap2, j, i, true, false);
        i = a(paramGenerateContext);
        if (i != 0)
        {
          paramJobContext = UIUtils.a(localBitmap1, i);
        }
        else
        {
          paramJobContext = localBitmap1;
          if (((BitmapFactory.Options)localObject2).outWidth > ((BitmapFactory.Options)localObject2).outHeight) {
            if (paramGenerateContext.jdField_a_of_type_Int != 12)
            {
              paramJobContext = localBitmap1;
              if (paramGenerateContext.jdField_a_of_type_Int != 11) {}
            }
            else
            {
              paramJobContext = UIUtils.a(localBitmap1, 270.0F);
            }
          }
        }
        if (paramJobContext != null)
        {
          bool = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject1);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodleRawPath = ((String)localObject1);
        }
        else
        {
          bool = false;
        }
        localEditDoodleExport.a(localBitmap2);
        if (paramJobContext != localBitmap2) {
          BitmapUtils.a(paramJobContext);
        }
        if ((paramJobContext != null) && (bool))
        {
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          long l2 = SystemClock.uptimeMillis();
          paramJobContext = new StringBuilder();
          paramJobContext.append("");
          paramJobContext.append(l2 - l1);
          StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { paramJobContext.toString() });
          StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = ((String)localObject1);
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
        continue;
      }
      localEditDoodleExport.a(localBitmap2);
      throw paramJobContext;
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramGenerateContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeGenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */