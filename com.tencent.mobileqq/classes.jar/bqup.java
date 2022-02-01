import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bqup
  extends bquq<bqua, bqua>
{
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    int i = zps.b(BaseApplication.getContext());
    int j = zps.c(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = parambqua.jdField_a_of_type_Bqug.a;
    paramJobContext = (JobContext)localObject;
    if (!parambqua.jdField_a_of_type_Bqug.c)
    {
      paramJobContext = (JobContext)localObject;
      if (parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean) {
        paramJobContext = parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString;
      }
    }
    try
    {
      localObject = bhmq.a(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        yuk.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      yuk.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
      return;
    }
    if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d != ((Bitmap)localObject).getHeight()) || (parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c != ((Bitmap)localObject).getWidth())) {}
    for (j = 1;; j = 0)
    {
      if (((Bitmap)localObject).getWidth() <= 720)
      {
        paramJobContext = (JobContext)localObject;
        if (((Bitmap)localObject).getHeight() <= i) {
          break;
        }
      }
      float f = Math.min(720 / ((Bitmap)localObject).getWidth(), i / ((Bitmap)localObject).getHeight());
      localObject = zoc.a((Bitmap)localObject, f, true);
      yuk.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
      paramJobContext = (JobContext)localObject;
      if (localObject != null) {
        break;
      }
      notifyError(new BitmapError("resizeBitmapByScale failed", -1));
      return;
    }
    yuk.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + paramJobContext.getWidth() + ", " + paramJobContext.getHeight());
    if (j != 0) {
      paramJobContext = zoc.c(paramJobContext, 720, i, false, true);
    }
    for (;;)
    {
      if (paramJobContext == null)
      {
        notifyError(new BitmapError("fillBitmapEdge failed", -1));
        return;
      }
      if (paramJobContext.getHeight() % 2 == 0)
      {
        localObject = paramJobContext;
        if (paramJobContext.getWidth() % 2 == 0) {}
      }
      else
      {
        localObject = Bitmap.createScaledBitmap(paramJobContext, paramJobContext.getWidth() >> 1 << 1, paramJobContext.getHeight() >> 1 << 1, false);
      }
      paramJobContext = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.jdField_b_of_type_JavaLangString, ".jpg");
      zoc.a((Bitmap)localObject, paramJobContext);
      ((Bitmap)localObject).recycle();
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramJobContext;
      super.notifyResult(parambqua);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqup
 * JD-Core Version:    0.7.0.1
 */