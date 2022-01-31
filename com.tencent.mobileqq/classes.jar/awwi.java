import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class awwi
  extends awwj
{
  public Button a;
  
  public awwi(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131370832));
    this.e = ((ImageView)this.b.findViewById(2131361795));
    this.i = ((TextView)this.b.findViewById(2131375194));
    this.k = ((TextView)this.b.findViewById(2131376339));
    this.a = ((Button)this.b.findViewById(2131375181));
    this.a.setText(ajyc.a(2131689628));
    this.j = ((TextView)this.b.findViewById(2131375191));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwi
 * JD-Core Version:    0.7.0.1
 */