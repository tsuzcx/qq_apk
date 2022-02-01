package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateThumbSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<EditVideoPlayerExport> jdField_a_of_type_JavaLangRefWeakReference;
  
  public HWEncodeGenerateThumbSegment(String paramString, EditVideoPlayerExport paramEditVideoPlayerExport, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditVideoPlayerExport);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    SLog.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    GenerateThumbArgs localGenerateThumbArgs = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs;
    int i = localGenerateThumbArgs.c;
    paramJobContext = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramJobContext != null) {
      paramJobContext = (EditVideoPlayerExport)paramJobContext.get();
    } else {
      paramJobContext = null;
    }
    if (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.a(this.jdField_a_of_type_Int);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (str2 == null) {
            str1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
          }
          int j = localGenerateThumbArgs.jdField_a_of_type_Int;
          int k = localGenerateThumbArgs.jdField_b_of_type_Int;
          float f = localGenerateThumbArgs.jdField_a_of_type_Float;
          double d1 = localGenerateThumbArgs.jdField_a_of_type_Double;
          double d2 = localGenerateThumbArgs.jdField_b_of_type_Double;
          int m = paramGenerateContext.jdField_a_of_type_Int;
          try
          {
            i = new GenerateThumbTask(localBitmap, str1, j, k, i, f, d1, d2, m).a(new Void[0]).intValue();
            paramJobContext.a(localBitmap);
            if (i == 0)
            {
              paramGenerateContext.jdField_a_of_type_JavaLangString = str1;
              paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath = str1;
              SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
              super.notifyResult(paramGenerateContext);
              return;
            }
            SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
            paramJobContext = new StringBuilder();
            paramJobContext.append(HardCodeUtil.a(2131705770));
            paramJobContext.append(this.jdField_a_of_type_Int);
            super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
            return;
          }
          finally {}
          paramJobContext.a(localBitmap);
        }
        finally {}
        throw paramGenerateContext;
      }
      SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      paramJobContext = new StringBuilder();
      paramJobContext.append(HardCodeUtil.a(2131705771));
      paramJobContext.append(this.jdField_a_of_type_Int);
      super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
      return;
    }
    SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    paramJobContext = new StringBuilder();
    paramJobContext.append(HardCodeUtil.a(2131705767));
    paramJobContext.append(this.jdField_a_of_type_Int);
    super.notifyError(new ErrorMessage(-1, paramJobContext.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeGenerateThumbSegment
 * JD-Core Version:    0.7.0.1
 */