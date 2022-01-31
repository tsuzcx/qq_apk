import com.tencent.qphone.base.util.QLog;

class aryt
  extends atqo
{
  aryt(aryq paramaryq, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, atpw paramatpw)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    arym localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString);
    if ((localarym != null) && (!localarym.jdField_a_of_type_Boolean))
    {
      localarym.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Int = 1;
      if (paramatpw == null) {
        break label236;
      }
      localarym.jdField_a_of_type_Int = paramatpw.jdField_a_of_type_Int;
      if ((paramatpw.jdField_a_of_type_Int != 0) && (paramatpw.jdField_a_of_type_Atpr != null))
      {
        localarym.jdField_b_of_type_Int = paramatpw.jdField_a_of_type_Atpr.jdField_a_of_type_Int;
        localarym.jdField_a_of_type_JavaLangString = paramatpw.jdField_a_of_type_Atpr.jdField_b_of_type_JavaLangString;
      }
      if (paramatpw.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramatpw.jdField_a_of_type_Boolean;; bool = false)
    {
      localarym.jdField_a_of_type_Arzd = new arzd(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString, localarym);
      aryq.a(this.jdField_a_of_type_Aryq, localarym.jdField_a_of_type_Aryl, 0, localarym.jdField_b_of_type_Int, localarym.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aryq.a != null) {
      this.jdField_a_of_type_Aryq.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    arym localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString);
    if ((localarym != null) && (!localarym.jdField_a_of_type_Boolean))
    {
      if (aryq.a(this.jdField_a_of_type_Aryq)) {
        aryq.a(this.jdField_a_of_type_Aryq, localarym.jdField_a_of_type_Aryl, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localarym.c = paramInt;
    this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_JavaLangString, localarym);
    aryq.b(this.jdField_a_of_type_Aryq, localarym, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryt
 * JD-Core Version:    0.7.0.1
 */