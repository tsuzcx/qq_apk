import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aoaj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private anxo jdField_a_of_type_Anxo;
  private anxw jdField_a_of_type_Anxw;
  private bdfq jdField_a_of_type_Bdfq;
  
  public aoaj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Anxo = new anxo();
    this.jdField_a_of_type_Anxo.a(new anxq());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Anxw != null) {
      return this.jdField_a_of_type_Anxw.getColorNote();
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = new bdfq(this.jdField_a_of_type_AndroidContentContext, 2131755801);
      this.jdField_a_of_type_Bdfq.setContentView(2131558943);
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdfq.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690916));
      this.jdField_a_of_type_Bdfq.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690915), new aoak(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdfq.show();
      TextView localTextView = this.jdField_a_of_type_Bdfq.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bcvq.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.dismiss();
      }
    }
  }
  
  public anxw a()
  {
    return this.jdField_a_of_type_Anxw;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Anxw != null) {
      return this.jdField_a_of_type_Anxw.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Anxo.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        azmj.b(null, "dc00898", "", "", "0X800A743", "0X800A743", anxm.a(this.jdField_a_of_type_Anxw.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(anxq paramanxq)
  {
    this.jdField_a_of_type_Anxo.a(paramanxq);
  }
  
  public void a(anxw paramanxw)
  {
    this.jdField_a_of_type_Anxw = paramanxw;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Anxo.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Anxo.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anxw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType());
        azmj.b(null, "dc00898", "", "", "0X800A748", "0X800A748", anxm.a(this.jdField_a_of_type_Anxw.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Anxw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    d();
    azmj.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoaj
 * JD-Core Version:    0.7.0.1
 */