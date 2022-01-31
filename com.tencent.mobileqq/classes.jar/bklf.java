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

public class bklf
  extends bklt<bkld, bkld>
  implements sxl
{
  public final int a;
  public final String a;
  public final WeakReference<bjsu> a;
  public final WeakReference<bjsv> b;
  
  public bklf(bjsu parambjsu, bjsv parambjsv, int paramInt)
  {
    this(parambjsu, parambjsv, null, paramInt);
  }
  
  public bklf(bjsu parambjsu, bjsv parambjsv, String paramString, int paramInt)
  {
    if (parambjsu == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsu);
    this.b = new WeakReference(parambjsv);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambkld.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      vei.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bjsu localbjsu = (bjsu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bjsv)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbjsu != null) && ((!localbjsu.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bjsv)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbjsu.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bjsv)localObject).a(this.jdField_a_of_type_Int)) {
          ((bjsv)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bbef.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          ved.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = vxv.c(localBitmap, i, k, true, false);
        i = bklo.a(parambkld);
        if (i != 0)
        {
          paramJobContext = vzl.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = vxv.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbjsu.a(localBitmap);
          if (paramJobContext != localBitmap) {
            vxv.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            ved.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            vei.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            vei.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambkld);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambkld.jdField_a_of_type_Int != 12) && (parambkld.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = vzl.a(paramJobContext, 270.0F);
          continue;
        }
        ved.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbjsu.a(localBitmap);
      }
      vei.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      ved.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      vei.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ved.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambkld);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklf
 * JD-Core Version:    0.7.0.1
 */