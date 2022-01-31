import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class avqv
  extends avqx
{
  public avqv(azwg paramazwg, avrb paramavrb)
  {
    super(paramazwg, paramavrb);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    if (TextUtils.isEmpty(paramavon.c()))
    {
      paramavww.c().setVisibility(8);
      ((avwp)paramavww).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramavww.d() != null)
      {
        paramavon = paramavon.d();
        if (!TextUtils.isEmpty(paramavon)) {
          break;
        }
        paramavww.d().setVisibility(8);
      }
      return;
      paramavww.c().setVisibility(0);
      paramavww.c().setText(paramavon.c());
      ((avwp)paramavww).a().setVisibility(8);
    }
    paramavww.d().setVisibility(0);
    paramavww.d().setText(paramavon);
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    super.c(paramavon, paramavww);
    ((avwp)paramavww).a().setOnClickListener(new avqw(this, paramavon));
  }
  
  public void d(avon paramavon, avww paramavww) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqv
 * JD-Core Version:    0.7.0.1
 */