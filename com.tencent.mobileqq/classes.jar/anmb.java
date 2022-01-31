import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class anmb
  extends anlz
{
  public anmb(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, anma paramanma)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramanma);
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever1 = new MediaMetadataRetriever();
        try
        {
          localMediaMetadataRetriever1.setDataSource(this.jdField_a_of_type_JavaLangString);
          this.e = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VFLDecodeRunnable", 2, "runWithRetriever, start");
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (Thread.interrupted()) {
            continue;
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (a()) {
            continue;
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (this.e >= this.jdField_c_of_type_Int - 1) {
            continue;
          }
          l = a();
          Bitmap localBitmap1 = localMediaMetadataRetriever1.getFrameAtTime(l, 3);
          if (localBitmap1 != null) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VFLDecodeRunnable", 2, "runWithRetriever return null! time:" + l);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        MediaMetadataRetriever localMediaMetadataRetriever2;
        long l;
        Bitmap localBitmap2;
        MediaMetadataRetriever localMediaMetadataRetriever1 = null;
        continue;
      }
      localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
      if (QLog.isColorLevel())
      {
        QLog.d("VFLDecodeRunnable", 2, "runWithRetriever Load video frame execption:" + localException1);
        localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
      }
      if (localMediaMetadataRetriever2 != null) {
        localMediaMetadataRetriever2.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "runWithRetriever, end");
      }
      return;
      localBitmap2 = a(localException1);
      a(this.e, l, localBitmap2);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VFLDecodeRunnable", 2, "RetrieverDecodeRunnable run");
    }
    b();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Int <= 0) || (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long <= 0L) || (this.jdField_c_of_type_Int <= 0))
    {
      this.jdField_a_of_type_Boolean = true;
      a(1);
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "Retriever param error, path:" + this.jdField_a_of_type_JavaLangString + " height:" + this.jdField_b_of_type_Int + " width:" + this.jdField_a_of_type_Int + "time:" + this.jdField_b_of_type_Long + "-" + this.jdField_c_of_type_Long + " Count:" + this.jdField_c_of_type_Int);
      }
      return;
    }
    c();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmb
 * JD-Core Version:    0.7.0.1
 */