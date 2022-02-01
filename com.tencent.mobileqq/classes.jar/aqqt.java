import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aqqt
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private aqns jdField_a_of_type_Aqns;
  private aqoa jdField_a_of_type_Aqoa;
  
  public aqqt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqns = new aqns();
    this.jdField_a_of_type_Aqns.a(new aqnu());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Aqoa != null) {
      return this.jdField_a_of_type_Aqoa.getColorNote();
    }
    return null;
  }
  
  public aqoa a()
  {
    return this.jdField_a_of_type_Aqoa;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Aqoa != null) {
      return this.jdField_a_of_type_Aqoa.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Aqns.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        bdla.b(null, "dc00898", "", "", "0X800A743", "0X800A743", aqnq.a(this.jdField_a_of_type_Aqoa.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(aqnu paramaqnu)
  {
    this.jdField_a_of_type_Aqns.a(paramaqnu);
  }
  
  public void a(aqoa paramaqoa)
  {
    this.jdField_a_of_type_Aqoa = paramaqoa;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Aqns.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aqns.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqoa != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType());
        bdla.b(null, "dc00898", "", "", "0X800A748", "0X800A748", aqnq.a(this.jdField_a_of_type_Aqoa.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aqoa != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    aqoq.a(this.jdField_a_of_type_AndroidContentContext);
    bdla.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqt
 * JD-Core Version:    0.7.0.1
 */