import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class auqg
  implements azdv
{
  auqg(auqc paramauqc, long paramLong, aupx paramaupx, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.a, "mp4");
      aupy localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString);
      if ((localaupy != null) && (!localaupy.jdField_a_of_type_Boolean))
      {
        localaupy.jdField_a_of_type_Int = paramInt;
        localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localaupy.jdField_a_of_type_Auqp = new auqp(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString, localaupy);
        this.jdField_a_of_type_Auqc.a(localaupy.jdField_a_of_type_Aupx, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Auqc.a != null) && (this.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.a != null)) {
      this.jdField_a_of_type_Auqc.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.a.videoFileSize, true);
    }
    aupy localaupy;
    if (this.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx != null)
    {
      localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString);
      if ((localaupy != null) && (!localaupy.jdField_a_of_type_Boolean))
      {
        localaupy.c = paramInt;
        this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString, localaupy);
        if (!auqc.a(this.jdField_a_of_type_Auqc)) {
          break label136;
        }
        auqc.a(this.jdField_a_of_type_Auqc, localaupy, localaupy.c);
      }
    }
    return;
    label136:
    auqc.b(this.jdField_a_of_type_Auqc, localaupy, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqg
 * JD-Core Version:    0.7.0.1
 */