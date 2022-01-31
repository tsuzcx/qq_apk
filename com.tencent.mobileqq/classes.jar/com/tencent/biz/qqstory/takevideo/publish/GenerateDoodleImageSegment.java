package com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditFilterExport;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class GenerateDoodleImageSegment
  extends MeasureJobSegment
{
  public final int a;
  public final String a;
  public final WeakReference a;
  public final WeakReference b;
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport)
  {
    this(paramEditDoodleExport, null, 0);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, int paramInt)
  {
    this(paramEditDoodleExport, paramEditFilterExport, null, paramInt);
  }
  
  public GenerateDoodleImageSegment(EditDoodleExport paramEditDoodleExport, EditFilterExport paramEditFilterExport, String paramString, int paramInt)
  {
    if (paramEditDoodleExport == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditDoodleExport);
    this.b = new WeakReference(paramEditFilterExport);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
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
    Object localObject2 = (EditFilterExport)this.b.get();
    if ((localEditDoodleExport != null) && ((!localEditDoodleExport.a(this.jdField_a_of_type_Int)) || ((localObject2 != null) && (((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int)))))
    {
      paramJobContext = localEditDoodleExport.a().a(this.jdField_a_of_type_Int);
      if (paramJobContext == null) {}
    }
    Bitmap localBitmap;
    for (Object localObject1 = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, "mosaic.png");; localObject1 = localBitmap) {
      for (;;)
      {
        try
        {
          BitmapUtils.a(paramJobContext, (String)localObject1, null);
          paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject1);
          SLog.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject1);
          localBitmap = localEditDoodleExport.a(this.jdField_a_of_type_Int);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          paramJobContext = (JobContext)localObject1;
          if (localObject1 == null) {
            paramJobContext = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".png");
          }
          if (localBitmap == null) {
            break label696;
          }
          if (localObject2 != null) {}
          int i;
          int j;
          long l2;
          bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        }
        catch (IOException paramJobContext)
        {
          try
          {
            if (((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int)) {
              ((EditFilterExport)localObject2).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
            }
            i = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.c;
            j = paramGenerateContext.jdField_a_of_type_Int;
            if ((j != 2) && (j != 3) && (j != 5) && (j != 101) && (j != 104) && (j != 6)) {
              break;
            }
            localObject1 = a(localBitmap, i);
            if (localObject1 == null) {
              break;
            }
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            try
            {
              ImageUtil.a(str, (BitmapFactory.Options)localObject2);
              localObject1 = BitmapUtils.b((Bitmap)localObject1, ((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, true, false);
              if (localObject1 == null) {
                break label764;
              }
              if (paramGenerateContext.jdField_a_of_type_Int != 1) {
                break label622;
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
              BitmapUtils.a((Bitmap)localObject1, str, null);
              paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
              bool = true;
              paramJobContext = null;
            }
            catch (Throwable localThrowable)
            {
              SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
              bool = BitmapUtils.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
              continue;
            }
            localEditDoodleExport.a(localBitmap);
            if (localObject1 != localBitmap) {
              BitmapUtils.a((Bitmap)localObject1);
            }
            if ((localObject1 == null) || (!bool)) {
              break label650;
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
            localEditDoodleExport.a(localBitmap);
          }
          paramJobContext = paramJobContext;
          SLog.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
          super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
          return;
        }
        label622:
        continue;
        label650:
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
        StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
        return;
        label696:
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
        StoryReportor.b("take_video", "create_doodle_result", 0, -2, new String[0]);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
        return;
        SLog.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
        super.notifyResult(paramGenerateContext);
        return;
        label764:
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment
 * JD-Core Version:    0.7.0.1
 */