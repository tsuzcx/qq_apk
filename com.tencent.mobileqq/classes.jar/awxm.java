import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class awxm
  implements bceu
{
  awxm(awxi paramawxi, long paramLong, awxd paramawxd, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.a != null)
    {
      String str = ShortVideoUtils.a(this.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.a, "mp4");
      awxe localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString);
      if ((localawxe != null) && (!localawxe.jdField_a_of_type_Boolean))
      {
        localawxe.jdField_a_of_type_Int = paramInt;
        localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localawxe.jdField_a_of_type_Awxv = new awxv(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
        this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString, localawxe);
        this.jdField_a_of_type_Awxi.a(localawxe.jdField_a_of_type_Awxd, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Awxi.a != null) && (this.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.a != null)) {
      this.jdField_a_of_type_Awxi.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.a.videoFileSize, true);
    }
    awxe localawxe;
    if (this.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev != null)
    {
      localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString);
      if ((localawxe != null) && (!localawxe.jdField_a_of_type_Boolean))
      {
        localawxe.c = paramInt;
        this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString, localawxe);
        if (!awxi.a(this.jdField_a_of_type_Awxi)) {
          break label136;
        }
        awxi.a(this.jdField_a_of_type_Awxi, localawxe, localawxe.c);
      }
    }
    return;
    label136:
    awxi.b(this.jdField_a_of_type_Awxi, localawxe, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxm
 * JD-Core Version:    0.7.0.1
 */