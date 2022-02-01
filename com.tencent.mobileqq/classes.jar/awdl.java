import com.tencent.qphone.base.util.QLog;

class awdl
  extends ayem
{
  awdl(awdi paramawdi, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, aydt paramaydt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    awde localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString);
    if ((localawde != null) && (!localawde.jdField_a_of_type_Boolean))
    {
      localawde.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Int = 1;
      if (paramaydt == null) {
        break label236;
      }
      localawde.jdField_a_of_type_Int = paramaydt.jdField_a_of_type_Int;
      if ((paramaydt.jdField_a_of_type_Int != 0) && (paramaydt.jdField_a_of_type_Aydp != null))
      {
        localawde.jdField_b_of_type_Int = paramaydt.jdField_a_of_type_Aydp.jdField_a_of_type_Int;
        localawde.jdField_a_of_type_JavaLangString = paramaydt.jdField_a_of_type_Aydp.jdField_b_of_type_JavaLangString;
      }
      if (paramaydt.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramaydt.jdField_a_of_type_Boolean;; bool = false)
    {
      localawde.jdField_a_of_type_Awdv = new awdv(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString, localawde);
      awdi.a(this.jdField_a_of_type_Awdi, localawde.jdField_a_of_type_Awdd, 0, localawde.jdField_b_of_type_Int, localawde.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awdi.a != null) {
      this.jdField_a_of_type_Awdi.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    awde localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString);
    if ((localawde != null) && (!localawde.jdField_a_of_type_Boolean))
    {
      if (awdi.a(this.jdField_a_of_type_Awdi)) {
        awdi.a(this.jdField_a_of_type_Awdi, localawde.jdField_a_of_type_Awdd, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localawde.c = paramInt;
    this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_JavaLangString, localawde);
    awdi.b(this.jdField_a_of_type_Awdi, localawde, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdl
 * JD-Core Version:    0.7.0.1
 */