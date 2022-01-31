import com.tencent.qphone.base.util.QLog;

class asuz
  extends auoo
{
  asuz(asuw paramasuw, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, aunw paramaunw)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    asus localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString);
    if ((localasus != null) && (!localasus.jdField_a_of_type_Boolean))
    {
      localasus.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localasus.jdField_a_of_type_Asur.jdField_a_of_type_Int = 1;
      if (paramaunw == null) {
        break label236;
      }
      localasus.jdField_a_of_type_Int = paramaunw.jdField_a_of_type_Int;
      if ((paramaunw.jdField_a_of_type_Int != 0) && (paramaunw.jdField_a_of_type_Aunr != null))
      {
        localasus.jdField_b_of_type_Int = paramaunw.jdField_a_of_type_Aunr.jdField_a_of_type_Int;
        localasus.jdField_a_of_type_JavaLangString = paramaunw.jdField_a_of_type_Aunr.jdField_b_of_type_JavaLangString;
      }
      if (paramaunw.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramaunw.jdField_a_of_type_Boolean;; bool = false)
    {
      localasus.jdField_a_of_type_Asvj = new asvj(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString, localasus);
      asuw.a(this.jdField_a_of_type_Asuw, localasus.jdField_a_of_type_Asur, 0, localasus.jdField_b_of_type_Int, localasus.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Asuw.a != null) {
      this.jdField_a_of_type_Asuw.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    asus localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString);
    if ((localasus != null) && (!localasus.jdField_a_of_type_Boolean))
    {
      if (asuw.a(this.jdField_a_of_type_Asuw)) {
        asuw.a(this.jdField_a_of_type_Asuw, localasus.jdField_a_of_type_Asur, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localasus.c = paramInt;
    this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_JavaLangString, localasus);
    asuw.b(this.jdField_a_of_type_Asuw, localasus, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuz
 * JD-Core Version:    0.7.0.1
 */