import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bkls
  extends bklt<bkld, bkld>
{
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    int i = vzl.b(BaseApplication.getContext());
    int j = vzl.c(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = parambkld.jdField_a_of_type_Bklj.a;
    paramJobContext = (JobContext)localObject;
    if (!parambkld.jdField_a_of_type_Bklj.c)
    {
      paramJobContext = (JobContext)localObject;
      if (parambkld.jdField_a_of_type_Bklj.jdField_b_of_type_Boolean) {
        paramJobContext = parambkld.jdField_a_of_type_Bklj.jdField_b_of_type_JavaLangString;
      }
    }
    try
    {
      localObject = bbef.a(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        ved.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      ved.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
      return;
    }
    if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d != ((Bitmap)localObject).getHeight()) || (parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c != ((Bitmap)localObject).getWidth())) {}
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
      localObject = vxv.a((Bitmap)localObject, f, true);
      ved.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
      paramJobContext = (JobContext)localObject;
      if (localObject != null) {
        break;
      }
      notifyError(new BitmapError("resizeBitmapByScale failed", -1));
      return;
    }
    ved.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + paramJobContext.getWidth() + ", " + paramJobContext.getHeight());
    if (j != 0) {
      paramJobContext = vxv.c(paramJobContext, 720, i, false, true);
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
      paramJobContext = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.jdField_b_of_type_JavaLangString, ".jpg");
      vxv.a((Bitmap)localObject, paramJobContext);
      ((Bitmap)localObject).recycle();
      parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramJobContext;
      super.notifyResult(parambkld);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkls
 * JD-Core Version:    0.7.0.1
 */