import com.tencent.qphone.base.util.QLog;

class aqts
  implements arec
{
  aqts(aqtr paramaqtr, aqtt paramaqtt) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_Aqtr.a = true;
    this.jdField_a_of_type_Aqtt.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Aqtt.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */