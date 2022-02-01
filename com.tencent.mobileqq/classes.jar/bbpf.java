import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class bbpf
  extends bbph
{
  public bbpf(aobu paramaobu, bbpl parambbpl)
  {
    super(paramaobu, parambbpl);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    if (TextUtils.isEmpty(parambbmy.c()))
    {
      parambbvg.c().setVisibility(8);
      ((bbuz)parambbvg).a().setVisibility(0);
    }
    for (;;)
    {
      if (parambbvg.d() != null)
      {
        parambbmy = parambbmy.d();
        if (!TextUtils.isEmpty(parambbmy)) {
          break;
        }
        parambbvg.d().setVisibility(8);
      }
      return;
      parambbvg.c().setVisibility(0);
      parambbvg.c().setText(parambbmy.c());
      ((bbuz)parambbvg).a().setVisibility(8);
    }
    parambbvg.d().setVisibility(0);
    parambbvg.d().setText(parambbmy);
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    super.c(parambbmy, parambbvg);
    ((bbuz)parambbvg).a().setOnClickListener(new bbpg(this, parambbmy));
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpf
 * JD-Core Version:    0.7.0.1
 */