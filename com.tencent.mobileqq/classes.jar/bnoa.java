import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class bnoa
{
  private static volatile bnoa jdField_a_of_type_Bnoa;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static bnoa a()
  {
    if (jdField_a_of_type_Bnoa == null) {}
    try
    {
      if (jdField_a_of_type_Bnoa == null) {
        jdField_a_of_type_Bnoa = new bnoa();
      }
      return jdField_a_of_type_Bnoa;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      bnox localbnox = (bnox)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bnoc(this, localAppInterface));
      localbnox.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new bnob(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoa
 * JD-Core Version:    0.7.0.1
 */