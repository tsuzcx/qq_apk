import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class aryu
  implements awew
{
  aryu(aryq paramaryq, long paramLong, aryl paramaryl, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.a, "mp4");
      arym localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString);
      if ((localarym != null) && (!localarym.jdField_a_of_type_Boolean))
      {
        localarym.jdField_a_of_type_Int = paramInt;
        localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localarym.jdField_a_of_type_Arzd = new arzd(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString, localarym);
        this.jdField_a_of_type_Aryq.a(localarym.jdField_a_of_type_Aryl, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aryq.a != null) && (this.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.a != null)) {
      this.jdField_a_of_type_Aryq.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.a.videoFileSize, true);
    }
    arym localarym;
    if (this.jdField_a_of_type_Aryl.jdField_a_of_type_Awey != null)
    {
      localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString);
      if ((localarym != null) && (!localarym.jdField_a_of_type_Boolean))
      {
        localarym.c = paramInt;
        this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString, localarym);
        if (!aryq.a(this.jdField_a_of_type_Aryq)) {
          break label136;
        }
        aryq.a(this.jdField_a_of_type_Aryq, localarym, localarym.c);
      }
    }
    return;
    label136:
    aryq.b(this.jdField_a_of_type_Aryq, localarym, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryu
 * JD-Core Version:    0.7.0.1
 */