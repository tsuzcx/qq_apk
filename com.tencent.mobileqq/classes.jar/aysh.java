import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;

public class aysh
  extends ayrr<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private ayxt jdField_a_of_type_Ayxt;
  
  public aysh(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ayxt == null)
    {
      this.jdField_a_of_type_Ayxt = ((ayxt)aysv.a(1003, this.jdField_a_of_type_Aysx, (aymg)this.b));
      this.jdField_a_of_type_Ayxt.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Ayxt.g();
      a(this.jdField_a_of_type_Ayxt);
      this.jdField_a_of_type_Long = ((aymg)this.b).jdField_a_of_type_Long;
    }
  }
  
  private boolean b(aymg paramaymg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaymg != null) {
      if (this.jdField_a_of_type_Ayxt != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Long == paramaymg.jdField_a_of_type_Long) {}
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
    if (this.jdField_a_of_type_Ayxt != null)
    {
      b(this.jdField_a_of_type_Ayxt);
      this.jdField_a_of_type_Ayxt.h();
      this.jdField_a_of_type_Ayxt = null;
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
  
  public boolean a(aymg paramaymg)
  {
    int i = 0;
    if (b(paramaymg))
    {
      i();
      a();
      i = 1;
    }
    return i | super.a(paramaymg);
  }
  
  public void f()
  {
    i();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysh
 * JD-Core Version:    0.7.0.1
 */