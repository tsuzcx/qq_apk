import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;

public class bads
  extends badc<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private baic jdField_a_of_type_Baic;
  
  public bads(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Baic == null)
    {
      this.jdField_a_of_type_Baic = ((baic)baeg.a(1003, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_Baic.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Baic.g();
      a(this.jdField_a_of_type_Baic);
      this.jdField_a_of_type_Long = ((azxr)this.b).jdField_a_of_type_Long;
    }
  }
  
  private boolean b(azxr paramazxr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazxr != null) {
      if (this.jdField_a_of_type_Baic != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Long == paramazxr.jdField_a_of_type_Long) {}
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
    if (this.jdField_a_of_type_Baic != null)
    {
      b(this.jdField_a_of_type_Baic);
      this.jdField_a_of_type_Baic.h();
      this.jdField_a_of_type_Baic = null;
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
  
  public boolean a(azxr paramazxr)
  {
    int i = 0;
    if (b(paramazxr))
    {
      i();
      a();
      i = 1;
    }
    return i | super.a(paramazxr);
  }
  
  public void f()
  {
    i();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bads
 * JD-Core Version:    0.7.0.1
 */