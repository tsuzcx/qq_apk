package com.tencent.biz.qqstory.takevideo.publish;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class GenerateLocalVideoSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private final String a;
  public WeakReference<EditDoodleExport> a;
  
  public GenerateLocalVideoSegment()
  {
    this(null);
  }
  
  public GenerateLocalVideoSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(GenerateContext paramGenerateContext, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    GPUBitmapImageRender localGPUBitmapImageRender = new GPUBitmapImageRender();
    localGPUBitmapImageRender.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramGenerateContext = (GenerateContext)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramGenerateContext = (GenerateContext)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramGenerateContext = ((EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramGenerateContext != null)
      {
        localObject = (GPUImagePixelationFilter)FilterFactory.a(106);
        ((GPUImagePixelationFilter)localObject).a(paramGenerateContext);
        ((GPUImagePixelationFilter)localObject).init();
        paramGenerateContext = localGPUBitmapImageRender.a(paramBitmap, (GPUBaseFilter)localObject);
        SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramGenerateContext);
        if (paramGenerateContext != null) {
          paramBitmap = paramGenerateContext;
        }
        ((GPUImagePixelationFilter)localObject).destroy();
        localObject = paramBitmap;
      }
      localGPUBitmapImageRender.a();
      return localObject;
    }
    catch (Exception paramGenerateContext)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramGenerateContext.toString());
        paramGenerateContext = (GenerateContext)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    String str1;
    if (((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.jdField_a_of_type_JavaLangString;
      if (str1 != null) {
        break label481;
      }
      str1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
    }
    label407:
    label414:
    label429:
    label473:
    label478:
    label481:
    for (;;)
    {
      long l2 = 0L;
      if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      String str2 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.a) {
            continue;
          }
          l1 = 0L;
          if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
          if (localMediaMetadataRetriever == null) {
            break label473;
          }
          localMediaMetadataRetriever.release();
          paramJobContext = null;
          continue;
        }
        finally
        {
          if (localMediaMetadataRetriever == null) {
            continue;
          }
          localMediaMetadataRetriever.release();
        }
        try
        {
          paramJobContext = localMediaMetadataRetriever.getFrameAtTime(l1 * 1000L);
          if (localMediaMetadataRetriever == null) {
            break label478;
          }
          localMediaMetadataRetriever.release();
          localObject = paramJobContext;
          if (paramJobContext != null)
          {
            localObject = paramJobContext;
            if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate) {
              localObject = UIUtils.a(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = a(paramGenerateContext, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label429;
          }
          bool = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramGenerateContext.jdField_a_of_type_JavaLangString = str1;
          super.notifyResult(paramGenerateContext);
          return;
          paramJobContext = localMediaMetadataRetriever.extractMetadata(9);
          if (paramJobContext == null) {
            continue;
          }
          l1 = Long.valueOf(paramJobContext).longValue();
          continue;
        }
        catch (OutOfMemoryError paramJobContext)
        {
          SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
          paramJobContext = null;
          continue;
        }
        try
        {
          localObject = localMediaMetadataRetriever.getFrameAtTime(1000L * l2);
          paramJobContext = (JobContext)localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateLocalVideoSegment
 * JD-Core Version:    0.7.0.1
 */