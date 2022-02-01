import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bfez
  extends JobSegment<bfex, bfex>
{
  private int jdField_a_of_type_Int;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public bfez(XMediaEditor paramXMediaEditor, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bfex parambfex)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment start. info status=", Integer.valueOf(parambfex.g) });
    }
    String str2 = bfer.b();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    Bitmap localBitmap3 = null;
    String str1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Bitmap localBitmap2 = localBitmap3;
    Object localObject1 = str1;
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(parambfex.f);
        localObject2 = localObject3;
        localBitmap2 = localBitmap3;
        localObject1 = str1;
        localBitmap4 = localMediaMetadataRetriever.getFrameAtTime(-1L);
        if (localBitmap4 == null)
        {
          localObject2 = localObject3;
          localBitmap2 = localBitmap3;
          localObject1 = str1;
          notifyError(new Error("-201"));
        }
      }
      catch (Exception paramJobContext)
      {
        Bitmap localBitmap4;
        int[] arrayOfInt;
        localObject1 = localObject2;
        QLog.e("GenerateVideoPosterSegment", 1, "error retrieve video info" + paramJobContext.getMessage());
        localObject1 = localObject2;
        notifyError(new Error("-201"));
        try
        {
          localMediaMetadataRetriever.release();
          if (localObject2 == null) {
            continue;
          }
          ((Bitmap)localObject2).recycle();
          return;
        }
        catch (RuntimeException paramJobContext)
        {
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localBitmap1 = localBitmap2;
        QLog.e("GenerateVideoPosterSegment", 1, "GenerateVideoPosterSegment error. OutOfMemoryError");
        localBitmap1 = localBitmap2;
        URLDrawable.clearMemoryCache();
        localBitmap1 = localBitmap2;
        System.gc();
        localBitmap1 = localBitmap2;
        if (!this.jdField_a_of_type_Boolean)
        {
          localBitmap1 = localBitmap2;
          this.jdField_a_of_type_Boolean = true;
          localBitmap1 = localBitmap2;
          a(paramJobContext, parambfex);
          try
          {
            localMediaMetadataRetriever.release();
            if (localBitmap2 == null) {
              continue;
            }
            localBitmap2.recycle();
            return;
          }
          catch (RuntimeException paramJobContext)
          {
            return;
          }
        }
        localBitmap1 = localBitmap2;
        notifyError(new Error("-1"));
        continue;
      }
      finally
      {
        try
        {
          Bitmap localBitmap1;
          localMediaMetadataRetriever.release();
          if (localBitmap1 != null) {
            localBitmap1.recycle();
          }
        }
        catch (RuntimeException parambfex)
        {
          continue;
        }
      }
      try
      {
        localMediaMetadataRetriever.release();
        if (0 != 0) {
          throw new NullPointerException();
        }
        return;
      }
      catch (RuntimeException paramJobContext) {}
      localObject2 = localObject3;
      localBitmap2 = localBitmap3;
      localObject1 = str1;
      arrayOfInt = bffo.a(this.jdField_a_of_type_Int, 200, 300, parambfex.jdField_a_of_type_Int, parambfex.b);
      localObject2 = localObject3;
      localBitmap2 = localBitmap3;
      localObject1 = str1;
      localBitmap3 = ThumbnailUtils.extractThumbnail(localBitmap4, arrayOfInt[0], arrayOfInt[1]);
      if (localBitmap3 == null)
      {
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        notifyError(new Error("-201"));
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap3 == null) {
            continue;
          }
          localBitmap3.recycle();
          return;
        }
        catch (RuntimeException paramJobContext) {}
      }
      else
      {
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        str1 = bhgg.a(str2 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        bgmo.a(localBitmap3, new File(str1));
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        parambfex.c = str1;
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        ThreadManager.getUIHandler().post(new VideoInfo.GenerateVideoPosterSegment.1(this, parambfex, str1));
        localObject2 = localBitmap3;
        localBitmap2 = localBitmap3;
        localObject1 = localBitmap3;
        if (!isCanceled())
        {
          localObject2 = localBitmap3;
          localBitmap2 = localBitmap3;
          localObject1 = localBitmap3;
          if (QLog.isColorLevel())
          {
            localObject2 = localBitmap3;
            localBitmap2 = localBitmap3;
            localObject1 = localBitmap3;
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(parambfex.g) });
          }
          localObject2 = localBitmap3;
          localBitmap2 = localBitmap3;
          localObject1 = localBitmap3;
          notifyResult(parambfex);
        }
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap3 != null)
          {
            localBitmap3.recycle();
            return;
          }
        }
        catch (RuntimeException paramJobContext) {}
      }
    }
  }
  
  public void onCancel()
  {
    notifyError(new Error("c_2000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfez
 * JD-Core Version:    0.7.0.1
 */