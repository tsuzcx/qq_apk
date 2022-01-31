import com.tencent.qphone.base.util.QLog;

class aqpj
  implements aqzt
{
  aqpj(aqpi paramaqpi, aqpk paramaqpk) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_Aqpi.a = true;
    this.jdField_a_of_type_Aqpk.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Aqpk.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpj
 * JD-Core Version:    0.7.0.1
 */