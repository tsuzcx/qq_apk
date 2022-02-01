import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;

public class bquw
  extends bquq<bqua, bqua>
{
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    System.currentTimeMillis();
    int i = zps.a(BaseApplication.getContext());
    i = zps.d(BaseApplication.getContext()) * 720 / i;
    if (i % 2 != 0) {
      i += 1;
    }
    for (;;)
    {
      Object localObject = parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (!parambqua.jdField_a_of_type_Bqug.c)
      {
        paramJobContext = (JobContext)localObject;
        if (parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean) {
          paramJobContext = parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString;
        }
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      for (;;)
      {
        try
        {
          bhmq.a(paramJobContext, (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outWidth * 720 == ((BitmapFactory.Options)localObject).outHeight * i)
          {
            j = 1;
            if ((!(parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && ((parambqua.jdField_a_of_type_Int != 1) || (j != 0)) && (((BitmapFactory.Options)localObject).outWidth <= 720) && (((BitmapFactory.Options)localObject).outHeight <= i) && (((BitmapFactory.Options)localObject).outWidth % 2 == 0) && (((BitmapFactory.Options)localObject).outHeight % 2 == 0)) {
              break label384;
            }
            paramJobContext = parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_AndroidGraphicsBitmap;
            if (paramJobContext != null) {
              break;
            }
            yuk.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
            return;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          yuk.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
          return;
        }
        int j = 0;
      }
      yuk.a("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(paramJobContext.getWidth()), Integer.valueOf(paramJobContext.getHeight()));
      localObject = zoc.b(paramJobContext, 720, i, false, false);
      if (localObject == null)
      {
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
        return;
      }
      parambqua.jdField_a_of_type_Bqug.c = false;
      parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean = true;
      String str = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.jdField_b_of_type_JavaLangString, ".jpg");
      zoc.a((Bitmap)localObject, str);
      if (paramJobContext != localObject)
      {
        ((Bitmap)localObject).recycle();
        yuk.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
      }
      for (;;)
      {
        parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString = str;
        super.notifyResult(parambqua);
        return;
        yuk.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
      }
      label384:
      yuk.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(720), Integer.valueOf(i));
      super.notifyResult(parambqua);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bquw
 * JD-Core Version:    0.7.0.1
 */