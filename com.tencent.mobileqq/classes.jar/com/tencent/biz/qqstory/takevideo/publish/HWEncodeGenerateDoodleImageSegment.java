package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditFilterExport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class HWEncodeGenerateDoodleImageSegment
  extends MeasureJobSegment
  implements KeepConstructor
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final WeakReference b;
  
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
    if (paramEditDoodleExport == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
    this.b = new WeakReference(paramEditFilterExport);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramGenerateContext.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      StoryReportor.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    EditFilterExport localEditFilterExport = (EditFilterExport)this.b.get();
    int i = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
    Object localObject;
    int j;
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localEditFilterExport != null) && (localEditFilterExport.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramGenerateContext.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramGenerateContext.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          j = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
          paramJobContext = UIUtils.a((Bitmap)localObject, 360 - j);
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + j);
        }
        localObject = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");
      }
    }
    label799:
    label941:
    label947:
    for (;;)
    {
      try
      {
        BitmapUtils.a(paramJobContext, (String)localObject, null);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        ImageUtil.a((String)localObject, "Orientation", String.valueOf(i));
        SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
        }
        if (localBitmap == null) {
          break label873;
        }
        if (localEditFilterExport != null) {}
        int k;
        int m;
        long l2;
        bool = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localEditFilterExport.a(this.jdField_a_of_type_Int)) {
            localEditFilterExport.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            ImageUtil.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = BitmapUtils.b(localBitmap, i, j, true, false);
            i = paramGenerateContext.c;
            if ((i == 0) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label947;
            }
            localObject = UIUtils.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label941;
            }
            if (paramGenerateContext.jdField_a_of_type_Int != 1) {
              break label799;
            }
            str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            BitmapUtils.a((Bitmap)localObject, str, null);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localEditDoodleExport.a(localBitmap);
          if (localObject != localBitmap) {
            BitmapUtils.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label827;
          }
          SLog.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          StoryReportor.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          StoryReportor.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramGenerateContext);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localEditDoodleExport.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label827:
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label873:
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramGenerateContext);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */