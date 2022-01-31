import cooperation.qqreader.js.JsCallParams;

class bgun
{
  long jdField_a_of_type_Long;
  JsCallParams jdField_a_of_type_CooperationQqreaderJsJsCallParams;
  long b;
  
  bgun(String paramString1, String paramString2, String paramString3, long paramLong, String... paramVarArgs)
  {
    this.jdField_a_of_type_CooperationQqreaderJsJsCallParams = new JsCallParams(paramString1, paramString2, paramString3, paramVarArgs);
    this.jdField_a_of_type_Long = paramLong;
    this.b = System.currentTimeMillis();
  }
  
  void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  boolean a()
  {
    return System.currentTimeMillis() - this.b > this.jdField_a_of_type_Long;
  }
  
  boolean a(bgun parambgun)
  {
    return this.jdField_a_of_type_CooperationQqreaderJsJsCallParams.a(parambgun.jdField_a_of_type_CooperationQqreaderJsJsCallParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgun
 * JD-Core Version:    0.7.0.1
 */