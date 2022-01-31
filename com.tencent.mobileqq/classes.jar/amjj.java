import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class amjj
{
  private amgp jdField_a_of_type_Amgp;
  private amgw jdField_a_of_type_Amgw;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bbgg jdField_a_of_type_Bbgg;
  
  public amjj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amgp = new amgp();
    this.jdField_a_of_type_Amgp.a(new amgr());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_Amgw != null) {
      return this.jdField_a_of_type_Amgw.getColorNote();
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbgg == null)
    {
      this.jdField_a_of_type_Bbgg = new bbgg(this.jdField_a_of_type_AndroidContentContext, 2131755791);
      this.jdField_a_of_type_Bbgg.setContentView(2131558906);
      this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgg.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690864));
      this.jdField_a_of_type_Bbgg.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690863), new amjk(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgg.show();
      TextView localTextView = this.jdField_a_of_type_Bbgg.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bawi.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.dismiss();
      }
    }
  }
  
  public amgw a()
  {
    return this.jdField_a_of_type_Amgw;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_Amgw != null) {
      return this.jdField_a_of_type_Amgw.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Amgp.a(localColorNote.parseBundle());
      axqw.b(null, "dc00898", "", "", "0X800A743", "0X800A743", amgn.a(this.jdField_a_of_type_Amgw.getColorNote().mServiceType), 0, "", "", "", "");
    }
  }
  
  public void a(amgr paramamgr)
  {
    this.jdField_a_of_type_Amgp.a(paramamgr);
  }
  
  public void a(amgw paramamgw)
  {
    this.jdField_a_of_type_Amgw = paramamgw;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Amgp.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Amgp.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amgw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType());
        axqw.b(null, "dc00898", "", "", "0X800A748", "0X800A748", amgn.a(this.jdField_a_of_type_Amgw.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amgw != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    d();
    axqw.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjj
 * JD-Core Version:    0.7.0.1
 */