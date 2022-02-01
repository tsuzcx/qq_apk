package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
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
    GenerateThumbArgs localGenerateThumbArgs = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs;
    int i = localGenerateThumbArgs.c;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (EditVideoPlayerExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while (paramJobContext != null)
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
          i = new GenerateThumbTask(localBitmap, str1, localGenerateThumbArgs.jdField_a_of_type_Int, localGenerateThumbArgs.jdField_b_of_type_Int, i, localGenerateThumbArgs.jdField_a_of_type_Float, localGenerateThumbArgs.jdField_a_of_type_Double, localGenerateThumbArgs.jdField_b_of_type_Double, paramGenerateContext.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label217;
          }
          paramGenerateContext.jdField_a_of_type_JavaLangString = str1;
          paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(paramGenerateContext);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705703) + this.jdField_a_of_type_Int));
      }
      else
      {
        SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705708) + this.jdField_a_of_type_Int));
        return;
      }
    }
    SLog.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705704) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateThumbSegment
 * JD-Core Version:    0.7.0.1
 */