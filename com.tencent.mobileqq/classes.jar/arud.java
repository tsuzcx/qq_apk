import com.tencent.qphone.base.util.QLog;

class arud
{
  int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  arua jdField_a_of_type_Arua;
  Object jdField_a_of_type_JavaLangObject = new Object();
  final String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  Object jdField_b_of_type_JavaLangObject = new Object();
  long jdField_c_of_type_Long;
  Object jdField_c_of_type_JavaLangObject = new Object();
  long d;
  
  arud(arub paramarub, long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = 0L;
    this.d = 0L;
    this.jdField_b_of_type_Int = -1;
  }
  
  long a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      long l = this.jdField_c_of_type_Long;
      return l;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      QLog.i(arub.jdField_a_of_type_JavaLangString, 1, "[UniformDL] setStatus:" + this.jdField_a_of_type_Int + " -> " + paramInt + "url:" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
  }
  
  long b()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      long l = this.d;
      return l;
    }
  }
  
  void b(long paramLong)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.d = paramLong;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arud
 * JD-Core Version:    0.7.0.1
 */