import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class ayqc
  extends ayqe
{
  public ayqc(bdbb parambdbb, ayqi paramayqi)
  {
    super(parambdbb, paramayqi);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    if (TextUtils.isEmpty(paramaynu.c()))
    {
      paramaywd.c().setVisibility(8);
      ((ayvw)paramaywd).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramaywd.d() != null)
      {
        paramaynu = paramaynu.d();
        if (!TextUtils.isEmpty(paramaynu)) {
          break;
        }
        paramaywd.d().setVisibility(8);
      }
      return;
      paramaywd.c().setVisibility(0);
      paramaywd.c().setText(paramaynu.c());
      ((ayvw)paramaywd).a().setVisibility(8);
    }
    paramaywd.d().setVisibility(0);
    paramaywd.d().setText(paramaynu);
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    super.c(paramaynu, paramaywd);
    ((ayvw)paramaywd).a().setOnClickListener(new ayqd(this, paramaynu));
  }
  
  public void d(aynu paramaynu, aywd paramaywd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqc
 * JD-Core Version:    0.7.0.1
 */