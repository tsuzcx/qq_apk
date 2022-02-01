class bkvu
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public bkvu(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
    this.e = paramInt5;
  }
  
  public String toString()
  {
    return "filePath=" + this.jdField_a_of_type_JavaLangString + ",fileName=" + this.jdField_b_of_type_JavaLangString + ",fileId=" + this.jdField_b_of_type_Int + ",fileUrl=" + this.jdField_c_of_type_JavaLangString + ",fileHash=" + this.jdField_d_of_type_JavaLangString + ",fileVersion=" + this.jdField_c_of_type_Int + ",zipFlag=" + this.jdField_a_of_type_Boolean + ",startTime=" + this.jdField_a_of_type_Long + ",tryTimes=" + this.jdField_d_of_type_Int + ",downloadFlag=" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvu
 * JD-Core Version:    0.7.0.1
 */