import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class bcnm
  extends bcnn
{
  public Button a;
  
  public bcnm(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371981));
    this.e = ((ImageView)this.b.findViewById(2131361796));
    this.i = ((TextView)this.b.findViewById(2131376609));
    this.k = ((TextView)this.b.findViewById(2131377905));
    this.a = ((Button)this.b.findViewById(2131376596));
    this.a.setText(anvx.a(2131689550));
    this.j = ((TextView)this.b.findViewById(2131376606));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnm
 * JD-Core Version:    0.7.0.1
 */