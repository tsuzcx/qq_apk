import com.tencent.qphone.base.util.QLog;

class axqe
  extends azre
{
  axqe(axqb paramaxqb, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, azql paramazql)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    axpx localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString);
    if ((localaxpx != null) && (!localaxpx.jdField_a_of_type_Boolean))
    {
      localaxpx.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Int = 1;
      if (paramazql == null) {
        break label236;
      }
      localaxpx.jdField_a_of_type_Int = paramazql.jdField_a_of_type_Int;
      if ((paramazql.jdField_a_of_type_Int != 0) && (paramazql.jdField_a_of_type_Azqh != null))
      {
        localaxpx.jdField_b_of_type_Int = paramazql.jdField_a_of_type_Azqh.jdField_a_of_type_Int;
        localaxpx.jdField_a_of_type_JavaLangString = paramazql.jdField_a_of_type_Azqh.jdField_b_of_type_JavaLangString;
      }
      if (paramazql.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramazql.jdField_a_of_type_Boolean;; bool = false)
    {
      localaxpx.jdField_a_of_type_Axqo = new axqo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString, localaxpx);
      axqb.a(this.jdField_a_of_type_Axqb, localaxpx.jdField_a_of_type_Axpw, 0, localaxpx.jdField_b_of_type_Int, localaxpx.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axqb.a != null) {
      this.jdField_a_of_type_Axqb.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    axpx localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString);
    if ((localaxpx != null) && (!localaxpx.jdField_a_of_type_Boolean))
    {
      if (axqb.a(this.jdField_a_of_type_Axqb)) {
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx.jdField_a_of_type_Axpw, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localaxpx.c = paramInt;
    this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_JavaLangString, localaxpx);
    axqb.b(this.jdField_a_of_type_Axqb, localaxpx, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqe
 * JD-Core Version:    0.7.0.1
 */