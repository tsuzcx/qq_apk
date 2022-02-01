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

public class bquc
  extends bquq<bqua, bqua>
  implements wnt
{
  public final int a;
  public final String a;
  public final WeakReference<bqbr> a;
  public final WeakReference<bqbs> b;
  
  public bquc(bqbr parambqbr, bqbs parambqbs, int paramInt)
  {
    this(parambqbr, parambqbs, null, paramInt);
  }
  
  public bquc(bqbr parambqbr, bqbs parambqbs, String paramString, int paramInt)
  {
    if (parambqbr == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqbr);
    this.b = new WeakReference(parambqbs);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambqua.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      yup.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bqbr localbqbr = (bqbr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bqbs)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbqbr != null) && ((!localbqbr.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bqbs)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbqbr.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bqbs)localObject).a(this.jdField_a_of_type_Int)) {
          ((bqbs)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bhmq.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          yuk.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = zoc.c(localBitmap, i, k, true, false);
        i = bqul.a(parambqua);
        if (i != 0)
        {
          paramJobContext = zps.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = zoc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbqbr.a(localBitmap);
          if (paramJobContext != localBitmap) {
            zoc.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            yuk.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            yup.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            yup.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambqua);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambqua.jdField_a_of_type_Int != 12) && (parambqua.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = zps.a(paramJobContext, 270.0F);
          continue;
        }
        yuk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbqbr.a(localBitmap);
      }
      yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      yuk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      yuk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambqua);
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
 * Qualified Name:     bquc
 * JD-Core Version:    0.7.0.1
 */