import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;

public class aqlx
  implements aqlz
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aqml jdField_a_of_type_Aqml;
  private aqng jdField_a_of_type_Aqng;
  private aqon jdField_a_of_type_Aqon;
  private aqng b;
  
  public aqlx(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqng a()
  {
    return this.jdField_a_of_type_Aqng;
  }
  
  public void a()
  {
    aqma localaqma = new aqma();
    this.jdField_a_of_type_Aqng = localaqma.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Aqng == null)
    {
      aqmd.a().a().a("GalleryBuilder", 4, "buildPresenter presenter is null!");
      return;
    }
    this.jdField_a_of_type_Aqng.a(this.b);
    this.jdField_a_of_type_Aqon = localaqma.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqng);
    this.jdField_a_of_type_Aqng.a(this.jdField_a_of_type_Aqon);
    this.jdField_a_of_type_Aqml = localaqma.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqng);
    this.jdField_a_of_type_Aqng.a(this.jdField_a_of_type_Aqml);
    this.jdField_a_of_type_Aqng.c();
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqng != null) {
      this.jdField_a_of_type_Aqng.a(paramIntent);
    }
    if (this.jdField_a_of_type_Aqon != null) {
      this.jdField_a_of_type_Aqon.a(paramIntent);
    }
    if (this.jdField_a_of_type_Aqml != null) {
      this.jdField_a_of_type_Aqml.a(paramIntent);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aqon != null) {
      this.jdField_a_of_type_Aqon.a(paramViewGroup);
    }
  }
  
  public void a(aqng paramaqng)
  {
    this.b = paramaqng;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqml != null) {
      this.jdField_a_of_type_Aqml.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aqng != null) {
      this.jdField_a_of_type_Aqng.d();
    }
    if (this.jdField_a_of_type_Aqon != null) {
      this.jdField_a_of_type_Aqon.b();
    }
    if (this.jdField_a_of_type_Aqml != null) {
      this.jdField_a_of_type_Aqml.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlx
 * JD-Core Version:    0.7.0.1
 */