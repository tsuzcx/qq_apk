import cooperation.qqreader.js.JsCallParams;

class bgve
{
  long jdField_a_of_type_Long;
  JsCallParams jdField_a_of_type_CooperationQqreaderJsJsCallParams;
  long b;
  
  bgve(String paramString1, String paramString2, String paramString3, long paramLong, String... paramVarArgs)
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
  
  boolean a(bgve parambgve)
  {
    return this.jdField_a_of_type_CooperationQqreaderJsJsCallParams.a(parambgve.jdField_a_of_type_CooperationQqreaderJsJsCallParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgve
 * JD-Core Version:    0.7.0.1
 */