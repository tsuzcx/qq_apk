import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class baba
  implements bhwr
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public baba(baaz parambaaz)
  {
    switch (baaz.a(parambaaz))
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
    if (this.jdField_a_of_type_Baaz.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Baaz.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz)), ", info hash=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz).hashCode()), ", info status=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Baaz.isCanceled())
    {
      this.jdField_a_of_type_Baaz.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz)), ", info hash=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz).hashCode()), ", info status=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz).g) });
    }
    switch (baaz.a(this.jdField_a_of_type_Baaz))
    {
    }
    while (!this.jdField_a_of_type_Baaz.isCanceled())
    {
      baaz.a(this.jdField_a_of_type_Baaz, baaz.a(this.jdField_a_of_type_Baaz));
      return;
      babd localbabd = (babd)baaz.a(this.jdField_a_of_type_Baaz);
      localbabd.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbabd));
      continue;
      baaz.a(this.jdField_a_of_type_Baaz).b = paramString;
    }
    this.jdField_a_of_type_Baaz.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz).b()), ", mediaType=", Integer.valueOf(baaz.a(this.jdField_a_of_type_Baaz)) });
    }
    if (baaz.a(this.jdField_a_of_type_Baaz) == 2)
    {
      baaz.b(this.jdField_a_of_type_Baaz, baaz.a(this.jdField_a_of_type_Baaz));
      return;
    }
    baaz.a(this.jdField_a_of_type_Baaz, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baba
 * JD-Core Version:    0.7.0.1
 */