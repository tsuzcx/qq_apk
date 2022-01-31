import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class awqo
  extends awqq
{
  public awqo(baxk parambaxk, awqu paramawqu)
  {
    super(parambaxk, paramawqu);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    if (TextUtils.isEmpty(paramawog.c()))
    {
      paramawwp.c().setVisibility(8);
      ((awwi)paramawwp).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramawwp.d() != null)
      {
        paramawog = paramawog.d();
        if (!TextUtils.isEmpty(paramawog)) {
          break;
        }
        paramawwp.d().setVisibility(8);
      }
      return;
      paramawwp.c().setVisibility(0);
      paramawwp.c().setText(paramawog.c());
      ((awwi)paramawwp).a().setVisibility(8);
    }
    paramawwp.d().setVisibility(0);
    paramawwp.d().setText(paramawog);
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    super.c(paramawog, paramawwp);
    ((awwi)paramawwp).a().setOnClickListener(new awqp(this, paramawog));
  }
  
  public void d(awog paramawog, awwp paramawwp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqo
 * JD-Core Version:    0.7.0.1
 */