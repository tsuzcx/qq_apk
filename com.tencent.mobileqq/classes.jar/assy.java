import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class assy
{
  private static AtomicInteger a;
  public int a;
  public FontBubble a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public assy(FontBubble paramFontBubble)
  {
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble = paramFontBubble;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FontBubbleManager", 1, "setFontBubble: " + this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId + "," + this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId);
    }
    ((amca)paramQQAppInterface.a(13)).a(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId, this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assy
 * JD-Core Version:    0.7.0.1
 */