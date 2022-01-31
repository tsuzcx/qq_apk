import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class awsm
  extends awqq
{
  public awsm(baxk parambaxk, awqu paramawqu)
  {
    super(parambaxk, paramawqu);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    if (TextUtils.isEmpty(paramawog.c()))
    {
      paramawwp.c().setVisibility(8);
      ((awyi)paramawwp).a().setVisibility(0);
      if (paramawwp.b() != null)
      {
        paramawog = ((awpq)paramawog).d();
        if (!TextUtils.isEmpty(paramawog)) {
          break label127;
        }
        paramawwp.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramawwp.d().setVisibility(8);
      return;
      paramawwp.c().setVisibility(0);
      paramawwp.c().setText(paramawog.c());
      ((awyi)paramawwp).a().setVisibility(8);
      break;
      label127:
      paramawwp.b().setVisibility(0);
      paramawwp.b().setText(paramawog);
    }
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    super.c(paramawog, paramawwp);
    ((awyi)paramawwp).a().setOnClickListener(new awsn(this, paramawog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsm
 * JD-Core Version:    0.7.0.1
 */