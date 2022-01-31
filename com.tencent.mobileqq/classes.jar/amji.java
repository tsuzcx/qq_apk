import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class amji
{
  private amgo jdField_a_of_type_Amgo;
  private amgv jdField_a_of_type_Amgv;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bbgu jdField_a_of_type_Bbgu;
  
  public amji(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amgo = new amgo();
    this.jdField_a_of_type_Amgo.a(new amgq());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Amgv != null) {
      return this.jdField_a_of_type_Amgv.getColorNote();
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbgu == null)
    {
      this.jdField_a_of_type_Bbgu = new bbgu(this.jdField_a_of_type_AndroidContentContext, 2131755791);
      this.jdField_a_of_type_Bbgu.setContentView(2131558906);
      this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgu.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690864));
      this.jdField_a_of_type_Bbgu.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690863), new amjj(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgu.show();
      TextView localTextView = this.jdField_a_of_type_Bbgu.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      baww.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
    }
  }
  
  public amgv a()
  {
    return this.jdField_a_of_type_Amgv;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Amgv != null) {
      return this.jdField_a_of_type_Amgv.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Amgo.a(localColorNote.parseBundle());
      axqy.b(null, "dc00898", "", "", "0X800A743", "0X800A743", amgm.a(this.jdField_a_of_type_Amgv.getColorNote().mServiceType), 0, "", "", "", "");
    }
  }
  
  public void a(amgq paramamgq)
  {
    this.jdField_a_of_type_Amgo.a(paramamgq);
  }
  
  public void a(amgv paramamgv)
  {
    this.jdField_a_of_type_Amgv = paramamgv;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Amgo.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Amgo.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amgv != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType());
        axqy.b(null, "dc00898", "", "", "0X800A748", "0X800A748", amgm.a(this.jdField_a_of_type_Amgv.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amgv != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    d();
    axqy.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amji
 * JD-Core Version:    0.7.0.1
 */