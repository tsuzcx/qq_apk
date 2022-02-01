import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;

public class azxd
  extends azwn<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private bade jdField_a_of_type_Bade;
  
  public azxd(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bade == null)
    {
      this.jdField_a_of_type_Bade = ((bade)azxr.a(1003, this.jdField_a_of_type_Azxt, (azrb)this.b));
      this.jdField_a_of_type_Bade.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Bade.g();
      a(this.jdField_a_of_type_Bade);
      this.jdField_a_of_type_Long = ((azrb)this.b).jdField_a_of_type_Long;
    }
  }
  
  private boolean b(azrb paramazrb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazrb != null) {
      if (this.jdField_a_of_type_Bade != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Long == paramazrb.jdField_a_of_type_Long) {}
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
    if (this.jdField_a_of_type_Bade != null)
    {
      b(this.jdField_a_of_type_Bade);
      this.jdField_a_of_type_Bade.h();
      this.jdField_a_of_type_Bade = null;
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
  
  public boolean a(azrb paramazrb)
  {
    int i = 0;
    if (b(paramazrb))
    {
      i();
      a();
      i = 1;
    }
    return i | super.a(paramazrb);
  }
  
  public void f()
  {
    i();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxd
 * JD-Core Version:    0.7.0.1
 */