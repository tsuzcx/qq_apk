import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class awdm
  implements bbqw
{
  awdm(awdi paramawdi, long paramLong, awdd paramawdd, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.a != null)
    {
      String str = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.a, "mp4");
      awde localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString);
      if ((localawde != null) && (!localawde.jdField_a_of_type_Boolean))
      {
        localawde.jdField_a_of_type_Int = paramInt;
        localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localawde.jdField_a_of_type_Awdv = new awdv(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString, localawde);
        this.jdField_a_of_type_Awdi.a(localawde.jdField_a_of_type_Awdd, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Awdi.a != null) && (this.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.a != null)) {
      this.jdField_a_of_type_Awdi.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.a.videoFileSize, true);
    }
    awde localawde;
    if (this.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx != null)
    {
      localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString);
      if ((localawde != null) && (!localawde.jdField_a_of_type_Boolean))
      {
        localawde.c = paramInt;
        this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString, localawde);
        if (!awdi.a(this.jdField_a_of_type_Awdi)) {
          break label136;
        }
        awdi.a(this.jdField_a_of_type_Awdi, localawde, localawde.c);
      }
    }
    return;
    label136:
    awdi.b(this.jdField_a_of_type_Awdi, localawde, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdm
 * JD-Core Version:    0.7.0.1
 */