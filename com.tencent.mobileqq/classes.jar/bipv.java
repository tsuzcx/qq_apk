import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class bipv
{
  private static volatile bipv jdField_a_of_type_Bipv;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static bipv a()
  {
    if (jdField_a_of_type_Bipv == null) {}
    try
    {
      if (jdField_a_of_type_Bipv == null) {
        jdField_a_of_type_Bipv = new bipv();
      }
      return jdField_a_of_type_Bipv;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      biqw localbiqw = (biqw)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bipx(this, localAppInterface));
      localbiqw.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new bipw(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipv
 * JD-Core Version:    0.7.0.1
 */