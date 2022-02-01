import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aqfd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private aqcc jdField_a_of_type_Aqcc;
  private aqck jdField_a_of_type_Aqck;
  
  public aqfd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqcc = new aqcc();
    this.jdField_a_of_type_Aqcc.a(new aqce());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Aqck != null) {
      return this.jdField_a_of_type_Aqck.getColorNote();
    }
    return null;
  }
  
  public aqck a()
  {
    return this.jdField_a_of_type_Aqck;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Aqck != null) {
      return this.jdField_a_of_type_Aqck.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Aqcc.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        bcst.b(null, "dc00898", "", "", "0X800A743", "0X800A743", aqca.a(this.jdField_a_of_type_Aqck.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(aqce paramaqce)
  {
    this.jdField_a_of_type_Aqcc.a(paramaqce);
  }
  
  public void a(aqck paramaqck)
  {
    this.jdField_a_of_type_Aqck = paramaqck;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Aqcc.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aqcc.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqck != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqck.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType());
        bcst.b(null, "dc00898", "", "", "0X800A748", "0X800A748", aqca.a(this.jdField_a_of_type_Aqck.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aqck != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqck.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    aqda.a(this.jdField_a_of_type_AndroidContentContext);
    bcst.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfd
 * JD-Core Version:    0.7.0.1
 */