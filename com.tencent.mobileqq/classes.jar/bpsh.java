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

public class bpsh
  extends bpsv<bpsf, bpsf>
  implements wjy
{
  public final int a;
  public final String a;
  public final WeakReference<bozw> a;
  public final WeakReference<bozx> b;
  
  public bpsh(bozw parambozw, bozx parambozx, int paramInt)
  {
    this(parambozw, parambozx, null, paramInt);
  }
  
  public bpsh(bozw parambozw, bozx parambozx, String paramString, int paramInt)
  {
    if (parambozw == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambozw);
    this.b = new WeakReference(parambozx);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bpsf parambpsf)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambpsf.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      yqu.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bozw localbozw = (bozw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bozx)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbozw != null) && ((!localbozw.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bozx)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbozw.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bpsy.a(parambpsf.jdField_a_of_type_Int, parambpsf.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bozx)localObject).a(this.jdField_a_of_type_Int)) {
          ((bozx)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bgmo.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambpsf.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          yqp.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = zkh.c(localBitmap, i, k, true, false);
        i = bpsq.a(parambpsf);
        if (i != 0)
        {
          paramJobContext = zlx.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = zkh.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbozw.a(localBitmap);
          if (paramJobContext != localBitmap) {
            zkh.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            yqp.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            yqu.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            yqu.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambpsf);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambpsf.jdField_a_of_type_Int != 12) && (parambpsf.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = zlx.a(paramJobContext, 270.0F);
          continue;
        }
        yqp.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbozw.a(localBitmap);
      }
      yqu.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      yqp.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      yqu.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      yqp.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambpsf);
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
 * Qualified Name:     bpsh
 * JD-Core Version:    0.7.0.1
 */