import cooperation.qqreader.js.JsCallParams;

class bmfn
{
  long jdField_a_of_type_Long;
  JsCallParams jdField_a_of_type_CooperationQqreaderJsJsCallParams;
  long b;
  
  bmfn(String paramString1, String paramString2, String paramString3, long paramLong, String... paramVarArgs)
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
  
  boolean a(bmfn parambmfn)
  {
    return this.jdField_a_of_type_CooperationQqreaderJsJsCallParams.a(parambmfn.jdField_a_of_type_CooperationQqreaderJsJsCallParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfn
 * JD-Core Version:    0.7.0.1
 */