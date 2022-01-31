import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bbzx
  implements bjyt
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public bbzx(bbzw parambbzw)
  {
    switch (bbzw.a(parambbzw))
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
    if (this.jdField_a_of_type_Bbzw.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Bbzw.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw)), ", info hash=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw).hashCode()), ", info status=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bbzw.isCanceled())
    {
      this.jdField_a_of_type_Bbzw.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw)), ", info hash=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw).hashCode()), ", info status=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw).g) });
    }
    switch (bbzw.a(this.jdField_a_of_type_Bbzw))
    {
    }
    while (!this.jdField_a_of_type_Bbzw.isCanceled())
    {
      bbzw.a(this.jdField_a_of_type_Bbzw, bbzw.a(this.jdField_a_of_type_Bbzw));
      return;
      bcaa localbcaa = (bcaa)bbzw.a(this.jdField_a_of_type_Bbzw);
      localbcaa.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbcaa));
      continue;
      bbzw.a(this.jdField_a_of_type_Bbzw).b = paramString;
    }
    this.jdField_a_of_type_Bbzw.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw).b()), ", mediaType=", Integer.valueOf(bbzw.a(this.jdField_a_of_type_Bbzw)) });
    }
    if (bbzw.a(this.jdField_a_of_type_Bbzw) == 2)
    {
      bbzw.b(this.jdField_a_of_type_Bbzw, bbzw.a(this.jdField_a_of_type_Bbzw));
      return;
    }
    bbzw.a(this.jdField_a_of_type_Bbzw, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzx
 * JD-Core Version:    0.7.0.1
 */