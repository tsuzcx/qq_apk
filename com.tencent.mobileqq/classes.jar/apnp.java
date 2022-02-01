import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class apnp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private apko jdField_a_of_type_Apko;
  private apkw jdField_a_of_type_Apkw;
  
  public apnp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apko = new apko();
    this.jdField_a_of_type_Apko.a(new apkq());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Apkw != null) {
      return this.jdField_a_of_type_Apkw.getColorNote();
    }
    return null;
  }
  
  public apkw a()
  {
    return this.jdField_a_of_type_Apkw;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Apkw != null) {
      return this.jdField_a_of_type_Apkw.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Apko.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        bcef.b(null, "dc00898", "", "", "0X800A743", "0X800A743", apkm.a(this.jdField_a_of_type_Apkw.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(apkq paramapkq)
  {
    this.jdField_a_of_type_Apko.a(paramapkq);
  }
  
  public void a(apkw paramapkw)
  {
    this.jdField_a_of_type_Apkw = paramapkw;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Apko.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Apko.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apkw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType());
        bcef.b(null, "dc00898", "", "", "0X800A748", "0X800A748", apkm.a(this.jdField_a_of_type_Apkw.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apkw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    aplm.a(this.jdField_a_of_type_AndroidContentContext);
    bcef.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnp
 * JD-Core Version:    0.7.0.1
 */