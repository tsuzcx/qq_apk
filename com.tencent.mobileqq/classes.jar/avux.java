import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMFollwerAdd;

public class avux
  extends avun
{
  public QIMFollwerAdd a;
  
  public avux(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd = paramQIMFollwerAdd;
    this.jdField_a_of_type_Long = paramQIMFollwerAdd.upTime;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd.uin);
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return "getMessage";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd.isRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avux
 * JD-Core Version:    0.7.0.1
 */