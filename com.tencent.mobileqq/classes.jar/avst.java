import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class avst
  extends avqx
{
  public avst(azwg paramazwg, avrb paramavrb)
  {
    super(paramazwg, paramavrb);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    if (TextUtils.isEmpty(paramavon.c()))
    {
      paramavww.c().setVisibility(8);
      ((avyp)paramavww).a().setVisibility(0);
      if (paramavww.b() != null)
      {
        paramavon = ((avpx)paramavon).d();
        if (!TextUtils.isEmpty(paramavon)) {
          break label127;
        }
        paramavww.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramavww.d().setVisibility(8);
      return;
      paramavww.c().setVisibility(0);
      paramavww.c().setText(paramavon.c());
      ((avyp)paramavww).a().setVisibility(8);
      break;
      label127:
      paramavww.b().setVisibility(0);
      paramavww.b().setText(paramavon);
    }
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    super.c(paramavon, paramavww);
    ((avyp)paramavww).a().setOnClickListener(new avsu(this, paramavon));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avst
 * JD-Core Version:    0.7.0.1
 */