import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class bkyw
{
  private static volatile bkyw jdField_a_of_type_Bkyw;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static bkyw a()
  {
    if (jdField_a_of_type_Bkyw == null) {}
    try
    {
      if (jdField_a_of_type_Bkyw == null) {
        jdField_a_of_type_Bkyw = new bkyw();
      }
      return jdField_a_of_type_Bkyw;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      bkzt localbkzt = (bkzt)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bkyy(this, localAppInterface));
      localbkzt.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new bkyx(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyw
 * JD-Core Version:    0.7.0.1
 */