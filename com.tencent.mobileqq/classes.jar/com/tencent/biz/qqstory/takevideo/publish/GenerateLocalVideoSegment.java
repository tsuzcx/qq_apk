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
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class GenerateLocalVideoSegment
  extends MeasureJobSegment
{
  private final String a;
  public WeakReference a;
  
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
        ((GPUImagePixelationFilter)localObject).a();
        paramGenerateContext = localGPUBitmapImageRender.a(paramBitmap, (GPUBaseFilter)localObject);
        SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramGenerateContext);
        if (paramGenerateContext != null) {
          paramBitmap = paramGenerateContext;
        }
        ((GPUImagePixelationFilter)localObject).c();
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
    String str;
    if (((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label423;
      }
      str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
    }
    label423:
    for (;;)
    {
      long l2 = 0L;
      if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      paramJobContext = new MediaMetadataRetriever();
      try
      {
        paramJobContext.setDataSource((String)localObject);
        if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.a)
        {
          l1 = 0L;
          if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
            l1 = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          try
          {
            paramJobContext = paramJobContext.getFrameAtTime(l1 * 1000L);
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
              break label380;
            }
            boolean bool = BitmapUtils.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str);
            paramJobContext.recycle();
            if (!bool) {
              break;
            }
            paramJobContext = new File(str);
            if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
              break label365;
            }
            SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str);
            paramGenerateContext.jdField_a_of_type_JavaLangString = str;
            super.notifyResult(paramGenerateContext);
            return;
          }
          catch (OutOfMemoryError paramJobContext)
          {
            long l1;
            SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
          }
          localIllegalArgumentException = localIllegalArgumentException;
          SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + (String)localObject, localIllegalArgumentException);
          continue;
          localObject = paramJobContext.extractMetadata(9);
          if (localObject != null)
          {
            l1 = Long.valueOf((String)localObject).longValue();
            continue;
            for (;;)
            {
              for (;;)
              {
                paramJobContext = null;
                break;
                try
                {
                  paramJobContext = paramJobContext.getFrameAtTime(1000L * l2);
                }
                catch (OutOfMemoryError paramJobContext)
                {
                  SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", paramJobContext);
                }
              }
            }
          }
        }
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
      }
      for (;;)
      {
        label365:
        notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
        return;
        label380:
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
        continue;
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateLocalVideoSegment
 * JD-Core Version:    0.7.0.1
 */