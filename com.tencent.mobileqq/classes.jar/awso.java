import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class awso
  extends awqs
{
  public awso(baxy parambaxy, awqw paramawqw)
  {
    super(parambaxy, paramawqw);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    if (TextUtils.isEmpty(paramawoi.c()))
    {
      paramawwr.c().setVisibility(8);
      ((awyk)paramawwr).a().setVisibility(0);
      if (paramawwr.b() != null)
      {
        paramawoi = ((awps)paramawoi).d();
        if (!TextUtils.isEmpty(paramawoi)) {
          break label127;
        }
        paramawwr.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramawwr.d().setVisibility(8);
      return;
      paramawwr.c().setVisibility(0);
      paramawwr.c().setText(paramawoi.c());
      ((awyk)paramawwr).a().setVisibility(8);
      break;
      label127:
      paramawwr.b().setVisibility(0);
      paramawwr.b().setText(paramawoi);
    }
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    super.c(paramawoi, paramawwr);
    ((awyk)paramawwr).a().setOnClickListener(new awsp(this, paramawoi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awso
 * JD-Core Version:    0.7.0.1
 */