package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class MergeThumbSegment
  extends MeasureJobSegment
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
    paramJobContext = null;
    int i = 0;
    Object localObject3 = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
    }
    String str2 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str2 != null) || (str1 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label181;
        }
        super.notifyError(new ErrorMessage(-1, "图片合成失败"));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        SLog.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label463;
      }
      FileUtils.a(new File(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(paramGenerateContext);
      return;
      label181:
      if (str2 == null) {
        break label478;
      }
      try
      {
        localObject2 = BitmapUtils.a(str2, null);
        paramJobContext = (JobContext)localObject2;
        SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str2 });
        paramJobContext = (JobContext)localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            label216:
            localObject2 = BitmapFactory.decodeFile(str1);
            paramJobContext = (JobContext)localObject2;
            if (paramJobContext == null) {
              break label495;
            }
            localObject2 = BitmapUtils.a((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError);
            break label492;
          }
          localIOException = localIOException;
          SLog.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
        }
      }
      if ((paramJobContext != null) || (str1 == null)) {
        break label492;
      }
    }
    label235:
    label492:
    label495:
    label499:
    for (;;)
    {
      FileUtils.a(QQStoryConstant.c);
      boolean bool = BitmapUtils.a(paramJobContext, (String)localObject1);
      if (paramJobContext != null) {
        paramJobContext.recycle();
      }
      if (bool)
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
        SLog.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject1);
        i = 1;
      }
      else
      {
        SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
        i = 0;
        break label489;
        SLog.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject1);
        if (FileUtils.a(new File((String)localObject3), new File((String)localObject1)))
        {
          paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
          i = 1;
          break;
        }
        SLog.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject1 });
        break;
        super.notifyError(new ErrorMessage(-1, "图片合成失败"));
        return;
        paramJobContext = null;
        break label216;
      }
      for (;;)
      {
        if (paramJobContext != null) {
          break label499;
        }
        i = 0;
        break;
        break label235;
        paramJobContext = (JobContext)localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.MergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */