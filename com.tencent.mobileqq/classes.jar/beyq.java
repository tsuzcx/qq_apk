import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class beyq
{
  private final int jdField_a_of_type_Int;
  public aqdz a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  private int d;
  
  public beyq(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    c();
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      beyp.a(localAppRuntime, i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(this.d) });
      c();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.d = 0;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    beyq localbeyq = (beyq)beyp.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localbeyq != null) && (localbeyq.jdField_a_of_type_Boolean)) {
      localbeyq.b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.c = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    beyp.a().put(Integer.valueOf(this.jdField_a_of_type_Int), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyq
 * JD-Core Version:    0.7.0.1
 */