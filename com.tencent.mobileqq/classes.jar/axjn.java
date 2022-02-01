import com.tencent.qphone.base.util.QLog;

class axjn
  extends azky
{
  axjn(axjk paramaxjk, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, azkf paramazkf)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    axjg localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString);
    if ((localaxjg != null) && (!localaxjg.jdField_a_of_type_Boolean))
    {
      localaxjg.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Int = 1;
      if (paramazkf == null) {
        break label236;
      }
      localaxjg.jdField_a_of_type_Int = paramazkf.jdField_a_of_type_Int;
      if ((paramazkf.jdField_a_of_type_Int != 0) && (paramazkf.jdField_a_of_type_Azkb != null))
      {
        localaxjg.jdField_b_of_type_Int = paramazkf.jdField_a_of_type_Azkb.jdField_a_of_type_Int;
        localaxjg.jdField_a_of_type_JavaLangString = paramazkf.jdField_a_of_type_Azkb.jdField_b_of_type_JavaLangString;
      }
      if (paramazkf.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramazkf.jdField_a_of_type_Boolean;; bool = false)
    {
      localaxjg.jdField_a_of_type_Axjx = new axjx(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString, localaxjg);
      axjk.a(this.jdField_a_of_type_Axjk, localaxjg.jdField_a_of_type_Axjf, 0, localaxjg.jdField_b_of_type_Int, localaxjg.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axjk.a != null) {
      this.jdField_a_of_type_Axjk.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    axjg localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString);
    if ((localaxjg != null) && (!localaxjg.jdField_a_of_type_Boolean))
    {
      if (axjk.a(this.jdField_a_of_type_Axjk)) {
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg.jdField_a_of_type_Axjf, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localaxjg.c = paramInt;
    this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_JavaLangString, localaxjg);
    axjk.b(this.jdField_a_of_type_Axjk, localaxjg, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjn
 * JD-Core Version:    0.7.0.1
 */