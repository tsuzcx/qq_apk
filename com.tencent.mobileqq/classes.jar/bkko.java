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

public class bkko
  extends bklc<bkkm, bkkm>
  implements sxo
{
  public final int a;
  public final String a;
  public final WeakReference<bjsd> a;
  public final WeakReference<bjse> b;
  
  public bkko(bjsd parambjsd, bjse parambjse, int paramInt)
  {
    this(parambjsd, parambjse, null, paramInt);
  }
  
  public bkko(bjsd parambjsd, bjse parambjse, String paramString, int paramInt)
  {
    if (parambjsd == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsd);
    this.b = new WeakReference(parambjse);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bkkm parambkkm)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambkkm.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      vel.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bjsd localbjsd = (bjsd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bjse)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbjsd != null) && ((!localbjsd.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bjse)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbjsd.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bklf.a(parambkkm.jdField_a_of_type_Int, parambkkm.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bjse)localObject).a(this.jdField_a_of_type_Int)) {
          ((bjse)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bbdr.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          veg.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = vxy.c(localBitmap, i, k, true, false);
        i = bkkx.a(parambkkm);
        if (i != 0)
        {
          paramJobContext = vzo.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = vxy.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbjsd.a(localBitmap);
          if (paramJobContext != localBitmap) {
            vxy.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            veg.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            vel.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            vel.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambkkm);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambkkm.jdField_a_of_type_Int != 12) && (parambkkm.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = vzo.a(paramJobContext, 270.0F);
          continue;
        }
        veg.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbjsd.a(localBitmap);
      }
      vel.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      veg.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      vel.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      veg.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambkkm);
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
 * Qualified Name:     bkko
 * JD-Core Version:    0.7.0.1
 */