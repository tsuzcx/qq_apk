import com.tencent.qphone.base.util.QLog;

class aowh
  implements apgr
{
  aowh(aowg paramaowg, aowi paramaowi) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_Aowg.a = true;
    this.jdField_a_of_type_Aowi.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Aowi.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aowh
 * JD-Core Version:    0.7.0.1
 */