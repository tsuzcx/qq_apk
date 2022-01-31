import com.tencent.qphone.base.util.QLog;

class asux
  extends auom
{
  asux(asuu paramasuu, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, aunu paramaunu)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    asuq localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString);
    if ((localasuq != null) && (!localasuq.jdField_a_of_type_Boolean))
    {
      localasuq.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Int = 1;
      if (paramaunu == null) {
        break label236;
      }
      localasuq.jdField_a_of_type_Int = paramaunu.jdField_a_of_type_Int;
      if ((paramaunu.jdField_a_of_type_Int != 0) && (paramaunu.jdField_a_of_type_Aunp != null))
      {
        localasuq.jdField_b_of_type_Int = paramaunu.jdField_a_of_type_Aunp.jdField_a_of_type_Int;
        localasuq.jdField_a_of_type_JavaLangString = paramaunu.jdField_a_of_type_Aunp.jdField_b_of_type_JavaLangString;
      }
      if (paramaunu.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramaunu.jdField_a_of_type_Boolean;; bool = false)
    {
      localasuq.jdField_a_of_type_Asvh = new asvh(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString, localasuq);
      asuu.a(this.jdField_a_of_type_Asuu, localasuq.jdField_a_of_type_Asup, 0, localasuq.jdField_b_of_type_Int, localasuq.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Asuu.a != null) {
      this.jdField_a_of_type_Asuu.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    asuq localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString);
    if ((localasuq != null) && (!localasuq.jdField_a_of_type_Boolean))
    {
      if (asuu.a(this.jdField_a_of_type_Asuu)) {
        asuu.a(this.jdField_a_of_type_Asuu, localasuq.jdField_a_of_type_Asup, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localasuq.c = paramInt;
    this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_JavaLangString, localasuq);
    asuu.b(this.jdField_a_of_type_Asuu, localasuq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asux
 * JD-Core Version:    0.7.0.1
 */