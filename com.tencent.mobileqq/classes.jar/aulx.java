import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class aulx
  implements ayzm
{
  aulx(ault paramault, long paramLong, aulo paramaulo, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.a, "mp4");
      aulp localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString);
      if ((localaulp != null) && (!localaulp.jdField_a_of_type_Boolean))
      {
        localaulp.jdField_a_of_type_Int = paramInt;
        localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localaulp.jdField_a_of_type_Aumg = new aumg(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString, localaulp);
        this.jdField_a_of_type_Ault.a(localaulp.jdField_a_of_type_Aulo, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Ault.a != null) && (this.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.a != null)) {
      this.jdField_a_of_type_Ault.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.a.videoFileSize, true);
    }
    aulp localaulp;
    if (this.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo != null)
    {
      localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString);
      if ((localaulp != null) && (!localaulp.jdField_a_of_type_Boolean))
      {
        localaulp.c = paramInt;
        this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString, localaulp);
        if (!ault.a(this.jdField_a_of_type_Ault)) {
          break label136;
        }
        ault.a(this.jdField_a_of_type_Ault, localaulp, localaulp.c);
      }
    }
    return;
    label136:
    ault.b(this.jdField_a_of_type_Ault, localaulp, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulx
 * JD-Core Version:    0.7.0.1
 */