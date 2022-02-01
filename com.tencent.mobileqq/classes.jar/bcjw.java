import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class bcjw
  extends bcia
{
  public bcjw(aoof paramaoof, bcie parambcie)
  {
    super(paramaoof, parambcie);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    if (TextUtils.isEmpty(parambcfr.c()))
    {
      parambcnz.c().setVisibility(8);
      ((bcpq)parambcnz).a().setVisibility(0);
      if (parambcnz.b() != null)
      {
        parambcfr = ((bchb)parambcfr).d();
        if (!TextUtils.isEmpty(parambcfr)) {
          break label127;
        }
        parambcnz.b().setVisibility(8);
      }
    }
    for (;;)
    {
      parambcnz.d().setVisibility(8);
      return;
      parambcnz.c().setVisibility(0);
      parambcnz.c().setText(parambcfr.c());
      ((bcpq)parambcnz).a().setVisibility(8);
      break;
      label127:
      parambcnz.b().setVisibility(0);
      parambcnz.b().setText(parambcfr);
    }
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    super.c(parambcfr, parambcnz);
    ((bcpq)parambcnz).a().setOnClickListener(new bcjx(this, parambcfr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjw
 * JD-Core Version:    0.7.0.1
 */