import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;

public class avuy
  extends avun
{
  public QIMNotifyAddFriend a;
  
  public avuy(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    this.jdField_a_of_type_Long = paramQIMNotifyAddFriend.pushTime;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend.uin);
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return "getMessage";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend.hasRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avuy
 * JD-Core Version:    0.7.0.1
 */