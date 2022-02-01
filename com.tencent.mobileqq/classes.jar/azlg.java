import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;

public class azlg
  extends azkq<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private azpm jdField_a_of_type_Azpm;
  
  public azlg(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Azpm == null)
    {
      this.jdField_a_of_type_Azpm = ((azpm)azlu.a(1003, this.jdField_a_of_type_Azlw, (azfe)this.b));
      this.jdField_a_of_type_Azpm.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Azpm.g();
      a(this.jdField_a_of_type_Azpm);
      this.jdField_a_of_type_Long = ((azfe)this.b).jdField_a_of_type_Long;
    }
  }
  
  private boolean b(azfe paramazfe)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazfe != null) {
      if (this.jdField_a_of_type_Azpm != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Long == paramazfe.jdField_a_of_type_Long) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Azpm != null)
    {
      b(this.jdField_a_of_type_Azpm);
      this.jdField_a_of_type_Azpm.h();
      this.jdField_a_of_type_Azpm = null;
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public int a()
  {
    return 104;
  }
  
  public String a()
  {
    return "ProfileBgContainer";
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    a();
  }
  
  public boolean a(azfe paramazfe)
  {
    int i = 0;
    if (b(paramazfe))
    {
      i();
      a();
      i = 1;
    }
    return i | super.a(paramazfe);
  }
  
  public void f()
  {
    i();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlg
 * JD-Core Version:    0.7.0.1
 */