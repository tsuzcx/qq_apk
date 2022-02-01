package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport;
import com.tencent.aelight.camera.aioeditor.takevideo.EditFilterExport;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class GenerateDynamicDoodleImageSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference<EditDoodleExport> a;
  public final WeakReference<EditFilterExport> b;
  
  public GenerateDynamicDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public GenerateDynamicDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
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
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject2 = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject3 = (EditFilterExport)this.b.get();
    Bitmap localBitmap;
    Object localObject1;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject3 != null) && (((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int, true);
      paramJobContext = this.jdField_a_of_type_JavaLangString;
      localObject1 = paramJobContext;
      if (paramJobContext == null) {
        localObject1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
      }
      if (localBitmap != null) {
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int)) {
          ((EditFilterExport)localObject3).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        try
        {
          ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
          m = ((BitmapFactory.Options)localObject3).outWidth;
          n = ((BitmapFactory.Options)localObject3).outHeight;
          if ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d()) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a() < paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b())) {
            break label692;
          }
          if (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14) {
            break label698;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          int m;
          int n;
          int k;
          int i;
          boolean bool;
          long l2;
          SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
          return;
        }
        k = m;
        i = n;
        if (m > n)
        {
          k = m;
          i = n;
          if (j != 0)
          {
            k = ((BitmapFactory.Options)localObject3).outHeight;
            i = ((BitmapFactory.Options)localObject3).outWidth;
          }
        }
        localObject2 = BitmapUtils.c(localBitmap, k, i, true, false);
        i = HWEncodeGenerateDoodleImageSegment.a(paramGenerateContext);
        if (i != 0)
        {
          paramJobContext = UIUtils.a((Bitmap)localObject2, i);
        }
        else
        {
          paramJobContext = (JobContext)localObject2;
          if (((BitmapFactory.Options)localObject3).outWidth > ((BitmapFactory.Options)localObject3).outHeight) {
            if (paramGenerateContext.jdField_a_of_type_Int != 12)
            {
              paramJobContext = (JobContext)localObject2;
              if (paramGenerateContext.jdField_a_of_type_Int != 11) {}
            }
            else
            {
              paramJobContext = UIUtils.a((Bitmap)localObject2, 270.0F);
            }
          }
        }
        if (paramJobContext != null) {
          bool = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject1);
        } else {
          bool = false;
        }
        localEditDoodleExport.a(localBitmap);
        if (paramJobContext != localBitmap) {
          BitmapUtils.a(paramJobContext);
        }
        if ((paramJobContext != null) && (bool))
        {
          SLog.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          paramJobContext = new StringBuilder();
          paramJobContext.append("");
          paramJobContext.append(l2 - l1);
          StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { paramJobContext.toString() });
          StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", localObject1);
          super.notifyResult(paramGenerateContext);
          return;
        }
        SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
        StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
      }
      finally
      {
        localEditDoodleExport.a(localBitmap);
      }
      SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(paramGenerateContext);
      return;
      label692:
      int j = 1;
      continue;
      label698:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateDynamicDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */