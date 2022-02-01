import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class anym
{
  private int jdField_a_of_type_Int;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private int b;
  
  public anym(MessageHandler paramMessageHandler, StringBuilder paramStringBuilder, int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public anym a()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler).size();
    Iterator localIterator = MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler).keySet().iterator();
    label232:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.j(str);
      Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.b(str);
      if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {}
      for (long l1 = ((Long)arrayOfObject[1]).longValue();; l1 = 0L)
      {
        if (((!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMsgCache().a(false)) && (!((Boolean)MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler).get(str)).booleanValue())) || (l2 >= l1)) {
          break label232;
        }
        if (QLog.isColorLevel())
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          this.jdField_a_of_type_JavaLangStringBuilder.append("---------checkGroupMsgComplete needToPullTroop troopUin: ").append(str).append(",lastSeq:").append(l2).append(",svrSeq:").append(l1);
          QLog.d("Q.msg.MessageHandler", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        localArrayList.add(str);
        break;
      }
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_a_of_type_Int = localArrayList.size();
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, new String[this.jdField_a_of_type_Int]);
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler)[i] = ((String)localArrayList.get(i));
        i += 1;
      }
    }
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler).clear();
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anym
 * JD-Core Version:    0.7.0.1
 */