import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bpey
  extends bpez<bpel, bpel>
{
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    int i = UIUtils.getScreenWidth(BaseApplication.getContext());
    int j = UIUtils.getScreenHeight(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    Object localObject = parambpel.jdField_a_of_type_Bpeq.a;
    paramJobContext = (JobContext)localObject;
    if (!parambpel.jdField_a_of_type_Bpeq.c)
    {
      paramJobContext = (JobContext)localObject;
      if (parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_Boolean) {
        paramJobContext = parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_JavaLangString;
      }
    }
    try
    {
      localObject = bheg.a(paramJobContext, new BitmapFactory.Options());
      if (localObject == null)
      {
        ykq.d("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      ykq.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", paramJobContext);
      super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
      return;
    }
    if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e != ((Bitmap)localObject).getHeight()) || (parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d != ((Bitmap)localObject).getWidth())) {}
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
      localObject = zdr.a((Bitmap)localObject, f, true);
      ykq.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(f), localObject);
      paramJobContext = (JobContext)localObject;
      if (localObject != null) {
        break;
      }
      notifyError(new BitmapError("resizeBitmapByScale failed", -1));
      return;
    }
    ykq.b("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + paramJobContext.getWidth() + ", " + paramJobContext.getHeight());
    if (j != 0) {
      paramJobContext = zdr.c(paramJobContext, 720, i, false, true);
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
      paramJobContext = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.jdField_b_of_type_JavaLangString, ".jpg");
      zdr.a((Bitmap)localObject, paramJobContext);
      ((Bitmap)localObject).recycle();
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramJobContext;
      super.notifyResult(parambpel);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpey
 * JD-Core Version:    0.7.0.1
 */