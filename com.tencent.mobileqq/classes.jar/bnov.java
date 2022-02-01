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

public class bnov
  extends bnph<bnot, bnot>
  implements vpk
{
  public final int a;
  public final String a;
  public final WeakReference<bnca> a;
  public final WeakReference<bncb> b;
  
  public bnov(bnca parambnca, bncb parambncb, int paramInt)
  {
    this(parambnca, parambncb, null, paramInt);
  }
  
  public bnov(bnca parambnca, bncb parambncb, String paramString, int paramInt)
  {
    if (parambnca == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnca);
    this.b = new WeakReference(parambncb);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bnot parambnot)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambnot.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      xwa.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bnca localbnca = (bnca)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bncb)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbnca != null) && ((!localbnca.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bncb)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbnca.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bncb)localObject).a(this.jdField_a_of_type_Int)) {
          ((bncb)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bfvo.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          xvv.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = yoy.c(localBitmap, i, k, true, false);
        i = bnpd.a(parambnot);
        if (i != 0)
        {
          paramJobContext = UIUtils.rotateBitmap(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = yoy.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbnca.a(localBitmap);
          if (paramJobContext != localBitmap) {
            yoy.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            xvv.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            xwa.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            xwa.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambnot);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambnot.jdField_a_of_type_Int != 12) && (parambnot.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = UIUtils.rotateBitmap(paramJobContext, 270.0F);
          continue;
        }
        xvv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbnca.a(localBitmap);
      }
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      xvv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      xvv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambnot);
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
 * Qualified Name:     bnov
 * JD-Core Version:    0.7.0.1
 */