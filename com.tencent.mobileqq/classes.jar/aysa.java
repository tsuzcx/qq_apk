import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class aysa
  extends ayqe
{
  public aysa(bdbb parambdbb, ayqi paramayqi)
  {
    super(parambdbb, paramayqi);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    if (TextUtils.isEmpty(paramaynu.c()))
    {
      paramaywd.c().setVisibility(8);
      ((ayxw)paramaywd).a().setVisibility(0);
      if (paramaywd.b() != null)
      {
        paramaynu = ((aype)paramaynu).d();
        if (!TextUtils.isEmpty(paramaynu)) {
          break label127;
        }
        paramaywd.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramaywd.d().setVisibility(8);
      return;
      paramaywd.c().setVisibility(0);
      paramaywd.c().setText(paramaynu.c());
      ((ayxw)paramaywd).a().setVisibility(8);
      break;
      label127:
      paramaywd.b().setVisibility(0);
      paramaywd.b().setText(paramaynu);
    }
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    super.c(paramaynu, paramaywd);
    ((ayxw)paramaywd).a().setOnClickListener(new aysb(this, paramaynu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysa
 * JD-Core Version:    0.7.0.1
 */