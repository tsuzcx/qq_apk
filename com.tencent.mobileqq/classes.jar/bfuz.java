import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bfuz
  implements bmjf
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public bfuz(bfuy parambfuy)
  {
    switch (bfuy.a(parambfuy))
    {
    default: 
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Float = 1.0F;
      return;
    case 1: 
      this.jdField_a_of_type_Int = 10;
      this.jdField_a_of_type_Float = 0.85F;
      return;
    }
    this.jdField_a_of_type_Int = 95;
    this.jdField_a_of_type_Float = 0.05F;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bfuy.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Bfuy.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy)), ", info hash=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy).hashCode()), ", info status=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfuy.isCanceled())
    {
      this.jdField_a_of_type_Bfuy.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy)), ", info hash=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy).hashCode()), ", info status=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy).g) });
    }
    switch (bfuy.a(this.jdField_a_of_type_Bfuy))
    {
    }
    while (!this.jdField_a_of_type_Bfuy.isCanceled())
    {
      bfuy.a(this.jdField_a_of_type_Bfuy, bfuy.a(this.jdField_a_of_type_Bfuy));
      return;
      bfvc localbfvc = (bfvc)bfuy.a(this.jdField_a_of_type_Bfuy);
      localbfvc.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbfvc));
      continue;
      bfuy.a(this.jdField_a_of_type_Bfuy).b = paramString;
    }
    this.jdField_a_of_type_Bfuy.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy).b()), ", mediaType=", Integer.valueOf(bfuy.a(this.jdField_a_of_type_Bfuy)) });
    }
    if (bfuy.a(this.jdField_a_of_type_Bfuy) == 2)
    {
      bfuy.b(this.jdField_a_of_type_Bfuy, bfuy.a(this.jdField_a_of_type_Bfuy));
      return;
    }
    bfuy.a(this.jdField_a_of_type_Bfuy, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuz
 * JD-Core Version:    0.7.0.1
 */