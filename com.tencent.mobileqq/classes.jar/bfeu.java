import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bfeu
  implements bmrk
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public bfeu(bfet parambfet)
  {
    switch (bfet.a(parambfet))
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
    if (this.jdField_a_of_type_Bfet.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Bfet.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet)), ", info hash=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet).hashCode()), ", info status=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfet.isCanceled())
    {
      this.jdField_a_of_type_Bfet.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet)), ", info hash=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet).hashCode()), ", info status=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet).g) });
    }
    switch (bfet.a(this.jdField_a_of_type_Bfet))
    {
    }
    while (!this.jdField_a_of_type_Bfet.isCanceled())
    {
      bfet.a(this.jdField_a_of_type_Bfet, bfet.a(this.jdField_a_of_type_Bfet));
      return;
      bfex localbfex = (bfex)bfet.a(this.jdField_a_of_type_Bfet);
      localbfex.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbfex));
      continue;
      bfet.a(this.jdField_a_of_type_Bfet).b = paramString;
    }
    this.jdField_a_of_type_Bfet.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet).b()), ", mediaType=", Integer.valueOf(bfet.a(this.jdField_a_of_type_Bfet)) });
    }
    if (bfet.a(this.jdField_a_of_type_Bfet) == 2)
    {
      bfet.b(this.jdField_a_of_type_Bfet, bfet.a(this.jdField_a_of_type_Bfet));
      return;
    }
    bfet.a(this.jdField_a_of_type_Bfet, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfeu
 * JD-Core Version:    0.7.0.1
 */