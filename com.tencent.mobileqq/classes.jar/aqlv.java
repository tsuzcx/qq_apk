import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;

public class aqlv
  implements aqlx
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aqmj jdField_a_of_type_Aqmj;
  private aqne jdField_a_of_type_Aqne;
  private aqol jdField_a_of_type_Aqol;
  private aqne b;
  
  public aqlv(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqne a()
  {
    return this.jdField_a_of_type_Aqne;
  }
  
  public void a()
  {
    aqly localaqly = new aqly();
    this.jdField_a_of_type_Aqne = localaqly.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Aqne == null)
    {
      aqmb.a().a().a("GalleryBuilder", 4, "buildPresenter presenter is null!");
      return;
    }
    this.jdField_a_of_type_Aqne.a(this.b);
    this.jdField_a_of_type_Aqol = localaqly.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqne);
    this.jdField_a_of_type_Aqne.a(this.jdField_a_of_type_Aqol);
    this.jdField_a_of_type_Aqmj = localaqly.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqne);
    this.jdField_a_of_type_Aqne.a(this.jdField_a_of_type_Aqmj);
    this.jdField_a_of_type_Aqne.c();
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqne != null) {
      this.jdField_a_of_type_Aqne.a(paramIntent);
    }
    if (this.jdField_a_of_type_Aqol != null) {
      this.jdField_a_of_type_Aqol.a(paramIntent);
    }
    if (this.jdField_a_of_type_Aqmj != null) {
      this.jdField_a_of_type_Aqmj.a(paramIntent);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aqol != null) {
      this.jdField_a_of_type_Aqol.a(paramViewGroup);
    }
  }
  
  public void a(aqne paramaqne)
  {
    this.b = paramaqne;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqmj != null) {
      this.jdField_a_of_type_Aqmj.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aqne != null) {
      this.jdField_a_of_type_Aqne.d();
    }
    if (this.jdField_a_of_type_Aqol != null) {
      this.jdField_a_of_type_Aqol.b();
    }
    if (this.jdField_a_of_type_Aqmj != null) {
      this.jdField_a_of_type_Aqmj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlv
 * JD-Core Version:    0.7.0.1
 */