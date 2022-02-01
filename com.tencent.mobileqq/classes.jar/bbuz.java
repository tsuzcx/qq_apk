import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class bbuz
  extends bbva
{
  public Button a;
  
  public bbuz(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371720));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131376456));
    this.k = ((TextView)this.b.findViewById(2131377713));
    this.a = ((Button)this.b.findViewById(2131376443));
    this.a.setText(anni.a(2131689550));
    this.j = ((TextView)this.b.findViewById(2131376453));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuz
 * JD-Core Version:    0.7.0.1
 */