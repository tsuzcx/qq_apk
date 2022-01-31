import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.lang.ref.WeakReference;

public class bnbb
  extends bnbp<bnaz, bnaz>
  implements uqm
{
  public final int a;
  public final String a;
  public final WeakReference<bmiq> a;
  public final WeakReference<bmir> b;
  
  public bnbb(bmiq parambmiq, bmir parambmir, int paramInt)
  {
    this(parambmiq, parambmir, null, paramInt);
  }
  
  public bnbb(bmiq parambmiq, bmir parambmir, String paramString, int paramInt)
  {
    if (parambmiq == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmiq);
    this.b = new WeakReference(parambmir);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bnaz parambnaz)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambnaz.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      wxj.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bmiq localbmiq = (bmiq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bmir)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbmiq != null) && ((!localbmiq.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bmir)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbmiq.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bnbs.a(parambnaz.jdField_a_of_type_Int, parambnaz.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bmir)localObject).a(this.jdField_a_of_type_Int)) {
          ((bmir)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bdhj.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
            continue;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          int m;
          int n;
          int k;
          int i;
          long l2;
          wxe.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
          return;
        }
        k = n;
        i = m;
        if (m > n)
        {
          k = n;
          i = m;
          if (j != 0)
          {
            i = ((BitmapFactory.Options)localObject).outHeight;
            k = ((BitmapFactory.Options)localObject).outWidth;
          }
        }
        paramJobContext = xqw.c(localBitmap, i, k, true, false);
        i = bnbk.a(parambnaz);
        if (i != 0)
        {
          paramJobContext = xsm.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = xqw.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbmiq.a(localBitmap);
          if (paramJobContext != localBitmap) {
            xqw.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            wxe.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            wxj.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            wxj.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambnaz);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambnaz.jdField_a_of_type_Int != 12) && (parambnaz.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = xsm.a(paramJobContext, 270.0F);
          continue;
        }
        wxe.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbmiq.a(localBitmap);
      }
      wxj.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      wxe.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      wxj.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      wxe.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambnaz);
      return;
      label673:
      boolean bool = false;
      continue;
      label679:
      continue;
      label682:
      break;
      label685:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbb
 * JD-Core Version:    0.7.0.1
 */