import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class bbgu
  extends bbgv
{
  public Button a;
  
  public bbgu(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371791));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131376354));
    this.k = ((TextView)this.b.findViewById(2131377631));
    this.a = ((Button)this.b.findViewById(2131376341));
    this.a.setText(amtj.a(2131689550));
    this.j = ((TextView)this.b.findViewById(2131376351));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgu
 * JD-Core Version:    0.7.0.1
 */