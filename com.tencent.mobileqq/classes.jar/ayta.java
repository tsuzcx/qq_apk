import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.rich.RichNodeRootLayout;

public abstract class ayta
  implements aysq
{
  private View jdField_a_of_type_AndroidViewView;
  public ayso a;
  private RichNodeRootLayout jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout;
  private View b;
  
  public ayta(ayso paramayso, Context paramContext)
  {
    this.jdField_a_of_type_Ayso = paramayso;
    a(paramContext);
  }
  
  public final View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout;
  }
  
  public abstract View a(Context paramContext);
  
  public View a(String paramString)
  {
    return null;
  }
  
  public ImageView a()
  {
    return null;
  }
  
  public TextView a()
  {
    return null;
  }
  
  public ayso a()
  {
    return this.jdField_a_of_type_Ayso;
  }
  
  public String a()
  {
    ayso localayso = a();
    if (localayso != null) {
      return localayso.a();
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561264, null, false);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = ((RichNodeRootLayout)localView.findViewById(2131376044));
    this.b = localView.findViewById(2131365355);
    this.jdField_a_of_type_AndroidViewView = a(paramContext);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout.addView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBoolean) {
        this.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.b.setVisibility(8);
  }
  
  public ImageView b()
  {
    return null;
  }
  
  public TextView b()
  {
    return null;
  }
  
  public void b(boolean paramBoolean) {}
  
  public TextView c()
  {
    return null;
  }
  
  public TextView d()
  {
    return null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ayso = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.b = null;
  }
  
  public void f()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayta
 * JD-Core Version:    0.7.0.1
 */