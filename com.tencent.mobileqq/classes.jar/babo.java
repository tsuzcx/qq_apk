import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class babo
  implements bhxi
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public babo(babn parambabn)
  {
    switch (babn.a(parambabn))
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
    if (this.jdField_a_of_type_Babn.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_Babn.onCancel();
    }
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn)), ", info hash=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn).hashCode()), ", info status=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn).g), ", progress=", Integer.valueOf(paramInt) });
      }
      l = System.currentTimeMillis();
      paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    } while ((paramInt >= 100) || (l - this.jdField_a_of_type_Long <= 500L));
    this.jdField_a_of_type_Long = l;
    ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Babn.isCanceled())
    {
      this.jdField_a_of_type_Babn.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn)), ", info hash=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn).hashCode()), ", info status=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn).g) });
    }
    switch (babn.a(this.jdField_a_of_type_Babn))
    {
    }
    while (!this.jdField_a_of_type_Babn.isCanceled())
    {
      babn.a(this.jdField_a_of_type_Babn, babn.a(this.jdField_a_of_type_Babn));
      return;
      babr localbabr = (babr)babn.a(this.jdField_a_of_type_Babn);
      localbabr.e = paramString;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localbabr));
      continue;
      babn.a(this.jdField_a_of_type_Babn).b = paramString;
    }
    this.jdField_a_of_type_Babn.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn).b()), ", mediaType=", Integer.valueOf(babn.a(this.jdField_a_of_type_Babn)) });
    }
    if (babn.a(this.jdField_a_of_type_Babn) == 2)
    {
      babn.b(this.jdField_a_of_type_Babn, babn.a(this.jdField_a_of_type_Babn));
      return;
    }
    babn.a(this.jdField_a_of_type_Babn, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babo
 * JD-Core Version:    0.7.0.1
 */