import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

public class bkfo
  extends bkfm
{
  public bkfo(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected void a(String paramString)
  {
    ((ImageView)this.a).setBackgroundColor(Color.parseColor(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfo
 * JD-Core Version:    0.7.0.1
 */