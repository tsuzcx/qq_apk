import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aoes
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private aobx jdField_a_of_type_Aobx;
  private aocf jdField_a_of_type_Aocf;
  private bdjz jdField_a_of_type_Bdjz;
  
  public aoes(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aobx = new aobx();
    this.jdField_a_of_type_Aobx.a(new aobz());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Aocf != null) {
      return this.jdField_a_of_type_Aocf.getColorNote();
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bdjz == null)
    {
      this.jdField_a_of_type_Bdjz = new bdjz(this.jdField_a_of_type_AndroidContentContext, 2131755801);
      this.jdField_a_of_type_Bdjz.setContentView(2131558942);
      this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdjz.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690917));
      this.jdField_a_of_type_Bdjz.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690916), new aoet(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdjz.show();
      TextView localTextView = this.jdField_a_of_type_Bdjz.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bczz.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
    }
  }
  
  public aocf a()
  {
    return this.jdField_a_of_type_Aocf;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Aocf != null) {
      return this.jdField_a_of_type_Aocf.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Aobx.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        azqs.b(null, "dc00898", "", "", "0X800A743", "0X800A743", aobv.a(this.jdField_a_of_type_Aocf.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(aobz paramaobz)
  {
    this.jdField_a_of_type_Aobx.a(paramaobz);
  }
  
  public void a(aocf paramaocf)
  {
    this.jdField_a_of_type_Aocf = paramaocf;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Aobx.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aobx.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aocf != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType());
        azqs.b(null, "dc00898", "", "", "0X800A748", "0X800A748", aobv.a(this.jdField_a_of_type_Aocf.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aocf != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    d();
    azqs.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoes
 * JD-Core Version:    0.7.0.1
 */