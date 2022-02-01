import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aqug
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private aqrf jdField_a_of_type_Aqrf;
  private aqrn jdField_a_of_type_Aqrn;
  
  public aqug(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqrf = new aqrf();
    this.jdField_a_of_type_Aqrf.a(new aqrh());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Aqrn != null) {
      return this.jdField_a_of_type_Aqrn.getColorNote();
    }
    return null;
  }
  
  public aqrn a()
  {
    return this.jdField_a_of_type_Aqrn;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Aqrn != null) {
      return this.jdField_a_of_type_Aqrn.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Aqrf.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        bdll.b(null, "dc00898", "", "", "0X800A743", "0X800A743", aqrd.a(this.jdField_a_of_type_Aqrn.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(aqrh paramaqrh)
  {
    this.jdField_a_of_type_Aqrf.a(paramaqrh);
  }
  
  public void a(aqrn paramaqrn)
  {
    this.jdField_a_of_type_Aqrn = paramaqrn;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Aqrf.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aqrf.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqrn != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqrn.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType());
        bdll.b(null, "dc00898", "", "", "0X800A748", "0X800A748", aqrd.a(this.jdField_a_of_type_Aqrn.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aqrn != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqrn.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Aqrf.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    aqsd.a(this.jdField_a_of_type_AndroidContentContext);
    bdll.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqug
 * JD-Core Version:    0.7.0.1
 */