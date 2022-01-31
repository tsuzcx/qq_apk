import com.tencent.qphone.base.util.QLog;

class aofn
  implements aopi
{
  aofn(aofm paramaofm, aofo paramaofo) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_Aofm.a = true;
    this.jdField_a_of_type_Aofo.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Aofo.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aofn
 * JD-Core Version:    0.7.0.1
 */