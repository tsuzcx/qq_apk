import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class avwp
  extends avwq
{
  public Button a;
  
  public avwp(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131305159));
    this.e = ((ImageView)this.b.findViewById(2131296259));
    this.i = ((TextView)this.b.findViewById(2131309446));
    this.k = ((TextView)this.b.findViewById(2131310547));
    this.a = ((Button)this.b.findViewById(2131309433));
    this.a.setText(ajjy.a(2131624088));
    this.j = ((TextView)this.b.findViewById(2131309443));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwp
 * JD-Core Version:    0.7.0.1
 */