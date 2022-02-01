import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class axqf
  implements bcxm
{
  axqf(axqb paramaxqb, long paramLong, axpw paramaxpw, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.a, "mp4");
      axpx localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString);
      if ((localaxpx != null) && (!localaxpx.jdField_a_of_type_Boolean))
      {
        localaxpx.jdField_a_of_type_Int = paramInt;
        localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localaxpx.jdField_a_of_type_Axqo = new axqo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString, localaxpx);
        this.jdField_a_of_type_Axqb.a(localaxpx.jdField_a_of_type_Axpw, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Axqb.a != null) && (this.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.a != null)) {
      this.jdField_a_of_type_Axqb.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.a.videoFileSize, true);
    }
    axpx localaxpx;
    if (this.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn != null)
    {
      localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString);
      if ((localaxpx != null) && (!localaxpx.jdField_a_of_type_Boolean))
      {
        localaxpx.c = paramInt;
        this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString, localaxpx);
        if (!axqb.a(this.jdField_a_of_type_Axqb)) {
          break label136;
        }
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx, localaxpx.c);
      }
    }
    return;
    label136:
    axqb.b(this.jdField_a_of_type_Axqb, localaxpx, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqf
 * JD-Core Version:    0.7.0.1
 */