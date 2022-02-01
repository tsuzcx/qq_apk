package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class MergeThumbSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private final String a;
  
  public MergeThumbSegment()
  {
    this(null);
  }
  
  public MergeThumbSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    Object localObject1 = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    Object localObject5 = paramJobContext;
    if (paramJobContext == null) {
      localObject5 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
    }
    Object localObject8 = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodleRawPath;
    Object localObject7 = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.doodlePath;
    paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_image_path", null);
    String str = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getStringExtra("pl_pic", null);
    int i = 1;
    Object localObject4;
    if ((localObject8 == null) && (localObject7 == null) && (paramJobContext == null))
    {
      SLog.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject5);
      if (FileUtils.a(new File((String)localObject1), new File((String)localObject5)))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath = ((String)localObject5);
        break label722;
      }
      SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject1, localObject5 });
    }
    else
    {
      try
      {
        Object localObject6 = BitmapFactory.decodeFile((String)localObject1);
        if (localObject6 == null)
        {
          super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131706592)));
          return;
        }
        if (paramJobContext != null) {
          try
          {
            localObject1 = BitmapUtils.a(paramJobContext);
          }
          catch (OutOfMemoryError paramJobContext)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("decode ");
            ((StringBuilder)localObject1).append((String)localObject7);
            ((StringBuilder)localObject1).append(" failed");
            SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", ((StringBuilder)localObject1).toString(), paramJobContext);
          }
        } else {
          localObject1 = null;
        }
        paramJobContext = (JobContext)localObject1;
        if (localObject1 != null)
        {
          paramJobContext = (JobContext)localObject1;
          if (localObject8 != null)
          {
            paramJobContext = (JobContext)localObject1;
            try
            {
              localObject1 = BitmapUtils.a((String)localObject8, null);
              paramJobContext = (JobContext)localObject1;
              SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { localObject8 });
              paramJobContext = (JobContext)localObject1;
            }
            catch (IOException localIOException)
            {
              SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
            }
          }
        }
        Object localObject2 = paramJobContext;
        Object localObject3;
        if (paramJobContext == null)
        {
          localObject2 = paramJobContext;
          if (localObject7 != null) {
            try
            {
              localObject2 = BitmapUtils.a((String)localObject7);
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              localObject8 = new StringBuilder();
              ((StringBuilder)localObject8).append("decode ");
              ((StringBuilder)localObject8).append((String)localObject7);
              ((StringBuilder)localObject8).append(" failed");
              SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", ((StringBuilder)localObject8).toString(), localOutOfMemoryError1);
              localObject3 = paramJobContext;
            }
          }
        }
        if ((localObject3 != null) && ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)) && (paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false)))
        {
          paramJobContext = GenerateDoodleImageSegment.a((Bitmap)localObject3, -90);
          if (paramJobContext != null)
          {
            localObject3 = paramJobContext;
            paramJobContext = (JobContext)localObject6;
            if (localObject3 != null)
            {
              paramJobContext = BitmapUtils.b((Bitmap)localObject6, (Bitmap)localObject3);
              ((Bitmap)localObject3).recycle();
              ((Bitmap)localObject6).recycle();
            }
            localObject3 = paramJobContext;
            if (paramJobContext == null) {
              break label781;
            }
            localObject3 = paramJobContext;
            if (str == null) {
              break label781;
            }
            try
            {
              localObject7 = BitmapFactory.decodeFile(str);
              localObject3 = paramJobContext;
              if (localObject7 == null) {
                break label781;
              }
              localObject6 = BitmapUtils.b(paramJobContext, (Bitmap)localObject7);
              localObject3 = paramJobContext;
              if (localObject6 == null) {
                break label781;
              }
              paramJobContext.recycle();
              ((Bitmap)localObject7).recycle();
              localObject3 = localObject6;
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("decode ");
              ((StringBuilder)localObject6).append(str);
              ((StringBuilder)localObject6).append(" failed");
              SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", ((StringBuilder)localObject6).toString(), localOutOfMemoryError2);
              localObject4 = paramJobContext;
            }
            label601:
            FileUtils.a(QQStoryConstant.f);
            boolean bool = BitmapUtils.a((Bitmap)localObject4, (String)localObject5);
            if (localObject4 != null) {
              ((Bitmap)localObject4).recycle();
            }
            if (bool)
            {
              paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath = ((String)localObject5);
              paramJobContext = new StringBuilder();
              paramJobContext.append("merge doodle and thumb image success : ");
              paramJobContext.append((String)localObject5);
              SLog.b("Q.qqstory.publish.edit.MergeThumbSegment", paramJobContext.toString());
            }
            else
            {
              SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
            }
          }
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("merge doodle and thumb image failed : ");
        ((StringBuilder)localObject4).append(paramJobContext);
        SLog.e("Q.qqstory.publish.edit.MergeThumbSegment", ((StringBuilder)localObject4).toString());
      }
    }
    for (;;)
    {
      i = 0;
      label722:
      if (i != 0)
      {
        FileUtils.a(new File(paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
        super.notifyResult(paramGenerateContext);
        return;
      }
      super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131706593)));
      return;
      break;
      label781:
      if (localObject4 != null) {
        break label601;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.MergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */