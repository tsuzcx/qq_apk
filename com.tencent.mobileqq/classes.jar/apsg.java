import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;

public class apsg
  implements apsi
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private apsu jdField_a_of_type_Apsu;
  private aptf jdField_a_of_type_Aptf;
  private apul jdField_a_of_type_Apul;
  private aptf b;
  
  public apsg(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aptf a()
  {
    return this.jdField_a_of_type_Aptf;
  }
  
  public void a()
  {
    apsj localapsj = new apsj();
    this.jdField_a_of_type_Aptf = localapsj.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Aptf == null)
    {
      apsm.a().a().a("GalleryBuilder", 4, "buildPresenter presenter is null!");
      return;
    }
    this.jdField_a_of_type_Aptf.a(this.b);
    this.jdField_a_of_type_Apul = localapsj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aptf);
    this.jdField_a_of_type_Aptf.a(this.jdField_a_of_type_Apul);
    this.jdField_a_of_type_Apsu = localapsj.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aptf);
    this.jdField_a_of_type_Aptf.a(this.jdField_a_of_type_Apsu);
    this.jdField_a_of_type_Aptf.c();
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aptf != null) {
      this.jdField_a_of_type_Aptf.a(paramIntent);
    }
    if (this.jdField_a_of_type_Apul != null) {
      this.jdField_a_of_type_Apul.a(paramIntent);
    }
    if (this.jdField_a_of_type_Apsu != null) {
      this.jdField_a_of_type_Apsu.a(paramIntent);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Apul != null) {
      this.jdField_a_of_type_Apul.a(paramViewGroup);
    }
  }
  
  public void a(aptf paramaptf)
  {
    this.b = paramaptf;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apsu != null) {
      this.jdField_a_of_type_Apsu.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aptf != null) {
      this.jdField_a_of_type_Aptf.d();
    }
    if (this.jdField_a_of_type_Apul != null) {
      this.jdField_a_of_type_Apul.b();
    }
    if (this.jdField_a_of_type_Apsu != null) {
      this.jdField_a_of_type_Apsu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsg
 * JD-Core Version:    0.7.0.1
 */