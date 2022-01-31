import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class asuy
  implements axee
{
  asuy(asuu paramasuu, long paramLong, asup paramasup, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.a, "mp4");
      asuq localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString);
      if ((localasuq != null) && (!localasuq.jdField_a_of_type_Boolean))
      {
        localasuq.jdField_a_of_type_Int = paramInt;
        localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localasuq.jdField_a_of_type_Asvh = new asvh(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString, localasuq);
        this.jdField_a_of_type_Asuu.a(localasuq.jdField_a_of_type_Asup, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Asuu.a != null) && (this.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.a != null)) {
      this.jdField_a_of_type_Asuu.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.a.videoFileSize, true);
    }
    asuq localasuq;
    if (this.jdField_a_of_type_Asup.jdField_a_of_type_Axeg != null)
    {
      localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString);
      if ((localasuq != null) && (!localasuq.jdField_a_of_type_Boolean))
      {
        localasuq.c = paramInt;
        this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString, localasuq);
        if (!asuu.a(this.jdField_a_of_type_Asuu)) {
          break label136;
        }
        asuu.a(this.jdField_a_of_type_Asuu, localasuq, localasuq.c);
      }
    }
    return;
    label136:
    asuu.b(this.jdField_a_of_type_Asuu, localasuq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuy
 * JD-Core Version:    0.7.0.1
 */