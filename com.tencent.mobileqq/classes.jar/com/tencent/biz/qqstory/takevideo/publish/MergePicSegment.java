package com.tencent.biz.qqstory.takevideo.publish;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import cooperation.qzone.util.GpsComplementUtil;

public class MergePicSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  public final String a;
  private boolean a;
  
  public MergePicSegment(String paramString)
  {
    this(true, paramString);
  }
  
  public MergePicSegment(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public MergePicSegment(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(GenerateContext paramGenerateContext, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!GpsComplementUtil.complementByExif(paramString1, paramString2)) {
          GpsComplementUtil.complementByLocal(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        GpsComplementUtil.complementByLocal(paramString2, d2, d1);
        return;
      } while ((!(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (GpsComplementUtil.complementByExif(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramGenerateContext = ((EditLocalPhotoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramGenerateContext == null);
    GpsComplementUtil.complementByDB(paramString2, paramGenerateContext.longitude / 1000000.0D, paramGenerateContext.latitude / 1000000.0D);
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramGenerateContext.jdField_a_of_type_Boolean)) {
      SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = BitmapUtils.a(BitmapUtils.c(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_AndroidGraphicsBitmap, paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        SLog.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131706565)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        SLog.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Int > 0)
      {
        SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = BitmapUtils.a(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            SLog.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        SLog.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString;
        VideoEditReport.b("0X80075C9");
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString = paramJobContext;
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean = bool1;
    if ((paramGenerateContext.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramGenerateContext, paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramGenerateContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.MergePicSegment
 * JD-Core Version:    0.7.0.1
 */