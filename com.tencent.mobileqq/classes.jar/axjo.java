import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class axjo
  implements bcxq
{
  axjo(axjk paramaxjk, long paramLong, axjf paramaxjf, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.a != null)
    {
      String str = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.a, "mp4");
      axjg localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString);
      if ((localaxjg != null) && (!localaxjg.jdField_a_of_type_Boolean))
      {
        localaxjg.jdField_a_of_type_Int = paramInt;
        localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localaxjg.jdField_a_of_type_Axjx = new axjx(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString, localaxjg);
        this.jdField_a_of_type_Axjk.a(localaxjg.jdField_a_of_type_Axjf, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Axjk.a != null) && (this.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.a != null)) {
      this.jdField_a_of_type_Axjk.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.a.videoFileSize, true);
    }
    axjg localaxjg;
    if (this.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr != null)
    {
      localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString);
      if ((localaxjg != null) && (!localaxjg.jdField_a_of_type_Boolean))
      {
        localaxjg.c = paramInt;
        this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString, localaxjg);
        if (!axjk.a(this.jdField_a_of_type_Axjk)) {
          break label136;
        }
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg, localaxjg.c);
      }
    }
    return;
    label136:
    axjk.b(this.jdField_a_of_type_Axjk, localaxjg, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjo
 * JD-Core Version:    0.7.0.1
 */