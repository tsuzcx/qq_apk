import com.tencent.qphone.base.util.QLog;

class auqf
  extends awkf
{
  auqf(auqc paramauqc, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, awjm paramawjm)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    aupy localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString);
    if ((localaupy != null) && (!localaupy.jdField_a_of_type_Boolean))
    {
      localaupy.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Int = 1;
      if (paramawjm == null) {
        break label236;
      }
      localaupy.jdField_a_of_type_Int = paramawjm.jdField_a_of_type_Int;
      if ((paramawjm.jdField_a_of_type_Int != 0) && (paramawjm.jdField_a_of_type_Awjh != null))
      {
        localaupy.jdField_b_of_type_Int = paramawjm.jdField_a_of_type_Awjh.jdField_a_of_type_Int;
        localaupy.jdField_a_of_type_JavaLangString = paramawjm.jdField_a_of_type_Awjh.jdField_b_of_type_JavaLangString;
      }
      if (paramawjm.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramawjm.jdField_a_of_type_Boolean;; bool = false)
    {
      localaupy.jdField_a_of_type_Auqp = new auqp(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString, localaupy);
      auqc.a(this.jdField_a_of_type_Auqc, localaupy.jdField_a_of_type_Aupx, 0, localaupy.jdField_b_of_type_Int, localaupy.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Auqc.a != null) {
      this.jdField_a_of_type_Auqc.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    aupy localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString);
    if ((localaupy != null) && (!localaupy.jdField_a_of_type_Boolean))
    {
      if (auqc.a(this.jdField_a_of_type_Auqc)) {
        auqc.a(this.jdField_a_of_type_Auqc, localaupy.jdField_a_of_type_Aupx, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localaupy.c = paramInt;
    this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_JavaLangString, localaupy);
    auqc.b(this.jdField_a_of_type_Auqc, localaupy, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqf
 * JD-Core Version:    0.7.0.1
 */