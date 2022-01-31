import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class asva
  implements axeg
{
  asva(asuw paramasuw, long paramLong, asur paramasur, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Asur.jdField_a_of_type_Axei.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Asur.jdField_a_of_type_Axei.a, "mp4");
      asus localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString);
      if ((localasus != null) && (!localasus.jdField_a_of_type_Boolean))
      {
        localasus.jdField_a_of_type_Int = paramInt;
        localasus.jdField_a_of_type_Asur.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localasus.jdField_a_of_type_Asvj = new asvj(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString, localasus);
        this.jdField_a_of_type_Asuw.a(localasus.jdField_a_of_type_Asur, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Asuw.a != null) && (this.jdField_a_of_type_Asur.jdField_a_of_type_Axei.a != null)) {
      this.jdField_a_of_type_Asuw.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Asur.jdField_a_of_type_Axei.a.videoFileSize, true);
    }
    asus localasus;
    if (this.jdField_a_of_type_Asur.jdField_a_of_type_Axei != null)
    {
      localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString);
      if ((localasus != null) && (!localasus.jdField_a_of_type_Boolean))
      {
        localasus.c = paramInt;
        this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString, localasus);
        if (!asuw.a(this.jdField_a_of_type_Asuw)) {
          break label136;
        }
        asuw.a(this.jdField_a_of_type_Asuw, localasus, localasus.c);
      }
    }
    return;
    label136:
    asuw.b(this.jdField_a_of_type_Asuw, localasus, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asva
 * JD-Core Version:    0.7.0.1
 */