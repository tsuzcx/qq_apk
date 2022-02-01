import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;

public class bnpn
  extends bnph<bnot, bnot>
{
  protected void a(JobContext paramJobContext, bnot parambnot)
  {
    System.currentTimeMillis();
    int i = UIUtils.getWindowScreenWidth(BaseApplication.getContext());
    i = UIUtils.getWindowScreenHeight(BaseApplication.getContext()) * 720 / i;
    if (i % 2 != 0) {
      i += 1;
    }
    for (;;)
    {
      Object localObject = parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (!parambnot.jdField_a_of_type_Bnoy.c)
      {
        paramJobContext = (JobContext)localObject;
        if (parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_Boolean) {
          paramJobContext = parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_JavaLangString;
        }
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      try
      {
        bfvo.a(paramJobContext, (BitmapFactory.Options)localObject);
        if ((!(parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && (((BitmapFactory.Options)localObject).outWidth <= 720) && (((BitmapFactory.Options)localObject).outHeight <= i) && (((BitmapFactory.Options)localObject).outWidth % 2 == 0) && (((BitmapFactory.Options)localObject).outHeight % 2 == 0)) {
          break label343;
        }
        paramJobContext = parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_AndroidGraphicsBitmap;
        if (paramJobContext == null)
        {
          xvv.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        xvv.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
        return;
      }
      xvv.a("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(paramJobContext.getWidth()), Integer.valueOf(paramJobContext.getHeight()));
      localObject = yoy.b(paramJobContext, 720, i, false, false);
      if (localObject == null)
      {
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
        return;
      }
      parambnot.jdField_a_of_type_Bnoy.c = false;
      parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_Boolean = true;
      String str = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.jdField_b_of_type_JavaLangString, ".jpg");
      yoy.a((Bitmap)localObject, str);
      if (paramJobContext != localObject)
      {
        ((Bitmap)localObject).recycle();
        xvv.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
      }
      for (;;)
      {
        parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_JavaLangString = str;
        super.notifyResult(parambnot);
        return;
        xvv.d("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
      }
      label343:
      xvv.b("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(720), Integer.valueOf(i));
      super.notifyResult(parambnot);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpn
 * JD-Core Version:    0.7.0.1
 */