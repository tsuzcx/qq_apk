import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.lang.ref.WeakReference;

public class bpen
  extends bpez<bpel, bpel>
  implements wef
{
  public final int a;
  public final String a;
  public final WeakReference<bors> a;
  public final WeakReference<bort> b;
  
  public bpen(bors parambors, bort parambort, int paramInt)
  {
    this(parambors, parambort, null, paramInt);
  }
  
  public bpen(bors parambors, bort parambort, String paramString, int paramInt)
  {
    if (parambors == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambors);
    this.b = new WeakReference(parambort);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambpel.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      ykv.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bors localbors = (bors)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bort)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbors != null) && ((!localbors.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bort)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbors.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bort)localObject).a(this.jdField_a_of_type_Int)) {
          ((bort)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bheg.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          ykq.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = zdr.c(localBitmap, i, k, true, false);
        i = bpev.a(parambpel);
        if (i != 0)
        {
          paramJobContext = UIUtils.rotateBitmap(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = zdr.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbors.a(localBitmap);
          if (paramJobContext != localBitmap) {
            zdr.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            ykq.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            ykv.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            ykv.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambpel);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambpel.jdField_a_of_type_Int != 12) && (parambpel.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = UIUtils.rotateBitmap(paramJobContext, 270.0F);
          continue;
        }
        ykq.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbors.a(localBitmap);
      }
      ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      ykq.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ykq.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambpel);
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
 * Qualified Name:     bpen
 * JD-Core Version:    0.7.0.1
 */