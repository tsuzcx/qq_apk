import com.tencent.qphone.base.util.QLog;

class awxl
  extends ayyr
{
  awxl(awxi paramawxi, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, ayxy paramayxy)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    awxe localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString);
    if ((localawxe != null) && (!localawxe.jdField_a_of_type_Boolean))
    {
      localawxe.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Int = 1;
      if (paramayxy == null) {
        break label236;
      }
      localawxe.jdField_a_of_type_Int = paramayxy.jdField_a_of_type_Int;
      if ((paramayxy.jdField_a_of_type_Int != 0) && (paramayxy.jdField_a_of_type_Ayxt != null))
      {
        localawxe.jdField_b_of_type_Int = paramayxy.jdField_a_of_type_Ayxt.jdField_a_of_type_Int;
        localawxe.jdField_a_of_type_JavaLangString = paramayxy.jdField_a_of_type_Ayxt.jdField_b_of_type_JavaLangString;
      }
      if (paramayxy.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramayxy.jdField_a_of_type_Boolean;; bool = false)
    {
      localawxe.jdField_a_of_type_Awxv = new awxv(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString, localawxe);
      awxi.a(this.jdField_a_of_type_Awxi, localawxe.jdField_a_of_type_Awxd, 0, localawxe.jdField_b_of_type_Int, localawxe.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awxi.a != null) {
      this.jdField_a_of_type_Awxi.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    awxe localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString);
    if ((localawxe != null) && (!localawxe.jdField_a_of_type_Boolean))
    {
      if (awxi.a(this.jdField_a_of_type_Awxi)) {
        awxi.a(this.jdField_a_of_type_Awxi, localawxe.jdField_a_of_type_Awxd, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localawxe.c = paramInt;
    this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_JavaLangString, localawxe);
    awxi.b(this.jdField_a_of_type_Awxi, localawxe, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxl
 * JD-Core Version:    0.7.0.1
 */