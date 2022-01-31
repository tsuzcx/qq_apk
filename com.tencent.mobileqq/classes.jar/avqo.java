import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMFollwerAdd;

public class avqo
  extends avqe
{
  public QIMFollwerAdd a;
  
  public avqo(QIMFollwerAdd paramQIMFollwerAdd)
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
 * Qualified Name:     avqo
 * JD-Core Version:    0.7.0.1
 */