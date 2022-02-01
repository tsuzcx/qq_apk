import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class bopl
{
  private static volatile bopl jdField_a_of_type_Bopl;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static bopl a()
  {
    if (jdField_a_of_type_Bopl == null) {}
    try
    {
      if (jdField_a_of_type_Bopl == null) {
        jdField_a_of_type_Bopl = new bopl();
      }
      return jdField_a_of_type_Bopl;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      boqi localboqi = (boqi)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bopn(this, localAppInterface));
      localboqi.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new bopm(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopl
 * JD-Core Version:    0.7.0.1
 */