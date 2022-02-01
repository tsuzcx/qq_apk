import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class bbrd
  extends bbph
{
  public bbrd(aobu paramaobu, bbpl parambbpl)
  {
    super(paramaobu, parambbpl);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    if (TextUtils.isEmpty(parambbmy.c()))
    {
      parambbvg.c().setVisibility(8);
      ((bbwz)parambbvg).a().setVisibility(0);
      if (parambbvg.b() != null)
      {
        parambbmy = ((bboi)parambbmy).d();
        if (!TextUtils.isEmpty(parambbmy)) {
          break label127;
        }
        parambbvg.b().setVisibility(8);
      }
    }
    for (;;)
    {
      parambbvg.d().setVisibility(8);
      return;
      parambbvg.c().setVisibility(0);
      parambbvg.c().setText(parambbmy.c());
      ((bbwz)parambbvg).a().setVisibility(8);
      break;
      label127:
      parambbvg.b().setVisibility(0);
      parambbvg.b().setText(parambbmy);
    }
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    super.c(parambbmy, parambbvg);
    ((bbwz)parambbvg).a().setOnClickListener(new bbre(this, parambbmy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrd
 * JD-Core Version:    0.7.0.1
 */