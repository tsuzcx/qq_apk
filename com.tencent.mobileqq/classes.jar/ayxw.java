import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ayxw
  extends ayvx
{
  private View a;
  public Button a;
  
  public ayxw(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371161));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131375729));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131375716));
    this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131689628));
    this.k = ((TextView)this.b.findViewById(2131376899));
    this.j = ((TextView)this.b.findViewById(2131375726));
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131378980);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxw
 * JD-Core Version:    0.7.0.1
 */