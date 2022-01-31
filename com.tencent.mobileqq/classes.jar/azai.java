import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class azai
  implements bgnx
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public azai(azah paramazah)
  {
    switch (azah.a(paramazah))
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
    if (this.jdField_a_of_type_Azah.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Azah.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah)), ", info hash=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah).hashCode()), ", info status=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Azah.isCanceled())
    {
      this.jdField_a_of_type_Azah.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah)), ", info hash=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah).hashCode()), ", info status=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah).g) });
    }
    switch (azah.a(this.jdField_a_of_type_Azah))
    {
    }
    while (!this.jdField_a_of_type_Azah.isCanceled())
    {
      azah.a(this.jdField_a_of_type_Azah, azah.a(this.jdField_a_of_type_Azah));
      return;
      azal localazal = (azal)azah.a(this.jdField_a_of_type_Azah);
      localazal.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localazal));
      continue;
      azah.a(this.jdField_a_of_type_Azah).b = paramString;
    }
    this.jdField_a_of_type_Azah.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah).b()), ", mediaType=", Integer.valueOf(azah.a(this.jdField_a_of_type_Azah)) });
    }
    if (azah.a(this.jdField_a_of_type_Azah) == 2)
    {
      azah.b(this.jdField_a_of_type_Azah, azah.a(this.jdField_a_of_type_Azah));
      return;
    }
    azah.a(this.jdField_a_of_type_Azah, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azai
 * JD-Core Version:    0.7.0.1
 */