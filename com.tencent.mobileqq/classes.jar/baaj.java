import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import java.util.HashMap;

public class baaj
  extends baam
{
  public baaj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Long b(MessageForPtt paramMessageForPtt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong)) {
      return localLong;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(localLong, paramMessageForPtt);
    return localLong;
  }
  
  public Long a(MessageForPtt paramMessageForPtt)
  {
    long l = b(paramMessageForPtt).longValue();
    new baak(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, Long.valueOf(l)).a();
    return Long.valueOf(l);
  }
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (afxv.h) {
      return a(paramMessageForPtt);
    }
    return b(paramMessageForPtt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baaj
 * JD-Core Version:    0.7.0.1
 */