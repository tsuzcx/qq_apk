import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class ayvw
  extends ayvx
{
  public Button a;
  
  public ayvw(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371161));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131375729));
    this.k = ((TextView)this.b.findViewById(2131376899));
    this.a = ((Button)this.b.findViewById(2131375716));
    this.a.setText(alud.a(2131689628));
    this.j = ((TextView)this.b.findViewById(2131375726));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvw
 * JD-Core Version:    0.7.0.1
 */