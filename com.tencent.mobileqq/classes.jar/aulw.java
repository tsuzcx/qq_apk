import com.tencent.qphone.base.util.QLog;

class aulw
  extends awfw
{
  aulw(ault paramault, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, awfd paramawfd)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    aulp localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString);
    if ((localaulp != null) && (!localaulp.jdField_a_of_type_Boolean))
    {
      localaulp.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Int = 1;
      if (paramawfd == null) {
        break label236;
      }
      localaulp.jdField_a_of_type_Int = paramawfd.jdField_a_of_type_Int;
      if ((paramawfd.jdField_a_of_type_Int != 0) && (paramawfd.jdField_a_of_type_Awey != null))
      {
        localaulp.jdField_b_of_type_Int = paramawfd.jdField_a_of_type_Awey.jdField_a_of_type_Int;
        localaulp.jdField_a_of_type_JavaLangString = paramawfd.jdField_a_of_type_Awey.jdField_b_of_type_JavaLangString;
      }
      if (paramawfd.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramawfd.jdField_a_of_type_Boolean;; bool = false)
    {
      localaulp.jdField_a_of_type_Aumg = new aumg(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString, localaulp);
      ault.a(this.jdField_a_of_type_Ault, localaulp.jdField_a_of_type_Aulo, 0, localaulp.jdField_b_of_type_Int, localaulp.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ault.a != null) {
      this.jdField_a_of_type_Ault.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    aulp localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString);
    if ((localaulp != null) && (!localaulp.jdField_a_of_type_Boolean))
    {
      if (ault.a(this.jdField_a_of_type_Ault)) {
        ault.a(this.jdField_a_of_type_Ault, localaulp.jdField_a_of_type_Aulo, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localaulp.c = paramInt;
    this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_JavaLangString, localaulp);
    ault.b(this.jdField_a_of_type_Ault, localaulp, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulw
 * JD-Core Version:    0.7.0.1
 */