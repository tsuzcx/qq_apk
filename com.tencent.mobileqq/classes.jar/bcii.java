import android.widget.TextView;

public class bcii
  extends bcji
{
  public bcii(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((parambcfr instanceof bcdg))
    {
      bcdg localbcdg = (bcdg)parambcfr;
      localTextView = ((bcnv)parambcnz).e();
      parambcfr = ((bcnv)parambcnz).f();
      parambcnz = ((bcnv)parambcnz).g();
      if (localTextView != null)
      {
        localCharSequence = localbcdg.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (parambcnz != null) {
          parambcnz.setVisibility(8);
        }
      }
      if (parambcfr != null)
      {
        parambcnz = localbcdg.f();
        if (parambcnz != null) {
          break label115;
        }
        parambcfr.setText("");
      }
    }
    label96:
    label115:
    do
    {
      do
      {
        return;
        localTextView.setText(localCharSequence);
        if (parambcnz == null) {
          break;
        }
        parambcnz.setVisibility(0);
        break;
        parambcfr.setText(parambcnz);
        return;
      } while (!(parambcfr instanceof bcdf));
      parambcfr = (bcdf)parambcfr;
      parambcnz = ((bcnv)parambcnz).h();
    } while (parambcnz == null);
    parambcfr = parambcfr.e();
    if (parambcfr == null)
    {
      parambcnz.setText("");
      return;
    }
    parambcnz.setText(parambcfr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcii
 * JD-Core Version:    0.7.0.1
 */