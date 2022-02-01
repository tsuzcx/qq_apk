import com.tencent.qphone.base.util.QLog;

public class axwr
{
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private axws jdField_a_of_type_Axws;
  private String jdField_a_of_type_JavaLangString;
  private double jdField_b_of_type_Double = 0.0D;
  private int jdField_b_of_type_Int;
  
  axwr(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  void a()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int - 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeSampler", 2, "[status][sampler] " + this.jdField_a_of_type_JavaLangString + " sample. count: " + this.jdField_b_of_type_Int + " value: " + paramDouble + " total: " + this.jdField_a_of_type_Double);
      }
      this.jdField_a_of_type_Double += paramDouble;
      this.jdField_b_of_type_Double = Math.max(this.jdField_b_of_type_Double, paramDouble);
      this.jdField_b_of_type_Int += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      this.jdField_a_of_type_Double += paramDouble;
      if (l - this.jdField_a_of_type_Long < 30L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TimeSampler", 2, "[status][sampler] " + this.jdField_a_of_type_JavaLangString + " sample. batch mode count: " + this.jdField_b_of_type_Int + " value: " + paramDouble + " total: " + this.jdField_a_of_type_Double);
        }
        this.jdField_b_of_type_Double = Math.max(this.jdField_b_of_type_Double, paramDouble);
        this.jdField_b_of_type_Int += 1;
        return;
      }
      double d = this.jdField_a_of_type_Double / (this.jdField_b_of_type_Int + 1);
      if (QLog.isColorLevel()) {
        QLog.d("TimeSampler", 2, "[status][sampler] " + this.jdField_a_of_type_JavaLangString + " sample. triggered count: " + this.jdField_b_of_type_Int + " value: " + paramDouble + " total: " + this.jdField_a_of_type_Double + " ave: " + d);
      }
      if (this.jdField_a_of_type_Axws != null) {
        this.jdField_a_of_type_Axws.a(d, this.jdField_b_of_type_Double);
      }
      a();
    }
  }
  
  void a(axws paramaxws)
  {
    this.jdField_a_of_type_Axws = paramaxws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwr
 * JD-Core Version:    0.7.0.1
 */