import com.tencent.qphone.base.util.QLog;

class atro
  implements ausn
{
  atro(atrn paramatrn, atrp paramatrp) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_Atrn.a = true;
    this.jdField_a_of_type_Atrp.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Atrp.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atro
 * JD-Core Version:    0.7.0.1
 */