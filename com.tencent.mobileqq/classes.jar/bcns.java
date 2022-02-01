import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class bcns
  extends bcnt
{
  public Button a;
  
  public bcns(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131371827));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131376588));
    this.k = ((TextView)this.b.findViewById(2131377861));
    this.a = ((Button)this.b.findViewById(2131376575));
    this.a.setText(anzj.a(2131689551));
    this.j = ((TextView)this.b.findViewById(2131376585));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcns
 * JD-Core Version:    0.7.0.1
 */