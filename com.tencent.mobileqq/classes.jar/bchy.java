import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class bchy
  extends bcia
{
  public bchy(aoof paramaoof, bcie parambcie)
  {
    super(paramaoof, parambcie);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    if (TextUtils.isEmpty(parambcfr.c()))
    {
      parambcnz.c().setVisibility(8);
      ((bcns)parambcnz).a().setVisibility(0);
    }
    for (;;)
    {
      if (parambcnz.d() != null)
      {
        parambcfr = parambcfr.d();
        if (!TextUtils.isEmpty(parambcfr)) {
          break;
        }
        parambcnz.d().setVisibility(8);
      }
      return;
      parambcnz.c().setVisibility(0);
      parambcnz.c().setText(parambcfr.c());
      ((bcns)parambcnz).a().setVisibility(8);
    }
    parambcnz.d().setVisibility(0);
    parambcnz.d().setText(parambcfr);
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    super.c(parambcfr, parambcnz);
    ((bcns)parambcnz).a().setOnClickListener(new bchz(this, parambcfr));
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchy
 * JD-Core Version:    0.7.0.1
 */