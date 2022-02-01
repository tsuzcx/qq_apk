import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class bnou
  extends bnph<bnot, bnot>
  implements vpk
{
  public final int a;
  public final String a;
  public final WeakReference<bnca> a;
  public final WeakReference<bncb> b;
  
  public bnou(bnca parambnca)
  {
    this(parambnca, null, 0);
  }
  
  public bnou(bnca parambnca, bncb parambncb, int paramInt)
  {
    this(parambnca, parambncb, null, paramInt);
  }
  
  public bnou(bnca parambnca, bncb parambncb, String paramString, int paramInt)
  {
    if (parambnca == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnca);
    this.b = new WeakReference(parambncb);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
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
    Object localObject1 = (bncb)this.b.get();
    Bitmap localBitmap;
    Object localObject2;
    if ((localbnca != null) && ((!localbnca.a(this.jdField_a_of_type_Int)) || ((localObject1 != null) && (((bncb)localObject1).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbnca.a().a(this.jdField_a_of_type_Int);
      if (localBitmap != null) {
        localObject2 = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.b, "mosaic.png");
      }
    }
    label806:
    label812:
    label819:
    for (;;)
    {
      try
      {
        yoy.a(localBitmap, (String)localObject2, null);
        parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject2);
        xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject2);
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        int k;
        int m;
        int j;
        int i;
        long l2;
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      }
      catch (IOException paramJobContext)
      {
        try
        {
          bfvo.a(paramJobContext, (BitmapFactory.Options)localObject2);
          k = ((BitmapFactory.Options)localObject2).outWidth;
          m = ((BitmapFactory.Options)localObject2).outHeight;
          paramJobContext = localbnca.a().a();
          if (paramJobContext != null)
          {
            paramJobContext = paramJobContext.a(k, m, true);
            if (paramJobContext != null) {
              parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_data", paramJobContext);
            }
          }
          localBitmap = localbnca.a(this.jdField_a_of_type_Int, false);
          paramJobContext = this.jdField_a_of_type_JavaLangString;
          if (paramJobContext != null) {
            break label819;
          }
          paramJobContext = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.b, ".png");
          if (localBitmap == null) {
            break label738;
          }
          if (localObject1 == null) {}
        }
        catch (OutOfMemoryError paramJobContext)
        {
          xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
          return;
        }
        try
        {
          if (((bncb)localObject1).a(this.jdField_a_of_type_Int)) {
            ((bncb)localObject1).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          j = m;
          i = k;
          if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            j = m;
            i = k;
            if (parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))
            {
              i = ((BitmapFactory.Options)localObject2).outHeight;
              j = ((BitmapFactory.Options)localObject2).outWidth;
            }
          }
          k = parambnot.jdField_a_of_type_Bnpa.c;
          m = parambnot.jdField_a_of_type_Int;
          if ((m != 2) && (m != 3) && (m != 5) && (m != 6) && (m != 102)) {
            break label812;
          }
          if ((parambnot.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            k = 0;
            xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resizedBitmap orientation=" + 0);
          }
          localObject1 = a(localBitmap, k);
          if (localObject1 == null) {
            break label812;
          }
          localObject1 = yoy.c((Bitmap)localObject1, i, j, true, false);
          if (localObject1 == null) {
            break label806;
          }
          bool = yoy.a((Bitmap)localObject1, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          localbnca.a(localBitmap);
          if (localObject1 != localBitmap) {
            yoy.a((Bitmap)localObject1);
          }
          if ((localObject1 == null) || (!bool)) {
            break label692;
          }
          xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          xwa.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          xwa.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(parambnot);
          return;
        }
        finally
        {
          localbnca.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      label692:
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label738:
      xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(parambnot);
      return;
      boolean bool = false;
      continue;
      localObject1 = localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnou
 * JD-Core Version:    0.7.0.1
 */