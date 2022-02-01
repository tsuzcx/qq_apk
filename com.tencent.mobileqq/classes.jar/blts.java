import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class blts
{
  private static volatile blts jdField_a_of_type_Blts;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static blts a()
  {
    if (jdField_a_of_type_Blts == null) {}
    try
    {
      if (jdField_a_of_type_Blts == null) {
        jdField_a_of_type_Blts = new blts();
      }
      return jdField_a_of_type_Blts;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      blup localblup = (blup)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bltu(this, localAppInterface));
      localblup.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new bltt(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blts
 * JD-Core Version:    0.7.0.1
 */