import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class awqq
  extends awqs
{
  public awqq(baxy parambaxy, awqw paramawqw)
  {
    super(parambaxy, paramawqw);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    if (TextUtils.isEmpty(paramawoi.c()))
    {
      paramawwr.c().setVisibility(8);
      ((awwk)paramawwr).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramawwr.d() != null)
      {
        paramawoi = paramawoi.d();
        if (!TextUtils.isEmpty(paramawoi)) {
          break;
        }
        paramawwr.d().setVisibility(8);
      }
      return;
      paramawwr.c().setVisibility(0);
      paramawwr.c().setText(paramawoi.c());
      ((awwk)paramawwr).a().setVisibility(8);
    }
    paramawwr.d().setVisibility(0);
    paramawwr.d().setText(paramawoi);
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    super.c(paramawoi, paramawwr);
    ((awwk)paramawwr).a().setOnClickListener(new awqr(this, paramawoi));
  }
  
  public void d(awoi paramawoi, awwr paramawwr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqq
 * JD-Core Version:    0.7.0.1
 */